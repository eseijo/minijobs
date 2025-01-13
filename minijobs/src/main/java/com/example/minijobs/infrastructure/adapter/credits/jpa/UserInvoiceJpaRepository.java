package com.example.minijobs.infrastructure.adapter.credits.jpa;

import com.example.minijobs.infrastructure.adapter.credits.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInvoiceJpaRepository extends JpaRepository<InvoiceEntity, Long> {

    List<InvoiceEntity> findByUserApiKey(String apiKey);

}
