package com.aloofwillow96.languageapp;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

	@BindingAdapter("android:src")
	public static void setImageDrawable(ImageView imageView, int resId){
		imageView.setImageDrawable(ViewUtils.getImageDrawable(resId));
	}
}
