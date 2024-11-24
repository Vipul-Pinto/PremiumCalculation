package com.carelon.premiumcalculation.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PC_POLICIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PoliciesEntity {

    @Id
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

    @OneToMany(mappedBy = "pcPolicies", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CategoriesEntity> categories;

}
