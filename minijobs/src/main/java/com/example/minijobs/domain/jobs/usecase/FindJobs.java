package com.example.minijobs.domain.jobs.usecase;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.domain.jobs.entity.Job;
import com.example.minijobs.domain.jobs.exception.NoCreditsException;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;

import java.util.List;

public interface FindJobs {

    List<Job> find(String apiKey, JobQueryData jobQueryData, int pageNumber, int pageSize) throws NoCreditsException, UnknownUserException;

}
