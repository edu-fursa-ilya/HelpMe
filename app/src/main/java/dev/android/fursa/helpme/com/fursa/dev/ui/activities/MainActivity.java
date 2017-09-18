package dev.android.fursa.helpme.com.fursa.dev.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.app.ApiConst;
import dev.android.fursa.helpme.com.fursa.dev.app.MyApplication;
import dev.android.fursa.helpme.com.fursa.dev.mvp.presenter.MainPresenter;
import dev.android.fursa.helpme.com.fursa.dev.mvp.view.MainView;
import dev.android.fursa.helpme.com.fursa.dev.ui.fragments.HospitalFragment;
import dev.android.fursa.helpme.com.fursa.dev.user.CurrentUser;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

        mPresenter.checkAuth();


    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConst.DEFAULT_LOGIN_SCOPE);
        Log.d(MainActivity.class.getSimpleName(), "startSignIn");
        setContent(new HospitalFragment());
        Log.d(MainActivity.class.getSimpleName(), "startSignIn 2");

    }

    @Override
    public void signedId() {
        Toast.makeText(this, "Current uid = " + CurrentUser.getId(), Toast.LENGTH_SHORT).show();
        setContent(new HospitalFragment());
        Log.d(MainActivity.class.getSimpleName(), "signedId");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                mPresenter.checkAuth();
            }

            @Override
            public void onError(VKError error) {
                Toast.makeText(MainActivity.this, "Oops! Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
