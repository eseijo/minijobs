package com.example.minijobs.application.jobs.usecase;

import com.example.minijobs.application.credits.service.ApiCreditUsageService;
import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.domain.jobs.entity.Job;
import com.example.minijobs.domain.jobs.exception.NoCreditsException;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;
import com.example.minijobs.domain.jobs.repository.JobsRepositoryPort;
import com.example.minijobs.domain.jobs.usecase.FindJobs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindJobsUseCase implements FindJobs {

    private final JobsRepositoryPort jobsRepository;

    private final ApiCreditUsageService apiCreditUsageService;

    @Override
    public List<Job> find(String apiKey, JobQueryData jobQueryData, int pageNumber, int pageSize) throws NoCreditsException, UnknownUserException {
        int availableCredits = this.apiCreditUsageService.checkCredits(apiKey);
        if (availableCredits <= 0) {
            throw new NoCreditsException("Not enough credits to perform this operation");
        }
        List<Job> result = this.jobsRepository.findPaged(jobQueryData, pageNumber, pageSize);

        if (result.size() > availableCredits) {
            this.apiCreditUsageService.useCredits(apiKey, availableCredits);
            return result.subList(0, availableCredits);
        }
        
        this.apiCreditUsageService.useCredits(apiKey, result.size());

        return result;
    }

}
