package com.voterapp.votersapp.ElectionOrganiser;

import com.voterapp.votersapp.dto.responses.CreateElectionResponse;
import com.voterapp.votersapp.exception.OperationNonPermittedException;
import com.voterapp.votersapp.repositories.ElectionRepository;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectionServiceImplementation  implements ElectionService{
    private final ObjectsValidator<CreateElectionRequest> validator;
    private final ElectionMapper mapper;
    private final ElectionRepository electionRepository;

    @Override
    public Long createElection(CreateElectionRequest createElectionRequest) {
        validator.validate(createElectionRequest);
        var election = mapper.toElection(createElectionRequest);
        var electionAlreadyExist = electionRepository.existsElectionByElectionName(createElectionRequest.getName());
        if (electionAlreadyExist) {
            throw new OperationNonPermittedException("The election has been created already");
        }
        return electionRepository.save(election).getId();
    }




    public List<CreateElectionResponse> findAll() {
        return electionRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CreateElectionResponse findById(Long id) {
        return electionRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No election found with the ID:: " + id));
    }

    public void delete(Long id) {
        electionRepository.deleteById(id);
    }


}
