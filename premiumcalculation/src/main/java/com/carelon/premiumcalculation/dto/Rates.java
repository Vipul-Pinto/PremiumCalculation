package com.carelon.premiumcalculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rates {

    private String age;
    private Integer maleNumber;
    private Integer femaleNumber;

}
