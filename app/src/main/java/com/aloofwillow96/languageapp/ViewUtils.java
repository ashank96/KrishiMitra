package com.aloofwillow96.languageapp;

import android.graphics.drawable.Drawable;

public class ViewUtils {
	public static Drawable getImageDrawable(int resId){
		return KrishiSahayakApplication.getInstance().getResources().getDrawable(resId);
	}

	public static String getString(int resId){
		return KrishiSahayakApplication.getInstance().getResources().getString(resId);
	}

	public static int getColor(int resId){
		return KrishiSahayakApplication.getInstance().getResources().getColor(resId);
	}
}
