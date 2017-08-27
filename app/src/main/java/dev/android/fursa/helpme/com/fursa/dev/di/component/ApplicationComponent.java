package dev.android.fursa.helpme.com.fursa.dev.di.component;

import javax.inject.Singleton;

import dagger.Component;
import dev.android.fursa.helpme.com.fursa.dev.di.module.ApplicationModule;
import dev.android.fursa.helpme.com.fursa.dev.di.module.ManagerModule;
import dev.android.fursa.helpme.com.fursa.dev.di.module.RestModule;
import dev.android.fursa.helpme.com.fursa.dev.rest.models.Hospital;
import dev.android.fursa.helpme.com.fursa.dev.ui.activities.BaseActivity;
import dev.android.fursa.helpme.com.fursa.dev.ui.activities.MainActivity;
import dev.android.fursa.helpme.com.fursa.dev.ui.fragments.BaseFragment;
import dev.android.fursa.helpme.com.fursa.dev.ui.fragments.HospitalListFragment;

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class, RestModule.class})
public interface ApplicationComponent {

    //activities
    void inject(BaseActivity activity);
    void inject(MainActivity activity);

    //fragments
    void inject(HospitalListFragment fragment);


}
