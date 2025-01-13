package com.example.minijobs.infrastructure.adapter.jobs;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.domain.jobs.entity.Job;
import com.example.minijobs.domain.jobs.repository.JobsRepositoryPort;
import com.example.minijobs.infrastructure.adapter.jobs.entity.JobEntity;
import com.example.minijobs.infrastructure.adapter.jobs.jpa.JobsJpaRepository;
import com.example.minijobs.infrastructure.adapter.jobs.mapper.JobEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobsRepositoryAdapter implements JobsRepositoryPort {

    private final JobsJpaRepository jobsJpaRepository;

    private final JobEntityMapper jobEntityMapper;

    @Override
    public List<Job> findPaged(JobQueryData jobQueryData, int pageNumber, int pageSize) {
        List<JobEntity> result = this.jobsJpaRepository.findJobsByCriteria(jobQueryData, pageNumber, pageSize);
        return this.jobEntityMapper.toDomain(result);
    }

}
