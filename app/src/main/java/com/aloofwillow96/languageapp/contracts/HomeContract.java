package com.aloofwillow96.languageapp.contracts;

import android.location.Location;

import com.aloofwillow96.languageapp.models.SoilForeCastResponse;
import com.aloofwillow96.languageapp.models.WeatherResponse;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

public interface HomeContract {
	interface View extends MvpView{
		void updateWeatherResponse(WeatherResponse weatherResponse);
		void updateSoilResponse(SoilForeCastResponse soilResponse);
		void showLoadingView();
		void hideLoadingView();
		void showContentView();
		void hideContentView();
	}
	interface Presenter extends MvpPresenter<View>{
		void loadWeatherData(Location location);
		void loadSoilData(Location currentLocation);
	}
}
