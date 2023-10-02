package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreateCandidateRequest;
import com.voterapp.votersapp.dto.responses.CandidateResponse;

import java.util.List;

public interface CandidateService {
    Long createCandidate (CreateCandidateRequest createCandidateRequest);
    List<CandidateResponse> findAll();
    CandidateResponse findById(Long id);
    public void delete(Long id);
}
