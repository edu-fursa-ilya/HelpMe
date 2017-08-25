package dev.android.fursa.helpme.com.fursa.dev.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import dev.android.fursa.helpme.com.fursa.dev.mvp.view.MainView;
import dev.android.fursa.helpme.com.fursa.dev.user.CurrentUser;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void checkAuth() {
        if(!CurrentUser.isAuthorized()) {
            getViewState().startSignIn();
        } else {
            getViewState().signedId();
        }
    }
}
