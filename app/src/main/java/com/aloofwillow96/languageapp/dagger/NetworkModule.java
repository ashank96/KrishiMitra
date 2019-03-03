package com.aloofwillow96.languageapp.dagger;

import com.aloofwillow96.languageapp.network.APIInterface;
import com.aloofwillow96.languageapp.network.ApiUrls;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

	@Provides
	@Singleton
	APIInterface providesApiInterface(Retrofit retroFit) {
		return retroFit.create(APIInterface.class);
	}

	@Provides
	@Singleton
	Retrofit providesRetrofit(OkHttpClient okHttpClient) {
		return new Retrofit.Builder()
				.baseUrl(ApiUrls.BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(okHttpClient)
				.build();
	}

	@Provides
	@Singleton
	OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
		return new OkHttpClient.Builder()
				.addInterceptor(httpLoggingInterceptor)
				.build();
	}

	@Provides
	@Singleton
	HttpLoggingInterceptor providesHttpLoggingInterceptor() {
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
		return httpLoggingInterceptor;
	}
}
