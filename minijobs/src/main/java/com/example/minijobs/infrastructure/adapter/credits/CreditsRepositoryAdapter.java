package com.example.minijobs.infrastructure.adapter.credits;

import com.example.minijobs.domain.credits.repository.CreditsRepositoryPort;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;
import com.example.minijobs.infrastructure.adapter.credits.entity.InvoiceEntity;
import com.example.minijobs.infrastructure.adapter.credits.jpa.UserInvoiceJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CreditsRepositoryAdapter implements CreditsRepositoryPort {

    private final UserInvoiceJpaRepository userInvoiceJpaRepository;

    @Override
    public int getCredits(String apiKey) throws UnknownUserException {
        List<InvoiceEntity> invoices = this.userInvoiceJpaRepository.findByUserApiKey(apiKey);
        if (invoices.isEmpty()) {
            throw new UnknownUserException("No user found with the given API key");
        }
        return invoices.stream().mapToInt(userInvoiceEntity -> userInvoiceEntity.getCredits()).sum();
    }

    @Override
    public void useCredits(String apiKey, int credits) {
        List<InvoiceEntity> invoices = this.userInvoiceJpaRepository.findByUserApiKey(apiKey);
        int remainingCredits = credits;
        for (InvoiceEntity invoice : invoices) {
            if (remainingCredits > 0) {
                int invoiceCredits = invoice.getCredits();
                if (invoiceCredits >= remainingCredits) {
                    invoice.setCredits(invoiceCredits - remainingCredits);
                    remainingCredits = 0;
                } else {
                    invoice.setCredits(0);
                    remainingCredits -= invoiceCredits;
                }
                this.userInvoiceJpaRepository.save(invoice);
            } else {
                break;
            }
        }
    }

}
