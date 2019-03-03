package com.aloofwillow96.languageapp.presenters;

import android.location.Location;
import android.util.Log;

import com.aloofwillow96.languageapp.Constants;
import com.aloofwillow96.languageapp.contracts.HomeContract;
import com.aloofwillow96.languageapp.models.SoilForeCastResponse;
import com.aloofwillow96.languageapp.models.WeatherResponse;
import com.aloofwillow96.languageapp.network.APIInterface;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

	APIInterface apiInterface;
	private HomeContract.View view;

	@Inject
	public HomePresenter(APIInterface apiInterface){
		this.apiInterface = apiInterface;
	}

	@Override
	public void loadWeatherData(Location location) {
		apiInterface.getWeatherForeCast(location.getLatitude(),location.getLongitude(),1,Constants.API_KEY)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(getWeatherObserver());
	}

	@Override
	public void loadSoilData(Location location) {
		apiInterface.getSoilForeCast(location.getLatitude(),location.getLongitude(),Constants.API_KEY)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(getSoilObserver());
	}

	private Observer<? super SoilForeCastResponse> getSoilObserver() {
		return new Observer<SoilForeCastResponse>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(SoilForeCastResponse soilForeCastResponse) {
				view.updateSoilResponse(soilForeCastResponse);
			}

			@Override
			public void onError(Throwable e) {
				Log.i(getClass().getSimpleName()+" Error","Retrofit Soil");
			}

			@Override
			public void onComplete() {

			}
		};
	}

	private Observer<? super WeatherResponse> getWeatherObserver() {
		return new Observer<WeatherResponse>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(WeatherResponse weatherResponse) {
				view.updateWeatherResponse(weatherResponse);
			}

			@Override
			public void onError(Throwable e) {
				Log.i(getClass().getSimpleName()+" Error","Retrofit Weather");
			}

			@Override
			public void onComplete() {

			}
		};
	}

	@Override
	public void attachView(HomeContract.View view) {
		this.view = view;
	}

	@Override
	public void detachView(boolean retainInstance) {

	}

	@Override
	public void detachView() {

	}

	@Override
	public void destroy() {

	}
}
