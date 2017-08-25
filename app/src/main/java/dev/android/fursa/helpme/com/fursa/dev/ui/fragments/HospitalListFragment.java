package dev.android.fursa.helpme.com.fursa.dev.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.app.MyApplication;
import dev.android.fursa.helpme.com.fursa.dev.rest.PlaceRequest;
import dev.android.fursa.helpme.com.fursa.dev.rest.RestClient;
import dev.android.fursa.helpme.com.fursa.dev.rest.models.Hospital;
import dev.android.fursa.helpme.com.fursa.dev.rest.response.Response;
import retrofit2.Call;
import retrofit2.Callback;


public class HospitalListFragment extends BaseFragment {

    private static final String KEYWORD = "Больница+в+Самара";
    private static final String LANGUAGE = "ru";
    private static final String API_KEY = "AIzaSyBB93jo3eEoX6A4tycgim6lRqctccWi9tw";

    @Inject
    PlaceRequest mPlaceRequest;


    public HospitalListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mPlaceRequest.getPlace(KEYWORD, API_KEY, LANGUAGE).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
               for (int i = 0; i < response.body().getResults().size(); i++) {
                   Log.d(HospitalListFragment.class.getSimpleName(), response.body().getResults().get(i).toString());
               }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_hospital_list;
    }


    @Override
    public int onCreateToolbarTitle() {
        return R.string.hospital_list_fragment_title;
    }

}
