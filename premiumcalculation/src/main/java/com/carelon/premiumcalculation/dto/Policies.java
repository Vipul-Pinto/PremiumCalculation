package com.carelon.premiumcalculation.dto;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policies {

    private String schemeNumber;
    private String schemeName;
    private String effectiveDate;
    private String anniversary;
    private String businessSource;
    private String taxId;
    private String country;
    private String employerContractInfo;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String zip;
    private String employerPhone;
    private String employerExt;
    private String employerFax;
    private Integer Premium;
    private List<Categories> categories;

}
