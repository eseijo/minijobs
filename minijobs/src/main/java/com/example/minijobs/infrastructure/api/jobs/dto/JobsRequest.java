package com.example.minijobs.infrastructure.api.jobs.dto;

import lombok.Data;

@Data
public class JobsRequest {

    private final String jobCountryCode;
    private final String jobTitle;
    private final String companyCountryCode;
    private final int pageNumber;
    private final int pageSize;

}
