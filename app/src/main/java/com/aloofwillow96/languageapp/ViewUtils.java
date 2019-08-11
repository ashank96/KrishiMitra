package com.aloofwillow96.languageapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

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

	public static void makeToastShort(Context context,String message){
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
	public static void makeToastLong(Context context,String message){
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}
}
