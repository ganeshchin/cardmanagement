package com.cardmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cardmanagementsystem.config.Response;
import com.cardmanagementsystem.dao.AddressDao;
import com.cardmanagementsystem.dao.UserDao;
import com.cardmanagementsystem.model.AddressDetails;
import com.cardmanagementsystem.model.UserDetalis;

@Service

public class UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private AddressDao addressDao;

//	public Response saveUser(User user) {
//		Response response = new Response();
//		List<String> errors = new ArrayList<String>();
//		try {
//			Userdetalis userdetails = new Userdetalis();
//			Random random = new Random();
//			userdetails.setUserId(random.nextInt());
//			if (user.getKycStatus().equals("DONE")) {
//				userdetails.setKycStatus(KYCStatus.DONE);
//
//			} else if (userdetails.getKycStatus().equals("NOT_DONE")) {
//				userdetails.setKycStatus(KYCStatus.NOT_DONE);
//			} else {
//				response.setStatusCode("01");
//				response.setStatusDescription("error");
//				response.setUserdeatils(null);
//				response.setStatus(HttpStatus.BAD_REQUEST);
//				errors.add("please provide proper valid status");
//				response.setErrors(errors);
//				return response;
//			}
//
//			userdetails.setName(user.getName());
//			String pan = user.getPan();
//			String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
//			Pattern p = Pattern.compile(regex);
//			Matcher m = p.matcher(pan);
//			if (m.matches()) {
//				userdetails.setPan(pan);
//			} else {
//				response.setStatusCode("01");
//				response.setStatusDescription("error");
//				response.setUserdeatils(null);
//				response.setStatus(HttpStatus.BAD_REQUEST);
//				errors.add("please provide  proper pan details");
//				response.setErrors(errors);
//				return response;
//			}
//
//			String pwd = user.getPassword();
//			userdetails.setPassword(Base64.encodeBase64(pwd.getBytes()).toString());
//			userdetails.setPhoneNum(user.getPhoneNum());
//			if (user.getTitle().equals("Mr")) {
//				userdetails.setTitle(Title.Mr);
//			} else if (user.getTitle().equals("Mrs")) {
//				userdetails.setTitle(Title.Mrs);
//
//			} else if (user.getTitle().equals("Miss")) {
//				userdetails.setTitle(Title.Miss);
//
//			} else {
//				response.setStatusCode("01");
//				response.setStatusDescription("error");
//				response.setUserdeatils(null);
//				response.setStatus(HttpStatus.BAD_REQUEST);
//				errors.add("please provide  proper title details");
//				response.setErrors(errors);
//				return response;
//			}
//
//			userdetails = userdao.saveUser(userdetails);
//
//			if (!(userdetails == null)) {
//				response.setStatusCode("00");
//				response.setStatusDescription("success");
//				response.setUserdeatils(userdetails);
//				response.setStatus(HttpStatus.CREATED);
//				return response;
//
//			} else {
//				response.setStatusCode("01");
//				response.setStatusDescription("error");
//				response.setUserdeatils(null);
//				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//				return response;
//
//			}
//		} catch (Exception ex) {
//			response.setStatusCode("01");
//			response.setStatusDescription(ex.getMessage());
//			response.setUserdeatils(null);
//			return response;
//
//		}
//	}

	public Response createUser(UserDetalis userDetails) {
		Response response = new Response();
		List<String> errors = new ArrayList<String>();
		try {

			Random random = new Random();
			userDetails.setUserId(random.nextInt());
			if (!userDetails.getKycStatus().equals("DONE") && !userDetails.getKycStatus().equals("NOT_DONE")) {
				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide proper valid status");
				response.setErrors(errors);
				return response;
			}

			String pan = userDetails.getPan();
			String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(pan);
			if (!m.matches()) {
				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide  proper pan details");
				response.setErrors(errors);
				return response;
			}

			String pwd = userDetails.getPassword();
			userDetails.setPassword(Base64.encodeBase64(pwd.getBytes()).toString());
			if (!userDetails.getTitle().equals("Mr") && !userDetails.getTitle().equals("Mrs") && !userDetails.getTitle().equals("Miss")) {
				
				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide  proper title details");
				response.setErrors(errors);
				return response;
			}

			userDetails = userdao.saveUser(userDetails);

			if (!(userDetails == null)) {
				response.setStatusCode("00");
				response.setStatusDescription("success");
				response.setUserdeatils(userDetails);
				response.setStatus(HttpStatus.CREATED);
				return response;

			} else {
				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				return response;

			}
		} catch (Exception ex) {
			response.setStatusCode("01");
			response.setStatusDescription(ex.getMessage());
			response.setUserdeatils(null);
			return response;

		}
	}

	public Response getUserAndAddressDetailsById(int userId) {
		Response response=new Response();
		UserDetalis dbUserDetails=null;
		AddressDetails dbAddressDetails=null;
		dbUserDetails=userdao.findUserById(userId);
		dbAddressDetails=addressDao.findAddressByUserId(userId);
		List<String> errors=new ArrayList<String>();
		if (dbUserDetails != null && dbAddressDetails!=null) {
			response.setStatusCode("00");
			response.setStatusDescription("success");
			response.setAddressdetails(dbAddressDetails);
			response.setUserdeatils(dbUserDetails);
			response.setStatus(HttpStatus.CREATED);
			return response;

		} else {
			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setUserdeatils(dbUserDetails);
			response.setStatus(HttpStatus.NOT_FOUND);
			if(dbUserDetails==null) {
				errors.add("user data not found in usertable");
				response.setUserdeatils(dbUserDetails);
			}
			else {
				errors.add("user data not found in address table");
				
			}
			
			response.setErrors(errors);
			return response;

		}
		
		
	}

}
