package dev.android.fursa.helpme.com.fursa.dev.ui.activities;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.app.MyApplication;
import dev.android.fursa.helpme.com.fursa.dev.common.manager.MyFragmentManager;
import dev.android.fursa.helpme.com.fursa.dev.ui.fragments.BaseFragment;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setContentView(R.layout.activity_base);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(), parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment baseFragment) {
        setToolbarTitle(baseFragment.createToolbarTitle(this));
    }

    public void setToolbarTitle(String title) {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setContent(BaseFragment fragment) {
        myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
    }

    public void addContent(BaseFragment fragment) {
        myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
    }

    public boolean removeCurrentFragment() {
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment) {
        return myFragmentManager.removeFragment(this, fragment);
    }

    @Override
    public void onBackPressed() {
        removeCurrentFragment();
    }
}
