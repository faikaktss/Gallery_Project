package com.faik.Controller;

import com.faik.Dto.CurrencyRatesResponse;

public interface IRestCurrencyRatesController {
	public RootEntitiy<CurrencyRatesResponse> getCurrencyRates(String startDate, String endDate);
}
