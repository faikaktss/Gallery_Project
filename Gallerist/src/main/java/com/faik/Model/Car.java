package com.faik.Model;

import java.math.BigDecimal;

import com.faik.enums.CarStatusType;
import com.faik.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntitiy{

	@Column(name = "plaka")
	private String plaka;
	
	@Column(name = "marka")
	private String marka;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "productionYear")
	private Integer productionYear;
	
	@Column(name = "price")
	private BigDecimal price;
	
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	
	private BigDecimal damagePrice;
	
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;
}
