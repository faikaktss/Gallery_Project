package com.faik.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "refreshToken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResfrehToken  extends BaseEntitiy{
	@Column(name = "refreshToken")
	private String refreshToken;
	
	@Column(name = "experiedDate")
	private Date experiedDate;
	
	@ManyToOne
	private User user;
}
