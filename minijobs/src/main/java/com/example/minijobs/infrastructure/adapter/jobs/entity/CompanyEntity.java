package com.example.minijobs.infrastructure.adapter.jobs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "companies")
@Data
public class CompanyEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "domain")
    private String domain;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}
