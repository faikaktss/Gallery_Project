package com.faik.Dto;

import java.math.BigDecimal;

import com.faik.enums.CarStatusType;
import com.faik.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCarIU {

	@NotEmpty
	private String plaka;
	@NotEmpty
	private String marka;
	@NotEmpty
	private String model;
	@NotEmpty
	private Integer productionYear;
	@NotEmpty
	private BigDecimal price;
	@NotEmpty
	private CurrencyType currencyType;
	@NotEmpty
	private BigDecimal damagePrice;
	@NotEmpty
	private CarStatusType carStatusType;
}
