
package com.aloofwillow96.languageapp.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoilForeCastResponse {

	@SerializedName("data")
	@Expose
	private List<Datum> data = null;
	@SerializedName("lat")
	@Expose
	private Double lat;
	@SerializedName("lon")
	@Expose
	private Double lon;

	public List<Datum> getData() {
		return data;
	}

	public void setData(List<Datum> data) {
		this.data = data;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public class Datum {

		@SerializedName("v_soilm_40_100cm")
		@Expose
		private Double vSoilm40100cm;

		@SerializedName("dlwrf_avg")
		@Expose
		private Double dlwrfAvg;

		@SerializedName("skin_temp_min")
		@Expose
		private Double skinTempMin;

		@SerializedName("v_soilm_10_40cm")
		@Expose
		private Double vSoilm1040cm;

		@SerializedName("soilm_40_100cm")
		@Expose
		private Double soilm40100cm;

		@SerializedName("dlwrf_max")
		@Expose
		private Double dlwrfMax;

		@SerializedName("dlwrf_net")
		@Expose
		private Double dlwrfNet;

		@SerializedName("soilm_0_10cm")
		@Expose
		private Double soilm010cm;

		@SerializedName("specific_humidity")
		@Expose
		private Double specificHumidity;
		@SerializedName("evapotranspiration")
		@Expose
		private Double evapotranspiration;
		@SerializedName("soilm_10_40cm")
		@Expose
		private Double soilm1040cm;
		@SerializedName("valid_date")
		@Expose
		private String validDate;
		@SerializedName("v_soilm_100_200cm")
		@Expose
		private Double vSoilm100200cm;
		@SerializedName("soilt_100_200cm")
		@Expose
		private Double soilt100200cm;
		@SerializedName("bulk_soil_density")
		@Expose
		private Double bulkSoilDensity;
		@SerializedName("temp_2m_avg")
		@Expose
		private Double temp2mAvg;

		@SerializedName("dswrf_net")
		@Expose
		private Double dswrfNet;

		@SerializedName("v_soilm_0_10cm")
		@Expose
		private Double vSoilm010cm;
		@SerializedName("soilt_0_10cm")
		@Expose
		private Double soilt010cm;
		@SerializedName("wind_10m_spd_avg")
		@Expose
		private Double wind10mSpdAvg;
		@SerializedName("precip")
		@Expose
		private Double precip;
		@SerializedName("dswrf_avg")
		@Expose
		private Double dswrfAvg;
		@SerializedName("pres_avg")
		@Expose
		private Double presAvg;
		@SerializedName("soilm_100_200cm")
		@Expose
		private Double soilm100200cm;
		@SerializedName("soilt_40_100cm")
		@Expose
		private Double soilt40100cm;
		@SerializedName("soilt_10_40cm")
		@Expose
		private Double soilt1040cm;
		@SerializedName("dswrf_max")
		@Expose
		private Double dswrfMax;
		@SerializedName("skin_temp_avg")
		@Expose
		private Double skinTempAvg;
		@SerializedName("skin_temp_max")
		@Expose
		private Double skinTempMax;

		public Double getVSoilm40100cm() {
			return vSoilm40100cm;
		}

		public void setVSoilm40100cm(Double vSoilm40100cm) {
			this.vSoilm40100cm = vSoilm40100cm;
		}

		public Double getDlwrfAvg() {
			return dlwrfAvg;
		}

		public void setDlwrfAvg(Double dlwrfAvg) {
			this.dlwrfAvg = dlwrfAvg;
		}

		public Double getSkinTempMin() {
			return skinTempMin;
		}

		public void setSkinTempMin(Double skinTempMin) {
			this.skinTempMin = skinTempMin;
		}

		public Double getVSoilm1040cm() {
			return vSoilm1040cm;
		}

		public void setVSoilm1040cm(Double vSoilm1040cm) {
			this.vSoilm1040cm = vSoilm1040cm;
		}

		public Double getSoilm40100cm() {
			return soilm40100cm;
		}

		public void setSoilm40100cm(Double soilm40100cm) {
			this.soilm40100cm = soilm40100cm;
		}

		public Double getDlwrfMax() {
			return dlwrfMax;
		}

		public void setDlwrfMax(Double dlwrfMax) {
			this.dlwrfMax = dlwrfMax;
		}

		public Double getDlwrfNet() {
			return dlwrfNet;
		}

		public void setDlwrfNet(Double dlwrfNet) {
			this.dlwrfNet = dlwrfNet;
		}

		public Double getSoilm010cm() {
			return soilm010cm;
		}

		public void setSoilm010cm(Double soilm010cm) {
			this.soilm010cm = soilm010cm;
		}

		public Double getSpecificHumidity() {
			return specificHumidity;
		}

		public void setSpecificHumidity(Double specificHumidity) {
			this.specificHumidity = specificHumidity;
		}

		public Double getEvapotranspiration() {
			return evapotranspiration;
		}

		public void setEvapotranspiration(Double evapotranspiration) {
			this.evapotranspiration = evapotranspiration;
		}

		public Double getSoilm1040cm() {
			return soilm1040cm;
		}

		public void setSoilm1040cm(Double soilm1040cm) {
			this.soilm1040cm = soilm1040cm;
		}

		public String getValidDate() {
			return validDate;
		}

		public void setValidDate(String validDate) {
			this.validDate = validDate;
		}

		public Double getVSoilm100200cm() {
			return vSoilm100200cm;
		}

		public void setVSoilm100200cm(Double vSoilm100200cm) {
			this.vSoilm100200cm = vSoilm100200cm;
		}

		public Double getSoilt100200cm() {
			return soilt100200cm;
		}

		public void setSoilt100200cm(Double soilt100200cm) {
			this.soilt100200cm = soilt100200cm;
		}

		public Double getBulkSoilDensity() {
			return bulkSoilDensity;
		}

		public void setBulkSoilDensity(Double bulkSoilDensity) {
			this.bulkSoilDensity = bulkSoilDensity;
		}

		public Double getTemp2mAvg() {
			return temp2mAvg;
		}

		public void setTemp2mAvg(Double temp2mAvg) {
			this.temp2mAvg = temp2mAvg;
		}

		public Double getDswrfNet() {
			return dswrfNet;
		}

		public void setDswrfNet(Double dswrfNet) {
			this.dswrfNet = dswrfNet;
		}

		public Double getVSoilm010cm() {
			return vSoilm010cm;
		}

		public void setVSoilm010cm(Double vSoilm010cm) {
			this.vSoilm010cm = vSoilm010cm;
		}

		public Double getSoilt010cm() {
			return soilt010cm;
		}

		public void setSoilt010cm(Double soilt010cm) {
			this.soilt010cm = soilt010cm;
		}

		public Double getWind10mSpdAvg() {
			return wind10mSpdAvg;
		}

		public void setWind10mSpdAvg(Double wind10mSpdAvg) {
			this.wind10mSpdAvg = wind10mSpdAvg;
		}

		public Double getPrecip() {
			return precip;
		}

		public void setPrecip(Double precip) {
			this.precip = precip;
		}

		public Double getDswrfAvg() {
			return dswrfAvg;
		}

		public void setDswrfAvg(Double dswrfAvg) {
			this.dswrfAvg = dswrfAvg;
		}

		public Double getPresAvg() {
			return presAvg;
		}

		public void setPresAvg(Double presAvg) {
			this.presAvg = presAvg;
		}

		public Double getSoilm100200cm() {
			return soilm100200cm;
		}

		public void setSoilm100200cm(Double soilm100200cm) {
			this.soilm100200cm = soilm100200cm;
		}

		public Double getSoilt40100cm() {
			return soilt40100cm;
		}

		public void setSoilt40100cm(Double soilt40100cm) {
			this.soilt40100cm = soilt40100cm;
		}

		public Double getSoilt1040cm() {
			return soilt1040cm;
		}

		public void setSoilt1040cm(Double soilt1040cm) {
			this.soilt1040cm = soilt1040cm;
		}

		public Double getDswrfMax() {
			return dswrfMax;
		}

		public void setDswrfMax(Double dswrfMax) {
			this.dswrfMax = dswrfMax;
		}

		public Double getSkinTempAvg() {
			return skinTempAvg;
		}

		public void setSkinTempAvg(Double skinTempAvg) {
			this.skinTempAvg = skinTempAvg;
		}

		public Double getSkinTempMax() {
			return skinTempMax;
		}

		public void setSkinTempMax(Double skinTempMax) {
			this.skinTempMax = skinTempMax;
		}
	}
}