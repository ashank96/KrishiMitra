package com.aloofwillow96.languageapp.activities;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.aloofwillow96.languageapp.Constants;
import com.aloofwillow96.languageapp.KrishiPreferences;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.ViewUtils;
import com.aloofwillow96.languageapp.controllers.FormController;
import com.aloofwillow96.languageapp.controllers.HomeController;
import com.aloofwillow96.languageapp.controllers.PhoneNumberController;
import com.aloofwillow96.languageapp.databinding.ActivityLandingBinding;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import androidx.databinding.DataBindingUtil;

public class LandingActivity extends BaseActivity {
	private final String TAG = LandingActivity.this.getClass().getSimpleName();
	ActivityLandingBinding activityLandingBinding;
	Router router;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Log.i("token", FirebaseInstanceId.getInstance().getToken());
		initFirebaseToken();

		activityLandingBinding = DataBindingUtil.setContentView(this, R.layout.activity_landing);
		initToolbar();
		router = Conductor.attachRouter(this, activityLandingBinding.conductor, savedInstanceState);

		if (!router.hasRootController()) {
			if (FirebaseAuth.getInstance().getCurrentUser() != null) {
				ViewUtils.makeToastShort(this, FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber());
				router.setRoot(RouterTransaction.with(new HomeController()));
			} else {
				router.setRoot(RouterTransaction.with(new PhoneNumberController()));
			}

		}

	}

	private void initFirebaseToken() {
		FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
			@Override
			public void onSuccess(InstanceIdResult instanceIdResult) {
				KrishiPreferences.getInstance().set(Constants.FCM_TOKEN,instanceIdResult.getToken());
			}
		});
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.more_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.logOut:
				FirebaseAuth.getInstance().signOut();
				finish();
				break;
		}
		return true;
	}
}
