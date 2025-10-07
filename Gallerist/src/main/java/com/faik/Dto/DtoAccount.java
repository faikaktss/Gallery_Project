package com.faik.Dto;

import java.math.BigDecimal;

import com.faik.Model.BaseEntitiy;
import com.faik.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DtoAccount extends BaseEntitiy{

	private String accountNo;
	
	private String iban;
	
	private BigDecimal amount;
	
	private CurrencyType currencyType;
}
