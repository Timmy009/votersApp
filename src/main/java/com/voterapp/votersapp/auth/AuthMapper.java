package com.voterapp.votersapp.candidate;


import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CandidateMapper {
    public Candidate toCandidate(CreateCandidateRequest createCandidateRequest) {
        if (createCandidateRequest == null) {
            return new Candidate();
        }
        return Candidate.builder().email(createCandidateRequest.getName()).build();
    }

    public CandidateResponse toResponse (Candidate candidate) {
        return CandidateResponse.builder().email(candidate.getEmail()).id(candidate.getId()).build();
    }
}
