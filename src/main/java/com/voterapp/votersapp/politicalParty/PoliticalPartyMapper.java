package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreatePoliticalPartyRequest;
import com.voterapp.votersapp.dto.responses.PoliticalPartyResponse;
import com.voterapp.votersapp.model.PoliticalParty;

public class PoliticalPartyMapper {
    public PoliticalParty  toPoliticalParty(CreatePoliticalPartyRequest createPoliticalPartyRequest) {
        if (createPoliticalPartyRequest == null) {
            return new  PoliticalParty();
        }
        return PoliticalParty.builder().name(createPoliticalPartyRequest.getName()).build();
    }

    public PoliticalPartyResponse toResponse (PoliticalParty politicalParty) {
        return PoliticalPartyResponse.builder().name(politicalParty.getName()).id(politicalParty.getId()).build();
    }
}
