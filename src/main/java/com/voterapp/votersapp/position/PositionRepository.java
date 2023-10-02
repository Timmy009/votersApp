package com.voterapp.votersapp.politicalParty;

import com.voterapp.votersapp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean existsPositionByName(String name);
}
