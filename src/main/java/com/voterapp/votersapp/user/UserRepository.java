package com.voterapp.votersapp.repositories;

import com.voterapp.votersapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByEmail (String email);
}
