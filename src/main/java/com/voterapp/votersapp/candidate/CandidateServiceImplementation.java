package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.dto.requests.CreateCandidateRequest;
import com.voterapp.votersapp.dto.responses.CandidateResponse;
import com.voterapp.votersapp.exception.OperationNonPermittedException;
import com.voterapp.votersapp.repositories.CandidateRepository;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateServiceImplementation implements CandidateService{
    private final ObjectsValidator <CreateCandidateRequest> validator;
    private final CandidateMapper mapper;
    private final CandidateRepository candidateRepository;

    @Override
    public Long createCandidate(CreateCandidateRequest createCandidateRequest) {
        validator.validate(createCandidateRequest);
        var position = mapper.toCandidate(createCandidateRequest);
        var candidateAlreadyExist = candidateRepository.existsCandidateByEmail(createCandidateRequest.getName());
        if (candidateAlreadyExist) {
            throw new OperationNonPermittedException("The candidate has been registered already");
        }
        return candidateRepository.save(position).getId();
    }




    public List<CandidateResponse> findAll() {
        return candidateRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public CandidateResponse findById(Long id) {
        return candidateRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No candidate found with the ID:: " + id));
    }

    public void delete(Long id) {
        candidateRepository.deleteById(id);
    }


}
