package com.cardmanagementsystemm.cardmanagementsystemm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Userdetalis {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userid")
	private Integer id;
	@Column(name = "phonenumber")
	private Integer phonenumber;
	@Column(name = "password")
	private String password;
	@Column(name = "title")
	private String title;
	@Column(name = "name")
	private String name;
	@Column(name = "pan")
	private String pan;
	@Column(name = "kycstatus")
	private String kycstatus;
	public Userdetalis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userdetalis(Integer id, Integer phonenumber, String password, String title, String name, String pan,
			String kycstatus) {
		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.password = password;
		this.title = title;
		this.name = name;
		this.pan = pan;
		this.kycstatus = kycstatus;
	}
	@Override
	public String toString() {
		return "Userdetalis [id=" + id + ", phonenumber=" + phonenumber + ", password=" + password + ", title=" + title
				+ ", name=" + name + ", pan=" + pan + ", kycstatus=" + kycstatus + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getKycstatus() {
		return kycstatus;
	}
	public void setKycstatus(String kycstatus) {
		this.kycstatus = kycstatus;
	}
	
//	
//	public Integer getId() {
//		return id;
//	}
//	public void setId(Integer id) {
//		this.id = id;
//	}
//	public Long getPhonenumber() {
//		return phonenumber;
//	}
//	public void setPhonenumber(Long phonenumber) {
//		this.phonenumber = phonenumber;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getPan() {
//		return pan;
//	}
//	public void setPan(String pan) {
//		this.pan = pan;
//	}
//	public String getKycstatus() {
//		return kycstatus;
//	}
//	public void setKycstatus(String kycstatus) {
//		this.kycstatus = kycstatus;
//	}
//	@Override
//	public String toString() {
//		return "Userdetalis [id=" + id + ", phonenumber=" + phonenumber + ", password=" + password + ", title=" + title
//				+ ", name=" + name + ", pan=" + pan + ", kycstatus=" + kycstatus + "]";
//	}
//	public Userdetalis(Integer id, Long phonenumber, String password, String title, String name, String pan,
//			String kycstatus) {
//		super();
//		this.id = id;
//		this.phonenumber = phonenumber;
//		this.password = password;
//		this.title = title;
//		this.name = name;
//		this.pan = pan;
//		this.kycstatus = kycstatus;
//	}
//	public Userdetalis() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

}
