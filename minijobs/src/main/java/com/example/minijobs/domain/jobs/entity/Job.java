package com.example.minijobs.domain.jobs.entity;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Job {

    private OffsetDateTime postedAt;
    private String title;
    private String description;
    private String countryCode;
    private String company;
    private OffsetDateTime discoveredAt;

}
