package com.aloofwillow96.languageapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;

public class BindingAdapters {

	@BindingAdapter("android:src")
	public static void setImageDrawable(final ImageView imageView, String url) {
		Context context = imageView.getContext();
		if (context != null) {
			Glide.with(context).load(url).listener(new RequestListener<Drawable>() {
				@Override
				public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
					imageView.setImageDrawable(ViewUtils.getImageDrawable(R.drawable.ic_info_outline_black_24dp));
					return true;
				}

				@Override
				public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
					return false;
				}
			}).into(imageView);
		}
	}

	@BindingAdapter("android:src")
	public static void setImageDrawable(final ImageView imageView, int resId){
		imageView.setImageDrawable(ViewUtils.getImageDrawable(resId));
	}
}
