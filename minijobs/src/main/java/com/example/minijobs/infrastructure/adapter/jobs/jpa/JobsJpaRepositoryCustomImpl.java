package com.example.minijobs.infrastructure.adapter.jobs.jpa;

import com.example.minijobs.domain.jobs.dto.JobQueryData;
import com.example.minijobs.infrastructure.adapter.jobs.entity.CompanyEntity;
import com.example.minijobs.infrastructure.adapter.jobs.entity.JobEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JobsJpaRepositoryCustomImpl implements JobsJpaRepositoryCustom {

    private final EntityManager entityManager;

    @Override
    public List<JobEntity> findJobsByCriteria(JobQueryData jobQueryData, int pageNumber, int pageSize) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<JobEntity> criteriaQuery = criteriaBuilder.createQuery(JobEntity.class);

        Root<JobEntity> job = criteriaQuery.from(JobEntity.class);
        Join<JobEntity, CompanyEntity> company = job.join("company", JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>();

        if (jobQueryData.jobTitle() != null) {
            predicates.add(criteriaBuilder.like(job.get("title"), "%" + jobQueryData.jobTitle() + "%"));
        }

        if (jobQueryData.jobCountryCode() != null) {
            predicates.add(criteriaBuilder.equal(job.get("countryCode"), jobQueryData.jobCountryCode()));
        }

        if (jobQueryData.companyCountryCode() != null) {
            predicates.add(criteriaBuilder.equal(company.get("countryCode"), jobQueryData.companyCountryCode()));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(criteriaQuery)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

}
