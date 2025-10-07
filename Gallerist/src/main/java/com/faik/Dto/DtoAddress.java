package com.faik.Dto;

import com.faik.Model.BaseEntitiy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAddress  extends BaseEntitiy{

	private String city;
	
	private String discrit;
	
	private String neighbooard;
	
	private String street;
}
