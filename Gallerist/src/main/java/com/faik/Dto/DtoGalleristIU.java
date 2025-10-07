package com.faik.Dto;

import com.faik.Model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGalleristIU {

	private String first_name;
	
	private String last_name;
	
	private Long address_id;
}
