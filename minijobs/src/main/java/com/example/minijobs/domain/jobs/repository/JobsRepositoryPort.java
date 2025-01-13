package com.example.minijobs.domain.jobs.repository;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.domain.jobs.entity.Job;

import java.util.List;

public interface JobsRepositoryPort {

    List<Job> findPaged(JobQueryData jobQueryData, int pageNumber, int pageSize);

}
