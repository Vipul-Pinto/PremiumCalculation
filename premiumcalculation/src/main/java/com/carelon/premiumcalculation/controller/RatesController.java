package com.carelon.premiumcalculation.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.premiumcalculation.dto.Rates;
import com.carelon.premiumcalculation.service.RatesService;

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
@RequestMapping("/rates")
@Data
@CrossOrigin(origins="http://localhost:4200")
public class RatesController {

    private final RatesService ratesService;

    @GetMapping
    public List<Rates> getRates() {
        return ratesService.getRates();
    }

    @PostMapping()
    public Rates addRates(@RequestBody Rates rates) {
        return ratesService.addRate(rates);
    }

    @PutMapping("/{age}")
    public Rates updateRates(@PathVariable String age, @RequestBody Rates rate) {
        return ratesService.updateRate(age, rate);
    }

    @DeleteMapping("/{age}")
    public void deleteRates(@PathVariable String age){
        ratesService.deleteRate(age);
    }

}
