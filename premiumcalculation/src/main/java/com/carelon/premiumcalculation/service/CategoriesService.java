package com.carelon.premiumcalculation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Categories;
import com.carelon.premiumcalculation.entity.CategoriesEntity;
import com.carelon.premiumcalculation.entity.PoliciesEntity;
import com.carelon.premiumcalculation.repository.CategoriesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;

@Service
@Data
public class CategoriesService {

    @PersistenceContext
	private EntityManager entityManager;

    private final CategoriesRepository categoriesRepository;
    private final ModelMapper mapper;

    public Categories addCategory(Categories category) {
        CategoriesEntity categoriesEntity = mapper.map(category, CategoriesEntity.class);
        PoliciesEntity policiesEntity = categoriesEntity.getPcPolicies();
        categoriesEntity.setPcPolicies(policiesEntity);
        return mapper.map(categoriesRepository.save(categoriesEntity), Categories.class);
    }

    public List<Categories> getCategoryById(String schemeNumber) {
		List<CategoriesEntity> categoriesEntity = entityManager
				.createNamedQuery("getCategoryByScheme", CategoriesEntity.class)
				.setParameter("schemeNumber", schemeNumber).getResultList();
		return categoriesEntity.stream().map(category -> mapper.map(category, Categories.class))
				.collect(Collectors.toList());
	}

    public void deleteCategory(Integer categoryId) {
        categoriesRepository.deleteById(categoryId);
    }
}
