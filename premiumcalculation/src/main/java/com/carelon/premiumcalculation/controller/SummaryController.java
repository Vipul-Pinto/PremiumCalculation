package com.carelon.premiumcalculation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelon.premiumcalculation.service.SummaryService;

import lombok.Data;

@RestController
@RequestMapping("/summary")
@Data
@CrossOrigin(origins="*")
public class SummaryController {
	
	private final SummaryService summaryService;

	@GetMapping("/{schemeNumber}")
	public float getPremium(@PathVariable String schemeNumber) {
		return summaryService.premiumCalculation(schemeNumber);
	}
}
