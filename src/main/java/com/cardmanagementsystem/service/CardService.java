package com.cardmanagementsystem.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.cardmanagementsystem.config.Response;
import com.cardmanagementsystem.dao.AddressDao;
import com.cardmanagementsystem.dao.CardDao;
import com.cardmanagementsystem.dao.UserDao;
import com.cardmanagementsystem.model.AddressDetails;
import com.cardmanagementsystem.model.CardDetails;
import com.cardmanagementsystem.model.UserDetails;

@Service
public class CardService {
	@Autowired
	private CardDao cardDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private AddressDao addressDao;

	List<String> errors = new ArrayList<String>();

	public Response saveCard(CardDetails cardetails) {
		Response response = new Response();
		UserDetails userdetails = null;
		CardDetails dbcarddetails = null;
		AddressDetails addressdetails = null;
		String cardNumber = null;

		if (!cardetails.getCardType().equals("DEBIT") && !cardetails.getCardType().equals("CREDIT")) {
			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setCardDetails(null);
			response.setStatus(HttpStatus.BAD_REQUEST);
			errors.add("please provide proper card type");
			response.setErrors(errors);
			return response;
		}

		cardetails.setCardNumber(encoder(cardetails.getCardNumber()));
		if (!cardetails.getCardStatus().equals("ACTIVE") && !cardetails.getCardStatus().equals("INACTIVE")) {

			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setCardDetails(null);
			response.setStatus(HttpStatus.BAD_REQUEST);
			errors.add("please provide  proper card status");
			response.setErrors(errors);
			return response;
		}
		try {
			userdetails = userDao.findUserById(cardetails.getUserId());

			if (userdetails == null) {

				response.setStatusCode("01");
				response.setStatusDescription("error");
				response.setUserDetails(null);
				response.setStatus(HttpStatus.BAD_REQUEST);
				errors.add("given userid is not available in userstable");
				response.setErrors(errors);
				return response;

			} else {
				addressdetails = addressDao.findAddressByUserId(cardetails.getUserId());
				if (addressdetails == null) {

					response.setStatusCode("01");
					response.setStatusDescription("error");
					response.setUserDetails(null);
					response.setStatus(HttpStatus.BAD_REQUEST);
					errors.add("given userid is not available in addresstable");
					response.setErrors(errors);
					return response;

				}
				dbcarddetails = cardDao.saveCard(cardetails);

				if (dbcarddetails != null) {
					response.setStatusCode("00");
					response.setStatusDescription("success");
					response.setUserDetails(userdetails);
					response.setStatus(HttpStatus.CREATED);
					response.setCardDetails(dbcarddetails);
					return response;

				} else {
					response.setStatusCode("01");
					response.setStatusDescription("error");
					response.setUserDetails(null);
					response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
					errors.add("data not inserted due to internal error");
					response.setErrors(errors);
					return response;

				}
			}

		} catch (Exception e) {
			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setUserDetails(null);
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			errors.add("internal server error");
			response.setErrors(errors);
		}

		return response;
	}

	public Response getCardById(int id) {

		CardDetails dbCardDetails = null;
		Response response = new Response();
		dbCardDetails = cardDao.findCardById(id);
		if (dbCardDetails == null) {

			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setCardDetails(null);
			response.setStatus(HttpStatus.NO_CONTENT);
			errors.add("card details not available for given userid");
			response.setErrors(errors);
			return response;

		} else {
			response.setStatusCode("00");
			response.setStatusDescription("success");
			dbCardDetails.setCardNumber(maskCardNumber(decoder(dbCardDetails.getCardNumber())));
			response.setCardDetails(dbCardDetails);
			response.setStatus(HttpStatus.FOUND);

		}
		return response;
	}

	public Response getAllCardDetails() {
		Response response = new Response();
		List<CardDetails> allDbCardDetails;
		List<CardDetails> newDbCardDetails = new ArrayList<CardDetails>();

		allDbCardDetails = cardDao.getAllCards();
		System.out.println("emyna print chei" + allDbCardDetails);
		if (allDbCardDetails == null || allDbCardDetails.isEmpty()) {

			response.setStatusCode("01");
			response.setStatusDescription("error");
			response.setCardDetails(null);
			response.setStatus(HttpStatus.NOT_FOUND);
			errors.add("given userid is not available in cardtable");
			response.setErrors(errors);
			return response;
		} else {
			for (CardDetails cardDetails : allDbCardDetails) {
				cardDetails.setCardNumber(maskCardNumber(decoder(cardDetails.getCardNumber())));
				newDbCardDetails.add(cardDetails);

			}
			response.setStatusCode("00");
			response.setStatusDescription("success");
			response.setAllCardDetails(newDbCardDetails);
			response.setStatus(HttpStatus.FOUND);
			return response;
		}

	}

	private String encoder(String cardNumber) {

		return Base64.getEncoder().encodeToString(cardNumber.getBytes());
	}

	private String decoder(String enCardNumber) {
		String decode = new String(Base64.getDecoder().decode(enCardNumber));
		return decode;
	}

	private String maskCardNumber(String cardNumber) {
		return cardNumber.replaceAll("\\w(?=\\w{4})", "X");
	}

}
