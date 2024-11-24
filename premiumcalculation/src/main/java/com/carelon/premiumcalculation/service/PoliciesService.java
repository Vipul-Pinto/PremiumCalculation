package com.carelon.premiumcalculation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Policies;
import com.carelon.premiumcalculation.dto.Categories;
import com.carelon.premiumcalculation.entity.PoliciesEntity;
import com.carelon.premiumcalculation.entity.CategoriesEntity;
import com.carelon.premiumcalculation.repository.PoliciesRepository;
import com.carelon.premiumcalculation.repository.CategoriesRepository;

import lombok.Data;

@Service
@Data
public class PoliciesService {

    private final PoliciesRepository policiesRepository;
    private final CategoriesRepository categoriesRepository;
    private final ModelMapper mapper;

    public List<Policies> getPolicies() {
        List<PoliciesEntity> policiesEntities = policiesRepository.findAll();
        return policiesEntities.stream()
                .map(policy -> mapper.map(policy, Policies.class))
                .collect(Collectors.toList());
    }

    public Policies addPolicy(Policies policy) {
        PoliciesEntity policiesEntity = mapper.map(policy, PoliciesEntity.class);
        for(CategoriesEntity category:policiesEntity.getCategories()){
            category.setPcPolicies(policiesEntity);
        }
        return mapper.map(policiesRepository.save(policiesEntity), Policies.class);
    }

    public Policies updatePolicy(String schemeNumber, Policies policy) {
        PoliciesEntity policiesEntity = mapper.map(policy, PoliciesEntity.class);
        policiesEntity.setSchemeNumber(schemeNumber);
        return mapper.map(policiesRepository.save(policiesEntity), Policies.class);
    }

    public void deletePolicy(String schemeNumber) {
        policiesRepository.deleteById(schemeNumber);
    }

    public List<Categories> getCategoriesByPolicy(String schemeNumber) {
        List<CategoriesEntity> categoriesEntities = categoriesRepository.findByPcPoliciesSchemeNumber(schemeNumber);
        return categoriesEntities.stream()
                .map(category -> mapper.map(category, Categories.class))
                .collect(Collectors.toList());
    }
}
