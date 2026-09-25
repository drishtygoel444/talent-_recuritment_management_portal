package com.recruitment.portal.controller;

import com.recruitment.portal.entity.Candidate;
import com.recruitment.portal.entity.RecruitmentStatus;
import com.recruitment.portal.service.CandidateService;
import com.recruitment.portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private JobService jobService;

    @GetMapping
    public String listCandidates(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        model.addAttribute("statuses", RecruitmentStatus.values());
        return "candidates";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("candidate", new Candidate());
        model.addAttribute("jobs", jobService.getActiveJobs());
        return "candidate-form";
    }

    @PostMapping
    public String saveCandidate(@ModelAttribute("candidate") Candidate candidate) {
        candidateService.saveCandidate(candidate);
        return "redirect:/candidates";
    }

    @PostMapping("/{id}/status")
    public String updateStatus(@PathVariable Long id, @RequestParam RecruitmentStatus status) {
        candidateService.updateStatus(id, status);
        return "redirect:/candidates";
    }

    @GetMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        candidateService.deleteCandidate(id);
        return "redirect:/candidates";
    }
}
