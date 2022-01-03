package com.cardmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressDetails {

	@Id
	@Column(name = "userid")
	private Integer userId;
	@Column(name = "line1")
	@NotNull
	@Length(min = 1, max = 30)
	private String line1;
	@Column(name = "line2")

	@Length(min = 0, max = 30)
	private String line2;

	@Column(name = "line3")
	@Length(min = 0, max = 30)
	private String line3;

	@Column(name = "pin")
	@NotNull
	@Length(min = 3, max = 30)
	private String pin;
	@Column(name = "city")
	@NotNull
	@Length(min = 1, max = 30)
	private String city;
	@Column(name = "state")
	@NotNull
	@Length(min = 1, max = 30)
	private String state;
	
	@Column(name = "country")
	@NotNull
	@Length(min = 1, max = 30)
	private String country;

}
