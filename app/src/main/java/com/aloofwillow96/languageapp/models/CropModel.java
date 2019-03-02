package com.aloofwillow96.languageapp.models;

public class CropModel {
	int drawableId;
	String title;
	String info;

	public int getDrawableId() {
		return drawableId;
	}

	public CropModel(int drawableId, String title, String info) {
		this.drawableId = drawableId;
		this.title = title;
		this.info = info;
	}

	public void setDrawableId(int drawableId) {
		this.drawableId = drawableId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
