package com.cardmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "phone_number", nullable = false)
	private String phoneNum;
	@Column(name = "password", nullable = false)
	private String password;

	public static enum Title {
		Mr, Mrs, Miss
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "title")
	private Title title;

	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "pan")
	private String pan;

	public static enum KYCStatus {
		DONE, NOT_DONE
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "kyc_status")
	private KYCStatus kycStatus;

//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getPhoneNum() {
//		return phoneNum;
//	}
//
//	public void setPhoneNum(String phoneNum) {
//		this.phoneNum = phoneNum;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Title getTitle() {
//		return title;
//	}
//
//	public void setTitle(Title title) {
//		this.title = title;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPan() {
//		return pan;
//	}
//
//	public void setPan(String pan) {
//		this.pan = pan;
//	}
//
//	public KYCStatus getKycStatus() {
//		return kycStatus;
//	}
//
//	public void setKycStatus(KYCStatus kycStatus) {
//		this.kycStatus = kycStatus;
//	}
//
//	@Override
//	public String toString() {
//		return "Userdetalis [userId=" + userId + ", phoneNum=" + phoneNum + ", password=" + password + ", title="
//				+ title + ", name=" + name + ", pan=" + pan + ", kycStatus=" + kycStatus + "]";
//	}
//
//	public Userdetalis(Integer userId, String phoneNum, String password, Title title, String name, String pan,
//			KYCStatus kycStatus) {
//		super();
//		this.userId = userId;
//		this.phoneNum = phoneNum;
//		this.password = password;
//		this.title = title;
//		this.name = name;
//		this.pan = pan;
//		this.kycStatus = kycStatus;
//	}
//
//	public Userdetalis() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

}
