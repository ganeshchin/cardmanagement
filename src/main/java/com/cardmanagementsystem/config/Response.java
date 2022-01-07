package com.cardmanagementsystem.config;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cardmanagementsystem.model.AddressDetails;
import com.cardmanagementsystem.model.CardDetails;
import com.cardmanagementsystem.model.Userdetalis;

public class Response {
	private HttpStatus status;
	private String statusCode;
	private String statusDescription;
	private Userdetalis userdeatils;
	private AddressDetails addressdetails;
	private CardDetails cardDetails;
	private List<CardDetails> allCardDetails;
	private List<String> errors;

	public List<CardDetails> getAllCardDetails() {
		return allCardDetails;
	}

	public void setAllCardDetails(List<CardDetails> allCardDetails) {
		this.allCardDetails = allCardDetails;
	}

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Userdetalis getUserdeatils() {
		return userdeatils;
	}

	public void setUserdeatils(Userdetalis userdeatils) {
		this.userdeatils = userdeatils;
	}

	public AddressDetails getAddressdetails() {
		return addressdetails;
	}

	public void setAddressdetails(AddressDetails addressdetails) {
		this.addressdetails = addressdetails;
	}
}
