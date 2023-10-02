package com.voterapp.votersapp.verificationToken;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Sampson Alfred
 */

public interface VoteTokenRepository extends JpaRepository<VerificationToken, Long> {
    VerificationToken findByToken(String token);
}
