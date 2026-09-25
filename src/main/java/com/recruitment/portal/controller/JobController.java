package com.recruitment.portal.controller;

import com.recruitment.portal.entity.Job;
import com.recruitment.portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping
    public String listJobs(Model model) {
        model.addAttribute("jobs", jobService.getAllJobs());
        return "jobs";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("job", new Job());
        return "job-form";
    }

    @PostMapping
    public String saveJob(@ModelAttribute("job") Job job) {
        jobService.saveJob(job);
        return "redirect:/jobs";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("job", jobService.getJobById(id));
        return "job-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }
}
