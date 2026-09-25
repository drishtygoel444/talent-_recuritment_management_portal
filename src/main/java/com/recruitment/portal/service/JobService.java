package com.recruitment.portal.service;

import com.recruitment.portal.entity.Job;
import com.recruitment.portal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getActiveJobs() {
        return jobRepository.findByActiveTrue();
    }

    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Job ID: " + id));
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
