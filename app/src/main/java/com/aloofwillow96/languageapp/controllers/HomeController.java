package com.aloofwillow96.languageapp.controllers;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aloofwillow96.languageapp.BindingAdapters;
import com.aloofwillow96.languageapp.Constants;
import com.aloofwillow96.languageapp.KrishiSahayakApplication;
import com.aloofwillow96.languageapp.OnGridItemClickListener;
import com.aloofwillow96.languageapp.R;
import com.aloofwillow96.languageapp.ViewUtils;
import com.aloofwillow96.languageapp.activities.AboutUs;
import com.aloofwillow96.languageapp.activities.BaseActivity;
import com.aloofwillow96.languageapp.activities.CropsGateway;
import com.aloofwillow96.languageapp.activities.FAQ;
import com.aloofwillow96.languageapp.activities.ImportantLinks;
import com.aloofwillow96.languageapp.activities.Insurance;
import com.aloofwillow96.languageapp.activities.PestControl;
import com.aloofwillow96.languageapp.activities.SoilHealth;
import com.aloofwillow96.languageapp.adapters.HomeAdapter;
import com.aloofwillow96.languageapp.contracts.HomeContract;
import com.aloofwillow96.languageapp.databinding.ConductorHomeBinding;
import com.aloofwillow96.languageapp.models.GridModel;
import com.aloofwillow96.languageapp.models.WeatherResponse;
import com.aloofwillow96.languageapp.presenters.HomePresenter;
import com.bluelinelabs.conductor.RouterTransaction;
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;


