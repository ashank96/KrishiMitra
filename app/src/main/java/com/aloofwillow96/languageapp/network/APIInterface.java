package com.aloofwillow96.languageapp.network;

import com.aloofwillow96.languageapp.models.SoilForeCastResponse;
import com.aloofwillow96.languageapp.models.WeatherResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {
	@GET(ApiUrls.DAILY_FORECAST)
	Observable<WeatherResponse> getWeatherForeCast(@Query("lat")double latitude,
												   @Query("lon")double longitude,
												   @Query("days")int days,
												   @Query("key")String key);
	@GET(ApiUrls.SOIL_FORECAST)
	Observable<SoilForeCastResponse> getSoilForeCast(@Query("lat")double latitude,
													 @Query("lon")double longitude,
													 @Query("key")String key);
}
