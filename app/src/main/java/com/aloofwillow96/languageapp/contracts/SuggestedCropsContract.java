package com.aloofwillow96.languageapp.contracts;

import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

public interface SuggestedCropsContract {
	interface View extends MvpView {
	
		//void updateSoilResponse(SoilForeCastResponse soilResponse);
		void showLoadingView();
		void hideLoadingView();
		void showContentView();
		void hideContentView();

		void setContent(List<CropDetailResponse.Data> data);
	}
	interface Presenter extends MvpPresenter<View> {
		void loadCropData();

		//void loadSoilData(Location currentLocation);
	}
}
