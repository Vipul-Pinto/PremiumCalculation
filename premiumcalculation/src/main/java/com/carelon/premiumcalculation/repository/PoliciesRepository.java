package com.carelon.premiumcalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carelon.premiumcalculation.entity.PoliciesEntity;

@Repository
public interface PoliciesRepository extends JpaRepository<PoliciesEntity, String> {

}
