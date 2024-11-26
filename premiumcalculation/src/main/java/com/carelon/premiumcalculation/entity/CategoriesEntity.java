package com.carelon.premiumcalculation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PC_CATEGORIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="getCategoryByScheme",query="FROM CategoriesEntity c WHERE c.pcPolicies.schemeNumber =: schemeNumber")
public class CategoriesEntity {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer maleNumber;
    private Integer femaleNumber;

    @ManyToOne
    @JoinColumn(name = "schemeNumber", nullable = false)
    private PoliciesEntity pcPolicies;

}
