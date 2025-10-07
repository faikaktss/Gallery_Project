package com.faik.Service;

import com.faik.Dto.CurrencyRatesResponse;

public interface ICurrencyRatesService {
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate);
}
