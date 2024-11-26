package com.carelon.premiumcalculation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.carelon.premiumcalculation.dto.Categories;
import com.carelon.premiumcalculation.dto.Discounts;
import com.carelon.premiumcalculation.dto.Rates;

import lombok.Data;

@Service
@Data
public class SummaryService {

	private final RatesService ratesService;
	private final CategoriesService categoriesService;
	private final DiscountsService discountsService;

	public float premiumCalculation(String schemeNumber) {
		float premium = 0f;
		List<Rates> rates = ratesService.getRates();
		int male_rate_1 = rates.get(0).getMaleNumber();
		int male_rate_2 = rates.get(1).getMaleNumber();
		int male_rate_3 = rates.get(2).getMaleNumber();

		List<Categories> categories = categoriesService.getCategoryById(schemeNumber);
		int male_1 = categories.get(0).getMaleNumber();
		int male_2 = categories.get(1).getMaleNumber();
		int male_3 = categories.get(2).getMaleNumber();

		int female_rate_1 = rates.get(0).getFemaleNumber();
		int female_rate_2 = rates.get(1).getFemaleNumber();
		int female_rate_3 = rates.get(2).getFemaleNumber();

		int female_1 = categories.get(0).getFemaleNumber();
		int female_2 = categories.get(1).getFemaleNumber();
		int female_3 = categories.get(2).getFemaleNumber();

		float malePremium = (float) (male_1 * male_rate_1 + male_2 * male_rate_2 + male_3 * male_rate_3);
		float femalePremium = (float) (female_1 * female_rate_1 + female_2 * female_rate_2 + female_3 * female_rate_3);

		int maleCount = male_1 + male_2 + male_3;
		int femaleCount = female_1 + female_2 + female_3;

		List<Discounts> discounts = discountsService.getDiscounts();

		if (maleCount > 1 && maleCount <= 200) {
			malePremium *= (1 - (float) discounts.get(0).getMaleNumber() / 100);
		} else if (maleCount <= 400) {
			malePremium *= (1 - (float) discounts.get(1).getMaleNumber() / 100);
		} else {
			malePremium *= (1 - (float) discounts.get(2).getMaleNumber() / 100);
		}

		if (femaleCount > 1 && femaleCount <= 200) {
			femalePremium *= (1 - (float) discounts.get(0).getFemaleNumber() / 100);
		} else if (femaleCount <= 400) {
			femalePremium *= (1 - (float) discounts.get(1).getFemaleNumber() / 100);
		} else {
			femalePremium *= (1 - (float) discounts.get(2).getFemaleNumber() / 100);
		}

		premium = malePremium + femalePremium;
		return premium;
	}

}
