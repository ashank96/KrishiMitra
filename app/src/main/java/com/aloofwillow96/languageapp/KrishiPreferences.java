package com.aloofwillow96.languageapp;

import android.content.SharedPreferences;

import java.util.Set;

/**
 * Created by Pawan on 11/01/19.
 */
public class KrishiPreferences {

	private static KrishiPreferences instance;

	private SharedPreferences mSharedPreferences;

	private KrishiPreferences() {
		mSharedPreferences = KrishiSahayakApplication.getInstance().getSharedPreferences();
	}

	public static KrishiPreferences getInstance() {
		if (instance == null) {
			instance = new KrishiPreferences();
		}
		return instance;
	}

	public boolean getBoolean(String key, boolean defValue) {
		return mSharedPreferences.getBoolean(key, defValue);
	}

	public void set(String key, boolean value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	public String getString(String key, String defValue) {
		return mSharedPreferences.getString(key, defValue);
	}

	public float getFloat(String key, float defValue) {
		return mSharedPreferences.getFloat(key, defValue);
	}

	public Set<String> getStringSet(String key, Set<String> defValue) {
		return mSharedPreferences.getStringSet(key, defValue);
	}

	public void set(String key, String value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putString(key, value);
		edit.commit();
	}

	public int getInt(String key, int defValue) {
		return mSharedPreferences.getInt(key, defValue);
	}

	public void set(String key, int value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putInt(key, value);
		edit.commit();
	}

	public long getLong(String key, long defValue) {
		return mSharedPreferences.getLong(key, defValue);
	}

	public void set(String key, long value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putLong(key, value);
		edit.commit();
	}

	public void set(String key, double value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putLong(key, Double.doubleToRawLongBits(value));
		edit.commit();
	}

	public double getDouble(String key, double defValue){
		return Double.longBitsToDouble(mSharedPreferences.getLong(key, Double.doubleToLongBits(defValue)));
	}

	public void set(String key, float value) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putFloat(key, value);
		edit.commit();
	}

	public void set(String key, Set<String> stringSet) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.putStringSet(key, stringSet);
		edit.commit();
	}

	public boolean contain(String key) {
		return mSharedPreferences.contains(key);
	}

	public void remove(String key) {
		SharedPreferences.Editor edit = mSharedPreferences.edit();
		edit.remove(key);
		edit.commit();
	}
}
