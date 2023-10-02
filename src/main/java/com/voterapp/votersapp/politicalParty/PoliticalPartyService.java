package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreatePoliticalPartyRequest;
import com.voterapp.votersapp.dto.responses.PoliticalPartyResponse;

import java.util.List;

public interface PoliticalPartyService {
    Long createPoliticalParty (CreatePoliticalPartyRequest createPoliticalPartyRequest);
    List<PoliticalPartyResponse> findAll();
    PoliticalPartyResponse findById(Long id);
    public void delete(Long id);
}
