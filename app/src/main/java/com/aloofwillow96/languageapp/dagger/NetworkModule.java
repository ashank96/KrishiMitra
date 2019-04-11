package com.aloofwillow96.languageapp.dagger;

import com.aloofwillow96.languageapp.network.APIInterface;
import com.aloofwillow96.languageapp.network.ApiUrls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
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

	@Named("server")
	@Provides
	@Singleton
	APIInterface providesServerApiInterface(@Named("serverRetrofit")Retrofit retroFit) {
		return retroFit.create(APIInterface.class);
	}
	@Named("external")
	@Provides
	@Singleton
	APIInterface providesExternalApiInterface(@Named("externalRetrofit")Retrofit retroFit) {
		return retroFit.create(APIInterface.class);
	}

	@Named("externalRetrofit")
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

	@Named("serverRetrofit")
	@Provides
	@Singleton
	Retrofit providesServerRetrofit(OkHttpClient okHttpClient, Gson gson) {
		return new Retrofit.Builder()
				.baseUrl(ApiUrls.SERVER_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
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

	@Provides
	@Singleton
	Gson providesGson(){
		return new GsonBuilder()
				.setLenient()
				.create();
	}
}
