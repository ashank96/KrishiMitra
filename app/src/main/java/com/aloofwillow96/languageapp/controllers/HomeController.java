package com.aloofwillow96.languageapp.controllers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.ViewUtils;
import com.aloofwillow96.languageapp.adapters.HomeAdapter;
import com.aloofwillow96.languageapp.databinding.ConductorHomeBinding;
import com.aloofwillow96.languageapp.models.CropModel;
import com.bluelinelabs.conductor.Controller;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

public class HomeController extends Controller {
	ConductorHomeBinding conductorHomeBinding;
	HomeAdapter homeAdapter;
	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		conductorHomeBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_home,container,false);
		init();
		return conductorHomeBinding.getRoot();
	}

	private void init() {
		homeAdapter = new HomeAdapter();
		GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
		conductorHomeBinding.recyclerView.setLayoutManager(gridLayoutManager);
		conductorHomeBinding.recyclerView.setAdapter(homeAdapter);
		homeAdapter.updateList(getItemList());
	}

	private List<CropModel> getItemList() {
		List<CropModel> cropModelList = new ArrayList<>();
		cropModelList.add(new CropModel(R.drawable.ic_farmer,ViewUtils.getString(R.string.become_a_member),ViewUtils.getString(R.string.join_us)));
		cropModelList.add(new CropModel(R.drawable.ic_crop,ViewUtils.getString(R.string.crop_info),ViewUtils.getString(R.string.check_the_info_about_crops)));
		cropModelList.add(new CropModel(R.drawable.ic_soil,ViewUtils.getString(R.string.soil_info),ViewUtils.getString(R.string.check_soil_health_info_here)));
		cropModelList.add(new CropModel(R.drawable.ic_insecticide,ViewUtils.getString(R.string.pest_control),ViewUtils.getString(R.string.natural_insecticides_and_pestisides)));
		cropModelList.add(new CropModel(R.drawable.ic_insurance,ViewUtils.getString(R.string.insurance),ViewUtils.getString(R.string.crop_security)));
		cropModelList.add(new CropModel(R.drawable.ic_globe,ViewUtils.getString(R.string.important_links),ViewUtils.getString(R.string.find_loads_of_resources)));
		cropModelList.add(new CropModel(R.drawable.ic_question,ViewUtils.getString(R.string.faq),ViewUtils.getString(R.string.ask_us)));
		cropModelList.add(new CropModel(R.drawable.ic_about_us,ViewUtils.getString(R.string.about_us),ViewUtils.getString(R.string.ask_any_queries)));
		return cropModelList;
	}
}
