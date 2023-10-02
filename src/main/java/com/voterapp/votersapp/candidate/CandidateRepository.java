package com.voterapp.votersapp.repositories;

import com.voterapp.votersapp.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsCandidateByEmail(String email);
}
