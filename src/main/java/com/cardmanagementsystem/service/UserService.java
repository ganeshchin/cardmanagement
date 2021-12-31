package com.cardmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;


import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cardmanagementsystem.config.Responses;
import com.cardmanagementsystem.dao.UserDao;
import com.cardmanagementsystem.model.Userdetalis;
import com.cardmanagementsystem.model.Userdetalis.KYCStatus;
import com.cardmanagementsystem.model.Userdetalis.Title;
import com.cardmanagementsystem.userinfo.User;

@Service

public class UserService {

	@Autowired
	private UserDao userdao;
	

	public Responses saveUser(User user) {
		Responses respo = new Responses();
		List<String> errors= new ArrayList<String>();
		try {
			Userdetalis userdetails = new Userdetalis();
			Random random = new Random();
			userdetails.setUserId(random.nextInt());
			if (user.getKycStatus().equals("DONE")) {
				userdetails.setKycStatus(KYCStatus.DONE);

			} else if (userdetails.getKycStatus().equals("NOT_DONE")) {
				userdetails.setKycStatus(KYCStatus.NOT_DONE);
			} else {
				respo.setStatusCode("01");
				respo.setStatusDescription("error");
				respo.setUserdeatils(null);
				respo.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide proper valid status");
				respo.setErrors(errors);
				return respo;
			}

			userdetails.setName(user.getName());
			String pan = user.getPan();
			String regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(pan);
			if (m.matches()) {
				userdetails.setPan(pan);
			} else {
				respo.setStatusCode("01");
				respo.setStatusDescription("error");
				respo.setUserdeatils(null);
				respo.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide  proper pan details");
				respo.setErrors(errors);
				return respo;
			}

			String pwd = user.getPassword();
			userdetails.setPassword(Base64.encodeBase64(pwd.getBytes()).toString());
			userdetails.setPhoneNum(user.getPhoneNum());
			if (user.getTitle().equals("Mr")) {
				userdetails.setTitle(Title.Mr);
			} else if (user.getTitle().equals("Mrs")) {
				userdetails.setTitle(Title.Mrs);

			} else if (user.getTitle().equals("Miss")) {
				userdetails.setTitle(Title.Miss);

			} else {
				respo.setStatusCode("01");
				respo.setStatusDescription("error");
				respo.setUserdeatils(null);
				respo.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("please provide  proper title details");
				respo.setErrors(errors);
				return respo;
			}

			userdetails = userdao.saveUser(userdetails);
			if (!(userdetails == null)) {
				respo.setStatusCode("00");
				respo.setStatusDescription("success");
				respo.setUserdeatils(userdetails);
				respo.setStatus(HttpStatus.CREATED);
				return respo;

			} else {
				respo.setStatusCode("01");
				respo.setStatusDescription("error");
				
				respo.setUserdeatils(null);
				respo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				return respo;

			}
		} catch (Exception ex) {
			respo.setStatusCode("01");
			respo.setStatusDescription(ex.getMessage());
			respo.setUserdeatils(null);
			return respo;

		}
	}

}
