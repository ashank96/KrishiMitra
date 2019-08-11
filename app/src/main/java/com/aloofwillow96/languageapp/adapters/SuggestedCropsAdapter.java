package com.aloofwillow96.languageapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.databinding.ItemSuggestedCropBinding;
import com.aloofwillow96.languageapp.models.CropDetailResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class SuggestedCropsAdapter extends RecyclerView.Adapter<SuggestedCropsAdapter.HomeViewHolder> {
	List<CropDetailResponse.Data> cropModelList;
	ItemSuggestedCropBinding suggestedCropBinding;
	OnGridCropItemListener gridCropItemListener;

	public SuggestedCropsAdapter(OnGridCropItemListener onGridItemClickListener) {
		this.cropModelList = new ArrayList<>();
		this.gridCropItemListener = onGridItemClickListener;
	}

	@NonNull
	@Override
	public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		suggestedCropBinding = DataBindingUtil.inflate(
				LayoutInflater.from(parent.getContext()),
				R.layout.item_suggested_crop, parent, false);
		return new HomeViewHolder(suggestedCropBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
		CropDetailResponse.Data cropModel = cropModelList.get(position);
		holder.bind(cropModel, position, gridCropItemListener);
	}

	@Override
	public int getItemCount() {
		return cropModelList.size();
	}

	public void updateList(List<CropDetailResponse.Data> cropModels) {
		this.cropModelList.addAll(cropModels);
		notifyDataSetChanged();
	}

	class HomeViewHolder extends RecyclerView.ViewHolder {

		ItemSuggestedCropBinding cropsGatewayBinding;

		public HomeViewHolder(ItemSuggestedCropBinding cropsGatewayBinding) {
			super(cropsGatewayBinding.getRoot());
			this.cropsGatewayBinding = cropsGatewayBinding;

		}

		public void bind(final CropDetailResponse.Data cropModel, final int pos, final OnGridCropItemListener listener) {

			cropsGatewayBinding.setCrop(cropModel);
			cropsGatewayBinding.getRoot().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onClick(cropModel, pos);
				}
			});
		}

	}

	public interface OnGridCropItemListener{
		void onClick(CropDetailResponse.Data crop,int position);
	}
}
