package dev.android.fursa.helpme.com.fursa.dev.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.android.fursa.helpme.com.fursa.dev.common.manager.MyFragmentManager;

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager() {
        return new MyFragmentManager();
    }
}
