package com.aloofwillow96.languageapp.controllers;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.KrishiSahayakApplication;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.ViewUtils;
import com.aloofwillow96.languageapp.adapters.SuggestedCropsAdapter;
import com.aloofwillow96.languageapp.contracts.SuggestedCropsContract;
import com.aloofwillow96.languageapp.databinding.ConductorCheckboxFormBinding;
import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.presenters.SuggestedCropsPresenter;
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

public class SuggestedCropsController extends MvpController<SuggestedCropsContract.View,SuggestedCropsPresenter> implements SuggestedCropsContract.View {
	ConductorCheckboxFormBinding formBinding;
	SuggestedCropsAdapter adapter;
	List<CropDetailResponse.Data> cropList;
	int itemSelected = 0 ;
	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		formBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_checkbox_form, container, false);
		cropList = new ArrayList<>();
		init();
		setRetainViewMode(RetainViewMode.RETAIN_DETACH);
		return formBinding.getRoot();
	}

	private void init() {
		adapter = new SuggestedCropsAdapter(new SuggestedCropsAdapter.OnGridCropItemListener() {
			@Override
			public void onClick(final CropDetailResponse.Data crop, int position) {
				ViewUtils.makeToastShort(getActivity(),crop.getCrops());
				final String[] singleChoiceItems = getResources().getStringArray(R.array.land_suggestions);
				new AlertDialog.Builder(getActivity())
						.setTitle("How much "+crop.getCrops()+"?")
						.setSingleChoiceItems(singleChoiceItems, itemSelected, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int selectedIndex) {
									itemSelected = selectedIndex;
							}
						})
						.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								validateRegistration(singleChoiceItems[itemSelected], crop);
							}
						})
						.setNegativeButton("Cancel", null)
						.show();
			}
		});

		formBinding.proceedButton.setVisibility(View.GONE);
		formBinding.title.setText("Register crops to grow");
		GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
		formBinding.recyclerView.setLayoutManager(gridLayoutManager);
		formBinding.recyclerView.setAdapter(adapter);
		formBinding.recyclerView.setNestedScrollingEnabled(false);
	}

	private void validateRegistration(String singleChoiceItem, CropDetailResponse.Data crop) {

	}

	@NonNull
	@Override
	public SuggestedCropsPresenter createPresenter() {
		return KrishiSahayakApplication.getInstance().getComponent().getSuggestedCropPresenter();
	}

	@Override
	protected void onAttach(@NonNull View view) {
		super.onAttach(view);
		getPresenter().attachView(this);
		getPresenter().loadCropData();
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
	public void setContent(List<CropDetailResponse.Data> data) {
		cropList.clear();
		cropList.addAll(data);
		adapter.updateList(data);
	}
}
