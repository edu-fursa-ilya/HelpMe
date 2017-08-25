package dev.android.fursa.helpme.com.fursa.dev.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.android.fursa.helpme.com.fursa.dev.rest.PlaceRequest;
import dev.android.fursa.helpme.com.fursa.dev.rest.RestClient;

@Module
public class RestModule {
    private RestClient mRestClient;


    public RestModule() {
        mRestClient = new RestClient();
    }


    @Provides
    @Singleton
    public RestClient provideRestClient() {
        return mRestClient;
    }

    @Provides
    @Singleton
    public PlaceRequest provideGoogleApi() {
        return mRestClient.createService(PlaceRequest.class);
    }
}
