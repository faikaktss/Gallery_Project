package com.faik.Dto;

import java.math.BigDecimal;

import com.faik.Model.BaseEntitiy;
import com.faik.enums.CarStatusType;
import com.faik.enums.CurrencyType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter 
public class DtoCar extends BaseEntitiy{
	private String plaka;
	
	private String marka;
	
	private String model;
	
	private Integer productionYear;
	
	private BigDecimal price;
	
	private CurrencyType currencyType;
	
	private BigDecimal damagePrice;
	
	private CarStatusType carStatusType;
	
}
