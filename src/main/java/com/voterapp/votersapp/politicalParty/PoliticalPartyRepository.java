package com.voterapp.votersapp.repositories;

import com.voterapp.votersapp.model.PoliticalParty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
    boolean existsPoliticalPartiesByName(String name);
}
