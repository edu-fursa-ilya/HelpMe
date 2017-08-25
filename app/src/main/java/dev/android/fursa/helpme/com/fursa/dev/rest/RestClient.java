package dev.android.fursa.helpme.com.fursa.dev.rest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    private static final String BASE_URL = "https://maps.googleapis.com";

    private Retrofit mRetrofit;

    public RestClient() {
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}
