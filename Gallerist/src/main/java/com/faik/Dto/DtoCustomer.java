package com.faik.Dto;

import java.sql.Date;

import com.faik.Model.Account;
import com.faik.Model.Address;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomer extends DtoBase{
	@NotEmpty
	private String first_name;
	
	@NotEmpty
	private String last_name;
	
	@NotEmpty
	private String tckn;
	
	@NotEmpty
	private Date birthofDate;
	
	@NotEmpty
	private DtoAddress address;
	
	@NotEmpty
	private DtoAccount account;
}
