package com.example.minijobs.infrastructure.adapter.jobs.jpa;

import com.example.minijobs.infrastructure.adapter.jobs.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobsJpaRepository extends JpaRepository<JobEntity, Long>, JobsJpaRepositoryCustom {
    
}
