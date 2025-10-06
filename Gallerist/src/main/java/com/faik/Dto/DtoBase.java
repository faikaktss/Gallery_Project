package com.faik.Dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DtoBase {
	private Long id;
	
	private Date create_time;
}
