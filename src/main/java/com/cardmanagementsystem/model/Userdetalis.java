package com.cardmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "userdetails")
public class Userdetalis {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private int userId;
	@NotNull
    @Length(min = 10,max=10, message = " should be 10 digits ")
	@Column(name = "phone_number", nullable = false)
	private String phoneNum;
	@NotNull
    @Length(min = 8,max=15)
	@Column(name = "password", nullable = false)
	private String password;

//	public static enum Title {
//		Mr, Mrs, Miss
//	}

//	@Enumerated(EnumType.STRING)
	@Column(name = "title",columnDefinition = "VARCHAR(4) CHECK (title IN ('Mr', 'Mrs', 'Miss'))")
	private String title;
	@NotNull
    @Length(min = 2,max=100)
	@Column(name = "name", nullable = false)
	private String name;
	@NotNull
    @Length(min = 10,max=10)
	@Column(name = "pan")
	private String pan;

//	public static enum KYCStatus {
//		DONE, NOT_DONE
//	}
//
//	@Enumerated(EnumType.STRING)
	@Column(name = "kyc_status",columnDefinition = "VARCHAR(8) CHECK (kyc_status IN ('DONE', 'NOT_DONE'))")
	private String kycStatus;


}
