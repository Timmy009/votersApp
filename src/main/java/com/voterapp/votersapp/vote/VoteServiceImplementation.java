package com.voterapp.votersapp.vote;

import com.voterapp.votersapp.exception.OperationNonPermittedException;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectionServiceImplementation  implements VoteService {
    private final ObjectsValidator<CreateVoteRequest> validator;
    private final VoteMapper mapper;
    private final VoteRepository voteRepository;

    @Override
    public CreateVoteResponse createVote(CreateVoteRequest createVoteRequest) {
        validator.validate(createVoteRequest);
        var vote = mapper.toVote(createVoteRequest);

        var electionAlreadyExist = electionRepository.existsElectionByElectionName(createElectionRequest.getName());
        if (electionAlreadyExist) {
            throw new OperationNonPermittedException("The election has been created already");
        }
        return electionRepository.save(election).getId();
    }



    @Override
    public List<CreateVoteResponse> findAll() {
        return electionRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CreateVoteResponse findById(Long id) {
        return electionRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No election found with the ID:: " + id));
    }
    @Override
    public void delete(Long id) {
        electionRepository.deleteById(id);
    }


}
