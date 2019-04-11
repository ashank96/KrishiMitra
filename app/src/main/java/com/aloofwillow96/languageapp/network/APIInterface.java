package com.aloofwillow96.languageapp.network;

import com.aloofwillow96.languageapp.models.CropDetailResponse;
import com.aloofwillow96.languageapp.models.SubmitFormRequest;
import com.aloofwillow96.languageapp.models.UpdateTokenRequest;
import com.aloofwillow96.languageapp.models.WeatherResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
	@GET(ApiUrls.DAILY_FORECAST)
	Observable<WeatherResponse> getWeatherForeCast(@Query("lat")double latitude,
												   @Query("lon")double longitude,
												   @Query("units")String units, @Query("appid")String key);

	@POST(ApiUrls.GET_QUESTIONS)
	Single<CropDetailResponse> getQuestionsData();

	@POST(ApiUrls.SUBMIT_FORM)
	Single<String> submitForm(@Body SubmitFormRequest request);

	@POST(ApiUrls.UPDATE_TOKEN)
	Single<Integer> updateFcmToken(@Body UpdateTokenRequest request);

	@POST(ApiUrls.GET_SUGGESTED_CROPS)
	Single<CropDetailResponse> getSuggestedCrops();
//	@GET(ApiUrls.SOIL_FORECAST)
//	Observable<SoilForeCastResponse> getSoilForeCast(@Query("lat")double latitude,
//													 @Query("lon")double longitude,
//													 @Query("key")String key);
}
