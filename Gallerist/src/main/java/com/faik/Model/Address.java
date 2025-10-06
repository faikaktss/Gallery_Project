package com.faik.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntitiy{

	@Column(name = "city")
	private String city;
	
	@Column(name = "discrit")
	private String discrit;
	
	@Column(name = "neighbooard")
	private String neighbooard;
	
	@Column(name = "street")
	private String street;
}
