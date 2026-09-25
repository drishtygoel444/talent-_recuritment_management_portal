package com.recruitment.portal.service;

import com.recruitment.portal.entity.Candidate;
import com.recruitment.portal.entity.RecruitmentStatus;
import com.recruitment.portal.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Candidate ID: " + id));
    }

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateStatus(Long candidateId, RecruitmentStatus newStatus) {
        Candidate candidate = getCandidateById(candidateId);
        candidate.setStatus(newStatus);
        return candidateRepository.save(candidate);
    }

    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
