package com.aloofwillow96.languageapp.presenters;

import com.aloofwillow96.languageapp.contracts.SuggestedCropsContract;
import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.network.APIInterface;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SuggestedCropsPresenter implements SuggestedCropsContract.Presenter {
	CompositeDisposable compositeDisposable;
	SuggestedCropsContract.View view;
	private APIInterface apiInterface;

	@Inject
	SuggestedCropsPresenter(@Named("server")APIInterface apiInterface){
		this.apiInterface = apiInterface;
		compositeDisposable = new CompositeDisposable();
	}
	@Override
	public void attachView(SuggestedCropsContract.View view) {
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
		compositeDisposable.clear();
	}

	@Override
	public void loadCropData() {
		view.showLoadingView();
		view.hideContentView();
		apiInterface.getSuggestedCrops().subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new SingleObserver<CropDetailResponse>() {
					@Override
					public void onSubscribe(Disposable d) {
						compositeDisposable.add(d);
					}

					@Override
					public void onSuccess(CropDetailResponse cropDetailResponse) {
						view.hideLoadingView();
						view.showContentView();
						view.setContent(cropDetailResponse.getData());
					}

					@Override
					public void onError(Throwable e) {
					}
				});
	}
}
