package com.carelon.premiumcalculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carelon.premiumcalculation.entity.DiscountsEntity;

@Repository
public interface DiscountsRepository extends JpaRepository<DiscountsEntity, String> {

}
