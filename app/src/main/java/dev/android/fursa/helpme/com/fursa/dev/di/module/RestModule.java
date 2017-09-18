package dev.android.fursa.helpme.com.fursa.dev.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.android.fursa.helpme.com.fursa.dev.rest.Api;
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
    public Api provideGoogleApi() {
        return mRestClient.createService(Api.class);
    }
}
