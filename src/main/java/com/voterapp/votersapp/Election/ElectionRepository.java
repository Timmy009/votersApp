package com.voterapp.votersapp.repositories;

import com.voterapp.votersapp.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    boolean existsElectionByElectionName(String name);
}
