package com.example.minijobs.application.credits.service;

import com.example.minijobs.domain.credits.repository.CreditsRepositoryPort;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiCreditUsageServiceImpl implements ApiCreditUsageService {

    private final CreditsRepositoryPort creditsRepository;

    @Override
    public int checkCredits(String apiKey) throws UnknownUserException {
        return this.creditsRepository.getCredits(apiKey);
    }

    @Override
    public void useCredits(String apiKey, int credits) {
        if (credits < 0) {
            throw new IllegalArgumentException("Credits must be a positive number");
        }
        this.creditsRepository.useCredits(apiKey, credits);
    }

}
