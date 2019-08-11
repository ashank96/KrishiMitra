package com.aloofwillow96.languageapp.models;

public class UpdateTokenRequest {
	String phone;
	String token;

	public UpdateTokenRequest(String phone, String token) {
		this.phone = phone;
		this.token = token;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
