package com.carelon.premiumcalculation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.premiumcalculation.dto.Policies;
import com.carelon.premiumcalculation.service.CategoriesService;
import com.carelon.premiumcalculation.service.PoliciesService;

import lombok.Data;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/policies")
@Data
@CrossOrigin(origins = "http://localhost:4200")
public class PoliciesController {

    private final PoliciesService policiesService;
    private final CategoriesService categoriesService;

    @GetMapping
    public List<Policies> getPolicies() {
        return policiesService.getPolicies();
    }

    @PostMapping
    public Policies addPolicy(@RequestBody Policies policy) {
        return policiesService.addPolicy(policy);
    }

    @PutMapping("/{schemeNumber}")
    public Policies updatePolicy(@PathVariable String schemeNumber, @RequestBody Policies policy) {
        return policiesService.updatePolicy(schemeNumber, policy);
    }

    @DeleteMapping("/{schemeNumber}")
    public void deletePolicy(@PathVariable String schemeNumber) {
        policiesService.deletePolicy(schemeNumber);
    }

    // @GetMapping("/{schemeNumber}/categories")
    // public List<Categories> getCategoriesByPolicy(@PathVariable String schemeNumber) {
    //     return policiesService.getCategoriesByPolicy(schemeNumber);
    // }

    // @PostMapping("/{schemeNumber}/categories")
    // public Categories addCategory(@PathVariable String schemeNumber, @RequestBody Categories category) {
    //     return policiesService.addCategory(schemeNumber, category);
    // }

    // @DeleteMapping("/categories/{categoryId}")
    // public void deleteCategory(@PathVariable Integer categoryId) {
    //     policiesService.deleteCategory(categoryId);
    // }
}