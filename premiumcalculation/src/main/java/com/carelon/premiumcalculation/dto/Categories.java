package com.carelon.premiumcalculation.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categories {

    private Integer categoryId;
    private String categoryName;
    private Integer maleNumber;
    private Integer femaleNumber;
    @JsonIgnore
    private Policies pcPolicies;

}
