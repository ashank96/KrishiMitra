package com.aloofwillow96.languageapp.models;

import com.aloofwillow96.languageapp.KrishiSahayakApplication;
import com.aloofwillow96.languageapp.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CropDetailResponse {

	@SerializedName("data")
	@Expose
	private List<Data> data = null;

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}

	public class Data {
		@SerializedName("crops")
		@Expose
		private String crops;
		@SerializedName("crop_image")
		@Expose
		private String cropImage;
		@SerializedName("relative_humidity_percent")
		@Expose
		private String relativeHumidityPercent;
		@SerializedName("avg_wind_velocity")
		@Expose
		private String avgWindVelocity;
		@SerializedName("max_temp")
		@Expose
		private String maxTemp;
		@SerializedName("min_temp")
		@Expose
		private String minTemp;
		@SerializedName("soil_density")
		@Expose
		private String soilDensity;
		@SerializedName("soil_type")
		@Expose
		private String soilType;
		@SerializedName("min_price")
		@Expose
		private String minPrice;
		@SerializedName("max_price")
		@Expose
		private String maxPrice;

		@SerializedName("required")
		@Expose
		private Integer required;

		@SerializedName("fulfilled")
		@Expose
		private Integer fulfilled;

		@SerializedName("type")
		@Expose
		private Integer type;

		private float land;

		private boolean isChecked;

		private int selection;

		public String getCrops() {
			return crops;
		}

		public void setCrops(String crops) {
			crops.replaceAll(KrishiSahayakApplication.getInstanceContext().getString(R.string.regex_url)," ");
			this.crops = crops;
		}


		public String getCropImage() {
			return cropImage;
		}

		public void setCropImage(String cropImage) {
			cropImage.replaceAll(KrishiSahayakApplication.getInstanceContext().getString(R.string.regex_url),"/");
			this.cropImage = cropImage;
		}


		public String getRelativeHumidityPercent() {
			return relativeHumidityPercent;
		}

		public void setRelativeHumidityPercent(String relativeHumidityPercent) {
			this.relativeHumidityPercent = relativeHumidityPercent;
		}


		public String getAvgWindVelocity() {
			return avgWindVelocity;
		}

		public void setAvgWindVelocity(String avgWindVelocity) {
			this.avgWindVelocity = avgWindVelocity;
		}


		public String getMaxTemp() {
			return maxTemp;
		}

		public void setMaxTemp(String maxTemp) {
			this.maxTemp = maxTemp;
		}


		public String getMinTemp() {
			return minTemp;
		}

		public void setMinTemp(String minTemp) {
			this.minTemp = minTemp;
		}


		public String getSoilDensity() {
			return soilDensity;
		}

		public void setSoilDensity(String soilDensity) {
			this.soilDensity = soilDensity;
		}


		public String getSoilType() {
			return soilType;
		}

		public void setSoilType(String soilType) {
			this.soilType = soilType;
		}


		public String getMinPrice() {
			return minPrice;
		}

		public void setMinPrice(String minPrice) {
			this.minPrice = minPrice;
		}


		public String getMaxPrice() {
			return maxPrice;
		}

		public void setMaxPrice(String maxPrice) {
			this.maxPrice = maxPrice;
		}

		public float getLand() {
			return land;
		}

		public void setLand(float land) {
			this.land = land;
		}

		public boolean isChecked() {
			return isChecked;
		}

		public void setChecked(boolean checked) {
			isChecked = checked;
		}

		public int getSelection() {
			return selection;
		}

		public void setSelection(int selection) {
			this.selection = selection;
		}

		public Integer getRequired() {
			return required;
		}

		public void setRequired(Integer required) {
			this.required = required;
		}

		public Integer getFulfilled() {
			return fulfilled;
		}

		public void setFulfilled(Integer fulfilled) {
			this.fulfilled = fulfilled;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}

		public String getMaxPriceString(){
			return "Max-Price : \u20B9 "+maxPrice;
		}

		public String getMinPriceString(){
			return "Min-Price : \u20B9 "+minPrice;
		}
	}

}
