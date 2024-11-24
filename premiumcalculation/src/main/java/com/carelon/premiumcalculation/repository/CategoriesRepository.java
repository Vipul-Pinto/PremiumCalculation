package com.carelon.premiumcalculation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carelon.premiumcalculation.entity.CategoriesEntity;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {
    List<CategoriesEntity> findByPcPoliciesSchemeNumber(String schemeNumber);
}