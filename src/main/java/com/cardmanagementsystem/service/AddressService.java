package com.cardmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cardmanagementsystem.config.Response;
import com.cardmanagementsystem.dao.AddressDao;
import com.cardmanagementsystem.dao.UserDao;
import com.cardmanagementsystem.model.AddressDetails;
import com.cardmanagementsystem.model.UserDetalis;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	@Autowired
	private UserDao userDao;
	List<String> errors = new ArrayList<String>();

	public Response saveAddress(AddressDetails address) {
		Response response = new Response();
		AddressDetails dbAddressDetails = null;
		UserDetalis userDetails = null;
		try {
			userDetails = userDao.findUserById(address.getUserId());
			if (userDetails == null) {

				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("given userid is not available in userstable");
				response.setErrors(errors);
				return response;

			}
			dbAddressDetails = addressDao.saveAddress(address);

			if (!(dbAddressDetails == null)) {
				response.setStatusCode("00");
				response.setStatusDescription("success");
				response.setUserdeatils(userDetails);
				response.setStatus(HttpStatus.CREATED);
				response.setAddressdetails(dbAddressDetails);
				return response;

			} else {
				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserdeatils(null);
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
				return response;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

}
