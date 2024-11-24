package com.carelon.premiumcalculation.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Categories;
import com.carelon.premiumcalculation.entity.CategoriesEntity;
import com.carelon.premiumcalculation.entity.PoliciesEntity;
import com.carelon.premiumcalculation.repository.CategoriesRepository;

import lombok.Data;

@Service
@Data
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;
    private final ModelMapper mapper;

    public Categories addCategory(Categories category) {
        CategoriesEntity categoriesEntity = mapper.map(category, CategoriesEntity.class);
        PoliciesEntity policiesEntity = categoriesEntity.getPcPolicies();
        categoriesEntity.setPcPolicies(policiesEntity);
        return mapper.map(categoriesRepository.save(categoriesEntity), Categories.class);
    }

    public void deleteCategory(Integer categoryId) {
        categoriesRepository.deleteById(categoryId);
    }
}
