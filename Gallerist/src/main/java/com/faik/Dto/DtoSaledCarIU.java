package com.faik.Dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCarIU {

	@NotNull
	private Long customer_id;
	
	@NotNull
	private Long gallerist_id;
	
	@NotNull
	private Long carId;
}
