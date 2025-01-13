package com.example.minijobs.domain.credits.repository;

import com.example.minijobs.domain.jobs.exception.UnknownUserException;

public interface CreditsRepositoryPort {

    int getCredits(String apiKey) throws UnknownUserException;

    void useCredits(String apiKey, int credits);

}
