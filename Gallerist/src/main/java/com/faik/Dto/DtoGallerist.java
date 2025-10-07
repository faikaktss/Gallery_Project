package com.faik.Dto;

import com.faik.Model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoGallerist extends DtoBase{

	private String first_name;
	
	private String last_name;
	
	
	private DtoAddress address;
}
