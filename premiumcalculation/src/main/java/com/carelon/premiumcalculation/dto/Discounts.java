package com.carelon.premiumcalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discounts {

    private String slab;
    private Integer maleNumber;
    private Integer femaleNumber;

}
