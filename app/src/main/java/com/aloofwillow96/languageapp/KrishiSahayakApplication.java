package com.aloofwillow96.languageapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.aloofwillow96.languageapp.dagger.Graph;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

public class KrishiSahayakApplication extends MultiDexApplication {
	private static final String TAG = KrishiSahayakApplication.class.getSimpleName();
	private static KrishiSahayakApplication instance;
	private static Context context;
	private Graph component;
	private SharedPreferences mSharedPreferences;

	@Override
	public void onCreate() {
		super.onCreate();
		context=this;
		init();
	}

	private void init() {
		instance = this;
		initializeSharedPreferences(TAG);
		MultiDex.install(getInstanceContext());
		component=Graph.Initializer.initialize((Application) getInstanceContext());

	}

	public static KrishiSahayakApplication getInstance(){
		return instance;
	}

	public static Context getInstanceContext(){
		return context;
	}

	public Graph getComponent(){
		return component;
	}

	public SharedPreferences getSharedPreferences() {
		return mSharedPreferences;
	}


	public void initializeSharedPreferences(String tag) {
		mSharedPreferences = context.getSharedPreferences(tag, 0);
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		MultiDex.install(this);
	}
}
