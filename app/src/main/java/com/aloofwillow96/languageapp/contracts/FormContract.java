package com.aloofwillow96.languageapp.contracts;

import android.location.Location;

import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.models.SubmitFormRequest;
import com.aloofwillow96.languageapp.models.WeatherResponse;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

public interface FormContract {
	interface View extends MvpView{
		void updateQuestionResponse(CropDetailResponse cropDetailResponse);
		void showLoadingView();
		void hideLoadingView();
		void showContentView();
		void hideContentView();
		void onSubmitSuccess();
		void onSubmitFailed();

	}
	interface Presenter extends MvpPresenter<View>{
		void loadQuestionsData();

		void submitForm(SubmitFormRequest request);
		//void loadSoilData(Location currentLocation);
	}
}
