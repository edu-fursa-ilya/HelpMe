package dev.android.fursa.helpme.com.fursa.dev.di.module;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    LayoutInflater provideLayoutInflater() {
        return (LayoutInflater) mApplication.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
}