public class HomeController extends MvpController<HomeContract.View,HomePresenter>
		implements HomeContract.View,LocationListener {
	ConductorHomeBinding conductorHomeBinding;
	HomeAdapter homeAdapter;
	Location currentLocation;

	@NonNull
	@Override
	protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
		conductorHomeBinding = DataBindingUtil.inflate(inflater, R.layout.conductor_home, container, false);
		init();
		setRetainViewMode(RetainViewMode.RETAIN_DETACH);
		return conductorHomeBinding.getRoot();
	}

	@SuppressLint("MissingPermission")
	@Override
	protected void onAttach(@NonNull View view) {
		super.onAttach(view);
		if(permissionsGranted()) {
			currentLocation = ((BaseActivity) getActivity()).getLocationManager()
				.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			if(currentLocation!=null) {
				getPresenter().loadWeatherData(currentLocation);
			}
			//getHomePresenter().loadSoilData(currentLocation);
		}
		requestLocationService();

	}

	private void init() {
		homeAdapter = new HomeAdapter(new OnGridItemClickListener() {
			@Override
			public void onClick(GridModel gridModel, int position) {
				switch (position) {
					case 0: getRouter().pushController(RouterTransaction.with(new SuggestedCropsController()));
						break;
					case 1:
						getActivity().startActivity(new Intent(getApplicationContext(), CropsGateway.class));
						break;
					case 2:
						getActivity().startActivity(new Intent(getApplicationContext(), SoilHealth.class));
						break;
					case 3:
						getActivity().startActivity(new Intent(getApplicationContext(), PestControl.class));
						break;
					case 4:
						getActivity().startActivity(new Intent(getApplicationContext(), Insurance.class));
						break;
					case 5:
						getActivity().startActivity(new Intent(getApplicationContext(), ImportantLinks.class));
						break;
					case 6:
						getActivity().startActivity(new Intent(getApplicationContext(), FAQ.class));
						break;
					case 7:
						getActivity().startActivity(new Intent(getApplicationContext(), AboutUs.class));
						break;
				}
			}
		});
		GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
		conductorHomeBinding.recyclerView.setLayoutManager(gridLayoutManager);
		conductorHomeBinding.recyclerView.setAdapter(homeAdapter);
		conductorHomeBinding.recyclerView.setNestedScrollingEnabled(false);
		setRefreshListener();
		homeAdapter.updateList(getItemList());
	}

	private void setRefreshListener() {
		conductorHomeBinding.refreshButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(currentLocation!=null) {
					getPresenter().loadWeatherData(currentLocation);
					//getHomePresenter().loadSoilData(currentLocation);
				}
			}
		});
	}

	private void requestLocationService() {
		if (!permissionsGranted()) {
			requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
					Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
		} else {
			requestForLocationUpdates();
		}
}

	@SuppressLint("MissingPermission")
	private void requestForLocationUpdates() {
		((BaseActivity) getActivity()).getLocationManager().requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, this);
		((BaseActivity) getActivity()).getLocationManager().requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 2000, 10, this);
	}

	@SuppressLint("MissingPermission")
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		switch (requestCode) {
			case 1:
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					ViewUtils.makeToastShort(getActivity(), "Permission Granted");
					requestForLocationUpdates();
				} else {
					ViewUtils.makeToastShort(getActivity(), "Permission denied");
				}
		}
	}


	@Override
	public void onLocationChanged(Location location) {
		currentLocation=location;

			getPresenter().loadWeatherData(currentLocation);
			//getHomePresenter().loadSoilData(currentLocation);

		Log.i("Location", location.getLatitude() + " " + location.getLongitude());
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Log.i("Location", provider + " status changed");
	}

	@Override
	public void onProviderEnabled(String provider) {
		Log.i("Location", provider + " enabled");
	}

	@Override
	public void onProviderDisabled(String provider) {
		Log.i("Location", provider + " disabled");
	}

	private boolean permissionsGranted() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return getActivity().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED ||
					getActivity().checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
		}
		return true;
	}


	private List<GridModel> getItemList() {
		List<GridModel> cropModelList = new ArrayList<>();
		cropModelList.add(new GridModel(R.drawable.ic_farmer,  ViewUtils.getString(R.string.become_a_member_descp),ViewUtils.getString(R.string.join_us)));
		cropModelList.add(new GridModel(R.drawable.ic_crop, ViewUtils.getString(R.string.crop_info), ViewUtils.getString(R.string.check_the_info_about_crops)));
		cropModelList.add(new GridModel(R.drawable.ic_soil, ViewUtils.getString(R.string.soil_info), ViewUtils.getString(R.string.check_soil_health_info_here)));
		cropModelList.add(new GridModel(R.drawable.ic_insecticide, ViewUtils.getString(R.string.pest_control), ViewUtils.getString(R.string.natural_insecticides_and_pestisides)));
		cropModelList.add(new GridModel(R.drawable.ic_insurance, ViewUtils.getString(R.string.insurance), ViewUtils.getString(R.string.crop_security)));
		cropModelList.add(new GridModel(R.drawable.ic_globe, ViewUtils.getString(R.string.important_links), ViewUtils.getString(R.string.find_loads_of_resources)));
		cropModelList.add(new GridModel(R.drawable.ic_question, ViewUtils.getString(R.string.faq), ViewUtils.getString(R.string.ask_us)));
		cropModelList.add(new GridModel(R.drawable.ic_about_us, ViewUtils.getString(R.string.about_us), ViewUtils.getString(R.string.ask_any_queries)));
		return cropModelList;
	}

	@NonNull
	@Override
	public HomePresenter createPresenter() {
		return KrishiSahayakApplication.getInstance().getComponent().getHomePresenter();
	}

	@Override
	public void updateWeatherResponse(WeatherResponse weatherResponse) {
		hideLoadingView();
		showContentView();
		conductorHomeBinding.maxTempTV.setText(String.format(ViewUtils.getString(R.string.maxTemp),
				weatherResponse.getMain().getTempMax()));
		conductorHomeBinding.minTempTV.setText(String.format(ViewUtils.getString(R.string.minTemp),
				weatherResponse.getMain().getTempMin()));
		conductorHomeBinding.weatherDescription.setText(
				weatherResponse.getWeather().get(0).getDescription());
		conductorHomeBinding.placeTV.setText(String.format(ViewUtils.getString(R.string.city_state_country),
				weatherResponse.getName(),"Karnataka",weatherResponse.getSys().getCountry()));
		conductorHomeBinding.windSpeedTV.setText(String.format(ViewUtils.getString(R.string.wind_speed),
				weatherResponse.getWind().getSpeed()));
		conductorHomeBinding.pressure.setText(String.format(ViewUtils.getString(R.string.pressure),
				weatherResponse.getMain().getPressure()));
		conductorHomeBinding.humidity.setText(String.format(ViewUtils.getString(R.string.humidity),
				(float)weatherResponse.getMain().getHumidity()));
		String url = Constants.BASE_ICON_URL+weatherResponse.getWeather().get(0).getIcon()+".png";

		BindingAdapters.setImageDrawable(conductorHomeBinding.weatherImage,url);

	}

//	@Override
//	public void updateSoilResponse(SoilForeCastResponse soilResponse) {
//		Log.i("Soil Data",soilResponse.getData().get(0).getValidDate());
//		hideLoadingView();
//		showContentView();
//		conductorHomeBinding.soilDensityTV.setText(String.format(ViewUtils.getString(R.string.soil_density),
//				soilResponse.getData().get(0).getBulkSoilDensity()));
//		conductorHomeBinding.soilAvgTempTV.setText(String.format(ViewUtils.getString(R.string.soilTemp),
//				soilResponse.getData().get(0).getSoilt40100cm()));
//		conductorHomeBinding.humidity.setText(String.format(ViewUtils.getString(R.string.humidity),
//				soilResponse.getData().get(0).getSpecificHumidity()));
//	}

	@Override
	public void showLoadingView() {
		conductorHomeBinding.loadingView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideLoadingView() {
		conductorHomeBinding.loadingView.setVisibility(View.INVISIBLE);
	}

	@Override
	public void showContentView() {
		conductorHomeBinding.weatherSoilCardView.setVisibility(View.VISIBLE);
	}

	@Override
	public void hideContentView() {
		conductorHomeBinding.weatherSoilCardView.setVisibility(View.INVISIBLE);
	}

	@Override
	public boolean handleBack() {
		getActivity().finish();
		return true;
	}

}
