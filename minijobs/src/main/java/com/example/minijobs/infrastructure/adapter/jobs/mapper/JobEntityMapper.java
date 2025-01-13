package com.example.minijobs.infrastructure.adapter.jobs.mapper;

import com.example.minijobs.domain.jobs.entity.Job;
import com.example.minijobs.infrastructure.adapter.jobs.entity.CompanyEntity;
import com.example.minijobs.infrastructure.adapter.jobs.entity.JobEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobEntityMapper {

    Job toDomain(JobEntity entity);

    List<Job> toDomain(List<JobEntity> entities);

    default String mapCompany(CompanyEntity company) {
        return company.getName();
    }

}
