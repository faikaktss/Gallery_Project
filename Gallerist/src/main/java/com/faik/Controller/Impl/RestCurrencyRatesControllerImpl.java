package com.faik.Controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faik.Controller.IRestCurrencyRatesController;
import com.faik.Controller.RestBaseController;
import com.faik.Controller.RootEntitiy;
import com.faik.Dto.CurrencyRatesResponse;
import com.faik.Service.ICurrencyRatesService;

@RestController
@RequestMapping("/rest/api/currency-rest") 
public class RestCurrencyRatesControllerImpl extends RestBaseController implements IRestCurrencyRatesController{

	@Autowired
	private ICurrencyRatesService currencyRatesService;
	
	@GetMapping("/currency-rest")
	@Override
	public RootEntitiy<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate,@RequestParam("endDate") String endDate) {

		return ok(currencyRatesService.getCurrencyRates(startDate, endDate));
	}

}
