//package com.cardmanagementsystem.userinfo;
//
//
//
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//
//import org.hibernate.validator.constraints.Length;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class User {
//	
//    @NotNull
//    @Length(min = 10,max=10, message = " should be 10 digits ")
//	private String phoneNum;
//    @NotNull
//    @Length(min = 8,max=10)
//	private String password;
//    @NotNull
//    @Length(min = 2,max=4)
//	private String title;
//    @NotNull
//    @Length(min = 2,max=100)
//	private String name;
//    @NotNull
//    @Length(min = 10,max=10)
//	private String pan;
//    @NotNull
//    @Length(min = 4,max=8)
//	private String kycStatus;
//
//	}
