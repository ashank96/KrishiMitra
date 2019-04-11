package com.aloofwillow96.languageapp.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.Constants;
import com.aloofwillow96.languageapp.KrishiPreferences;
import com.aloofwillow96.languageapp.KrishiSahayakApplication;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.adapters.FormAdapter;
import com.aloofwillow96.languageapp.contracts.FormContract;
import com.aloofwillow96.languageapp.databinding.ConductorCheckboxFormBinding;
import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.models.SubmitFormRequest;
import com.aloofwillow96.languageapp.presenters.FormPresenter;
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.firebase.auth.FirebaseAuth;
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

public class FormController extends MvpController<FormContract.View, FormPresenter> implements FormContract.View {

	ConductorCheckboxFormBinding formBinding;
	List<CropDetailResponse.Data> filteredList;
	FormAdapter adapter;

	public FormController() {
		this.filteredList = new ArrayList<>();
	}

	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		formBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_checkbox_form, container, false);
		init();
		return formBinding.getRoot();
	}

	private void init() {
		adapter = new FormAdapter();
		adapter.setFormListener(new FormAdapter.FormListener() {
			@Override
			public void onItemChecked(CropDetailResponse.Data data) {
				for (int i = 0; i < filteredList.size(); i++) {
					if (filteredList.get(i).getCrops().equals(data.getCrops())) {
						filteredList.remove(i);
						break;
					}
				}
				filteredList.add(data);
				if (filteredList.size() > 0) {
					formBinding.proceedButton.setEnabled(true);
				}
			}

			@Override
			public void onItemUnchecked(CropDetailResponse.Data data) {
				filteredList.remove(data);
				if (FormController.this.filteredList.size() == 0) {
					formBinding.proceedButton.setEnabled(false);
				}
			}
		});
		formBinding.recyclerView.setAdapter(adapter);
		formBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
		initProceedButton();
	}

	private void initProceedButton() {
		formBinding.proceedButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getPresenter().submitForm(
						new SubmitFormRequest(FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(),
								"Tumkur",
								filteredList,KrishiPreferences.getInstance().getString(Constants.FCM_TOKEN,"")));
			}
		});
	}

	@Override
	protected void onAttach(@NonNull View view) {
		super.onAttach(view);
		getPresenter().loadQuestionsData();
	}

	@NonNull
	@Override
	public FormPresenter createPresenter() {
		return KrishiSahayakApplication.getInstance().getComponent().getFormPrsenter();
	}

	@Override
	public void updateQuestionResponse(CropDetailResponse cropDetailResponse) {
		adapter.updateList(cropDetailResponse.getData());
	}

	@Override
	public void showLoadingView() {
		formBinding.loadingView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoadingView() {
		formBinding.loadingView.setVisibility(View.GONE);
	}

	@Override
	public void showContentView() {
		formBinding.loadingView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideContentView() {
		formBinding.loadingView.setVisibility(View.GONE);
	}

	@Override
	public void onSubmitSuccess() {
		getRouter().pushController(RouterTransaction.with(new HomeController()));
	}

	@Override
	public void onSubmitFailed() {

	}
}
