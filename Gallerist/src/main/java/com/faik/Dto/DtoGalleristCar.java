package com.faik.Dto;

import com.faik.Model.Car;
import com.faik.Model.Gallerist;



import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DtoGalleristCar {
	private DtoGallerist gallerist;

	private DtoCar car;
}
