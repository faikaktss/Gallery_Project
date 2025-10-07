package com.faik.Service.Impl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.faik.Dto.CurrencyRatesResponse;
import com.faik.Exception.BaseException;import com.faik.Exception.ErrorMessage;
import com.faik.Exception.MessageType;
import com.faik.Service.ICurrencyRatesService;

@Service
public class CurrencyRatesService implements ICurrencyRatesService{

	@Override
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
		
		String rootURL = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String types = "json";
		
		String endpoint = rootURL+"series="+series+"&startDate="+startDate+"&endDate="+endDate+"&type="+types;
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("key","XsBxAxzaVo" );
		
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<CurrencyRatesResponse> currencyResponseEntity = restTemplate.exchange(endpoint, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<CurrencyRatesResponse>() {
		});
		
		if(!currencyResponseEntity.getStatusCode().is2xxSuccessful() ) {
			throw new BaseException(new ErrorMessage(null, MessageType.GENERAL_EXCEPTION));
		}
		
		return currencyResponseEntity.getBody();
	}

}
