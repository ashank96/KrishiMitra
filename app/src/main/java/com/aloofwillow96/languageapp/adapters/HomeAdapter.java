package com.aloofwillow96.languageapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.BindingAdapters;
import com.aloofwillow96.languageapp.OnGridItemClickListener;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.databinding.ItemCropsGatewayBinding;
import com.aloofwillow96.languageapp.models.GridModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
	List<GridModel> cropModelList;
	ItemCropsGatewayBinding cropsGatewayBinding;
	OnGridItemClickListener onGridItemClickListener;

	public HomeAdapter(OnGridItemClickListener onGridItemClickListener) {
		this.cropModelList = new ArrayList<>();
		this.onGridItemClickListener = onGridItemClickListener;
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
		GridModel cropModel = cropModelList.get(position);
		holder.bind(cropModel, position, onGridItemClickListener);
	}

	@Override
	public int getItemCount() {
		return cropModelList.size();
	}

	public void updateList(List<GridModel> cropModels) {
		this.cropModelList.addAll(cropModels);
		notifyDataSetChanged();
	}

	class HomeViewHolder extends RecyclerView.ViewHolder {

		ItemCropsGatewayBinding cropsGatewayBinding;

		public HomeViewHolder(ItemCropsGatewayBinding cropsGatewayBinding) {
			super(cropsGatewayBinding.getRoot());
			this.cropsGatewayBinding = cropsGatewayBinding;

		}

		public void bind(final GridModel cropModel, final int pos, final OnGridItemClickListener listener) {

			cropsGatewayBinding.setCropModel(cropModel);
			BindingAdapters.setImageDrawable(cropsGatewayBinding.itemCropsGatewayImageView, cropModel.getDrawableId());
			cropsGatewayBinding.getRoot().setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					listener.onClick(cropModel, pos);
				}
			});
		}

	}
}
