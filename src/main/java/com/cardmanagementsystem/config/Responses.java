package com.cardmanagementsystem.config;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.cardmanagementsystem.model.Userdetalis;

public class Responses {
	private HttpStatus status;
	private String statusCode;
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	private String statusDescription;
	private Userdetalis userdeatils;
	private List<String> errors;

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

}
