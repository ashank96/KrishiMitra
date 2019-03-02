package com.aloofwillow96.languageapp.adapters;

import android.view.LayoutInflater;

import android.view.ViewGroup;

import com.aloofwillow96.languageapp.BindingAdapters;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.databinding.ItemCropsGatewayBinding;
import com.aloofwillow96.languageapp.models.CropModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
	List<CropModel> cropModelList;
	ItemCropsGatewayBinding cropsGatewayBinding;

	public HomeAdapter() {
		this.cropModelList = new ArrayList<>();
	}

	@NonNull
	@Override
	public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		cropsGatewayBinding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()),
				R.layout.item_crops_gateway, parent, false);
		return new HomeViewHolder(cropsGatewayBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
		CropModel cropModel = cropModelList.get(position);
		holder.bind(cropModel);
	}

	@Override
	public int getItemCount() {
		return cropModelList.size();
	}

	public void updateList(List<CropModel> cropModels) {
		this.cropModelList.addAll(cropModels);
		notifyDataSetChanged();
	}

	class HomeViewHolder extends RecyclerView.ViewHolder {

		ItemCropsGatewayBinding cropsGatewayBinding;

		public HomeViewHolder(ItemCropsGatewayBinding cropsGatewayBinding) {
			super(cropsGatewayBinding.getRoot());
			this.cropsGatewayBinding = cropsGatewayBinding;

		}

		public void bind(CropModel cropModel) {
			cropsGatewayBinding.setCropModel(cropModel);
			BindingAdapters.setImageDrawable(cropsGatewayBinding.itemCropsGatewayImageView, cropModel.getDrawableId());
		}


	}
}
