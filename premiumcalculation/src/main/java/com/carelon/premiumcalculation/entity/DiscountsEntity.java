package com.carelon.premiumcalculation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PC_DISCOUNTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountsEntity {

    @Id
    private String slab;
    private Integer maleNumber;
    private Integer femaleNumber;

}
