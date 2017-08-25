package dev.android.fursa.helpme.com.fursa.dev.app;


import android.app.Application;

import com.vk.sdk.VKSdk;

import dev.android.fursa.helpme.com.fursa.dev.di.component.ApplicationComponent;
import dev.android.fursa.helpme.com.fursa.dev.di.component.DaggerApplicationComponent;
import dev.android.fursa.helpme.com.fursa.dev.di.module.ApplicationModule;

public class MyApplication extends Application {

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initApplicationComponent();
        VKSdk.initialize(this);
    }

    private void initApplicationComponent() {
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
