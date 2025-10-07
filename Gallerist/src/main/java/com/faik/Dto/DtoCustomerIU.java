package com.faik.Dto;

import java.sql.Date;

import com.faik.Model.Account;
import com.faik.Model.Address;

import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCustomerIU {
	@NotEmpty
	private String first_name;
	
	@NotEmpty
	private String last_name;
	
	@NotEmpty
	private String tckn;
	
	@NotEmpty
	private Date birthofDate;
	
	@NotEmpty
	private Long address_id;
	
	@NotEmpty
	private long account_id;
}
