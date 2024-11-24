package com.carelon.premiumcalculation.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Discounts;
import com.carelon.premiumcalculation.entity.DiscountsEntity;
import com.carelon.premiumcalculation.repository.DiscountsRepository;

import lombok.Data;

@Service
@Data
public class DiscountsService {

    private final DiscountsRepository discountsRepository;
    private final ModelMapper mapper;

    public List<Discounts> getDiscounts() {
        List<DiscountsEntity> discountsEntities = discountsRepository.findAll();
        return discountsEntities.stream()
                .map(discount -> mapper.map(discount, Discounts.class))
                .collect(Collectors.toList());
    }

    public Discounts addDiscount(Discounts discount) {
        DiscountsEntity discountsEntity = mapper.map(discount, DiscountsEntity.class);
        return mapper.map(discountsRepository.save(discountsEntity), Discounts.class);
    }

    public Discounts updateDiscount(String slab, Discounts discount) {
        DiscountsEntity discountsEntity = mapper.map(discount, DiscountsEntity.class);
        discountsEntity.setSlab(slab); // Set the primary key explicitly.
        return mapper.map(discountsRepository.save(discountsEntity), Discounts.class);
    }

    public void deleteDiscount(String slab) {
        discountsRepository.deleteById(slab);
    }
}
