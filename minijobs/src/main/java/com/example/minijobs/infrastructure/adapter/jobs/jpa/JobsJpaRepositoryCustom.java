package com.example.minijobs.infrastructure.adapter.jobs.jpa;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.infrastructure.adapter.jobs.entity.JobEntity;

import java.util.List;

public interface JobsJpaRepositoryCustom {

    List<JobEntity> findJobsByCriteria(JobQueryData jobQueryData, int pageNumber, int pageSize);
}
