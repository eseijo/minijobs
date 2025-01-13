package com.example.minijobs.application.credits.service;

import com.example.minijobs.domain.jobs.exception.UnknownUserException;

public interface ApiCreditUsageService {

    int checkCredits(String apiKey) throws UnknownUserException;

    void useCredits(String apiKey, int credits);

}
