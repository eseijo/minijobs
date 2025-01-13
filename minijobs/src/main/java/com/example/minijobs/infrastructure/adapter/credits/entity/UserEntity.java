package com.example.minijobs.infrastructure.adapter.credits.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "api_key")
    private String apiKey;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;
}
