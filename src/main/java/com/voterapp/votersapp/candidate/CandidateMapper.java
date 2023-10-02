package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreateCandidateRequest;
import com.voterapp.votersapp.dto.responses.CandidateResponse;
import com.voterapp.votersapp.model.Candidate;

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
