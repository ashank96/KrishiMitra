package com.aloofwillow96.languageapp.presenters;

import android.location.Location;
import android.util.Log;

import com.aloofwillow96.languageapp.Constants;
import com.aloofwillow96.languageapp.contracts.HomeContract;
import com.aloofwillow96.languageapp.models.SoilForeCastResponse;
import com.aloofwillow96.languageapp.models.WeatherResponse;
import com.aloofwillow96.languageapp.network.APIInterface;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.Presenter {

	APIInterface apiInterface;
	private HomeContract.View view;
	CompositeDisposable compositeDisposable;

	@Inject
	public HomePresenter(@Named("external") APIInterface apiInterface) {
		this.apiInterface = apiInterface;
		this.compositeDisposable = new CompositeDisposable();
	}

	@Override
	public void loadWeatherData(Location location) {
		view.hideContentView();
		view.showLoadingView();
		apiInterface.getWeatherForeCast(location.getLatitude(),location.getLongitude(),"metric",Constants.API_KEY)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(getWeatherObserver());
	}

	private Observer<? super WeatherResponse> getWeatherObserver() {
			return new Observer<WeatherResponse>() {
				@Override
				public void onSubscribe(Disposable d) {
					compositeDisposable.add(d);
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

//	@Override
//	public void loadSoilData(Location location) {
//		view.showLoadingView();
//		apiInterface.getSoilForeCast(location.getLatitude(),location.getLongitude(),Constants.API_KEY)
//				.subscribeOn(Schedulers.io())
//				.observeOn(AndroidSchedulers.mainThread())
//				.subscribe(getSoilObserver());
//	}

	private Observer<? super SoilForeCastResponse> getSoilObserver() {
		return new Observer<SoilForeCastResponse>() {
			@Override
			public void onSubscribe(Disposable d) {

			}

			@Override
			public void onNext(SoilForeCastResponse soilForeCastResponse) {
				//view.updateSoilResponse(soilForeCastResponse);
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



	@Override
	public void attachView(HomeContract.View view) {
		this.view = view;
	}

	@Override
	public void detachView(boolean retainInstance) {

	}

	@Override
	public void detachView() {
		compositeDisposable.dispose();
	}

	@Override
	public void destroy() {
		compositeDisposable.dispose();
	}
}
