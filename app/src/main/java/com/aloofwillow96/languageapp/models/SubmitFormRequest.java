package com.aloofwillow96.languageapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubmitFormRequest {

	@SerializedName("phone")
	@Expose
	private String phoneNumber;

	@SerializedName("district")
	@Expose
	private String district;

	@SerializedName("token")
	@Expose
	private String token;

	@SerializedName("crop_list")
	@Expose
	private List<CropDetailResponse.Data> cropList;

	public SubmitFormRequest(String phoneNumber, String district, List<CropDetailResponse.Data> cropList, String token) {
		this.phoneNumber = phoneNumber;
		this.district = district;
		this.cropList = cropList;
		this.token = token;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public List<CropDetailResponse.Data> getCropList() {
		return cropList;
	}

	public void setCropList(List<CropDetailResponse.Data> cropList) {
		this.cropList = cropList;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
