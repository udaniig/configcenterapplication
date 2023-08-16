package com.mds.configcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mds.configcenter.model.PricePlan;

public interface PricePlanRepository extends JpaRepository<PricePlan, Long> {

}
