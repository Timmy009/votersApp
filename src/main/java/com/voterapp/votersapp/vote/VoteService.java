package com.voterapp.votersapp.vote;

import java.util.List;

public interface ElectionService {
    Long createElection (CreateVoteRequest createElectionRequest);
    List<CreateElectionResponse> findAll();
    CreateElectionResponse findById(Long id);
    public void delete(Long id);

}
