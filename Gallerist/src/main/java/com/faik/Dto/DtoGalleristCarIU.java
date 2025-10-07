package com.faik.Dto;

import com.faik.Model.Car;
import com.faik.Model.Gallerist;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DtoGalleristCarIU {
	private Long gallerist_id;

	private Long car_id;
}
