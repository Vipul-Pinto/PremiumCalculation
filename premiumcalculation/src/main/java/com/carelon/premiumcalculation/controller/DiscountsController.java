package com.carelon.premiumcalculation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.premiumcalculation.dto.Discounts;
import com.carelon.premiumcalculation.service.DiscountsService;

import lombok.Data;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/discounts")
@Data
public class DiscountsController {

    private final DiscountsService discountsService;

    @GetMapping
    public List<Discounts> getDiscounts() {
        return discountsService.getDiscounts();
    }

    @PostMapping
    public Discounts addDiscount(@RequestBody Discounts discount) {
        return discountsService.addDiscount(discount);
    }

    @PutMapping("/{slab}")
    public Discounts updateDiscount(@PathVariable String slab, @RequestBody Discounts discount) {
        return discountsService.updateDiscount(slab, discount);
    }

    @DeleteMapping("/{slab}")
    public void deleteDiscount(@PathVariable String slab) {
        discountsService.deleteDiscount(slab);
    }
}