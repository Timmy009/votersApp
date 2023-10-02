package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreatePositionRequest;
import com.voterapp.votersapp.dto.responses.PositionResponse;

import java.util.List;

public interface PositionService {
    Long createPosition (CreatePositionRequest createPositionRequest);
    List<PositionResponse> findAll();
    PositionResponse findById(Long id);
    public void delete(Long id);
}
