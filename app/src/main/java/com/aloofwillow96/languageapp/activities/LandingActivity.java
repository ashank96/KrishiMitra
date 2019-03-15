package com.aloofwillow96.languageapp.activities;

import android.os.Bundle;
import android.util.Log;

import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.controllers.HomeController;
import com.aloofwillow96.languageapp.databinding.ActivityLandingBinding;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.firebase.iid.FirebaseInstanceId;

import androidx.databinding.DataBindingUtil;

public class LandingActivity extends BaseActivity {
	ActivityLandingBinding activityLandingBinding;
	Router router;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("token", FirebaseInstanceId.getInstance().getToken());
		activityLandingBinding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
		initToolbar();
		router = Conductor.attachRouter(this, activityLandingBinding.conductor, savedInstanceState);
		if (!router.hasRootController()) {
			router.setRoot(RouterTransaction.with(new HomeController()));
		}

	}

	private void initToolbar() {
		setSupportActionBar(activityLandingBinding.toolbarHolder.toolbar);
		getSupportActionBar().setDisplayShowTitleEnabled(false);
	}

	@Override
	protected void setScreenTitle(String title) {
		activityLandingBinding.toolbarHolder.toolbar.setTitle(null);
	}

	@Override
	protected void hideToolbar() {
		getSupportActionBar().hide();
	}

	@Override
	public void onBackPressed() {
		if (!router.handleBack()) {
			super.onBackPressed();
		}
	}


}
