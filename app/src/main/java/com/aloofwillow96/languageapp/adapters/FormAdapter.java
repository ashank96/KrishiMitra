package com.aloofwillow96.languageapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;

import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.databinding.ItemFormRowBinding;
import com.aloofwillow96.languageapp.models.CropDetailResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class FormAdapter extends RecyclerView.Adapter<FormAdapter.FormViewHolder> {

	ItemFormRowBinding itemFormRowBinding;
	List<CropDetailResponse.Data> dataList;

	private FormListener listener;


	public FormAdapter() {
		dataList = new ArrayList<>();
	}

	@NonNull
	@Override
	public FormViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		itemFormRowBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_form_row, parent, false);
		return new FormViewHolder(itemFormRowBinding);
	}

	@Override
	public void onBindViewHolder(@NonNull FormViewHolder holder, int position) {
		holder.bind(dataList.get(position), listener);
	}

	@Override
	public int getItemCount() {
		return dataList.size();
	}

	public void updateList(List<CropDetailResponse.Data> data) {
		dataList.clear();
		dataList.addAll(data);
		notifyDataSetChanged();
	}


	public class FormViewHolder extends RecyclerView.ViewHolder {

		private ItemFormRowBinding itemFormRowBinding;

		public FormViewHolder(ItemFormRowBinding itemFormRowBinding) {
			super(itemFormRowBinding.getRoot());
			this.itemFormRowBinding = itemFormRowBinding;
		}

		public void bind(final CropDetailResponse.Data data, final FormListener listener) {
			itemFormRowBinding.setData(data);
			final String[] items = {"0.5 acre", "1 acre", "2 acres", "5 acres"};
			ArrayAdapter arrayAdapter = new ArrayAdapter(itemFormRowBinding.getRoot().getContext(), R.layout.support_simple_spinner_dropdown_item,items);
			itemFormRowBinding.spinner.setAdapter(arrayAdapter);
			itemFormRowBinding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
					data.setLand(Float.parseFloat(items[position].split(" ")[0]));
					data.setSelection(position);
					listener.onItemChecked(data);
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {

				}
			});
			itemFormRowBinding.checkbox.setOnCheckedChangeListener(null);
			itemFormRowBinding.checkbox.setChecked(data.isChecked());
			if(data.isChecked()){
				itemFormRowBinding.spinner.setVisibility(View.VISIBLE);
				itemFormRowBinding.spinner.setSelection(data.getSelection());
			}else{
				itemFormRowBinding.spinner.setVisibility(View.GONE);
			}
			itemFormRowBinding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					data.setChecked(isChecked);
					if (isChecked) {
						itemFormRowBinding.spinner.setSelection(0);
						itemFormRowBinding.spinner.setVisibility(View.VISIBLE);
					} else {
						listener.onItemUnchecked(data);
						itemFormRowBinding.spinner.setVisibility(View.GONE);
					}
				}
			});
		}
	}

	public void setFormListener(FormListener listener) {
		this.listener = listener;
	}

	public interface FormListener {
		void onItemChecked(CropDetailResponse.Data data);

		void onItemUnchecked(CropDetailResponse.Data data);
	}
}
