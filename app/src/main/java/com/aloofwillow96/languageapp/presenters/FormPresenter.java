package com.aloofwillow96.languageapp.presenters;

import android.util.Log;

import com.aloofwillow96.languageapp.contracts.FormContract;
import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.models.SubmitFormRequest;
import com.aloofwillow96.languageapp.network.APIInterface;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class FormPresenter implements FormContract.Presenter {
	APIInterface apiInterface;
	CompositeDisposable compositeDisposable;
	FormContract.View view;
	private static final String TAG = FormPresenter.class.getSimpleName();
	@Inject
	public FormPresenter(@Named("server")APIInterface apiInterface) {
		this.apiInterface = apiInterface;
		this.compositeDisposable = new CompositeDisposable();
	}

	@Override
	public void loadQuestionsData() {
		view.showLoadingView();
		apiInterface.getQuestionsData().subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new SingleObserver<CropDetailResponse>() {
					@Override
					public void onSubscribe(Disposable d) {
						compositeDisposable.add(d);
					}

					@Override
					public void onSuccess(CropDetailResponse cropDetailResponse) {
						view.hideLoadingView();
						view.updateQuestionResponse(cropDetailResponse);
					}

					@Override
					public void onError(Throwable e) {
						view.hideLoadingView();
						Log.e(TAG,e.getMessage());
					}
				});
	}

	@Override
	public void submitForm(SubmitFormRequest request) {
		apiInterface.submitForm(request).subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(new SingleObserver<String>() {
					@Override
					public void onSubscribe(Disposable d) {
						compositeDisposable.add(d);
					}

					@Override
					public void onSuccess(String string) {
						if(string.startsWith("1")){
							view.onSubmitSuccess();
						}else{
							view.onSubmitFailed();
						}
					}

					@Override
					public void onError(Throwable e) {
						Log.e(TAG,e.getMessage());
						view.onSubmitSuccess();
					}
				});
	}

	@Override
	public void attachView(FormContract.View view) {
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
}
