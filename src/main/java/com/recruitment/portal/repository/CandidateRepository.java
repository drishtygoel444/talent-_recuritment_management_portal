package com.recruitment.portal.repository;

import com.recruitment.portal.entity.Candidate;
import com.recruitment.portal.entity.RecruitmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findByJobId(Long jobId);
    List<Candidate> findByStatus(RecruitmentStatus status);
}
