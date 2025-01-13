package com.example.minijobs.infrastructure.api.jobs.mapper;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.infrastructure.api.jobs.dto.JobsRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobsMapper {

    JobQueryData toJobQueryData(JobsRequest request);

}
