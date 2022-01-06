package com.site.billing.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.site.billing.entity.BillingEntity;

public interface BillingRepository extends JpaRepository<BillingEntity, Serializable> {

}
