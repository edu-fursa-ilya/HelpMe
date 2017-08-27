package dev.android.fursa.helpme.com.fursa.dev.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.app.ApiConst;
import dev.android.fursa.helpme.com.fursa.dev.app.MyApplication;
import dev.android.fursa.helpme.com.fursa.dev.common.rv.BaseAdapter;
import dev.android.fursa.helpme.com.fursa.dev.model.body.HospitalItemBodyViewModel;
import dev.android.fursa.helpme.com.fursa.dev.mvp.view.HospitalView;
import dev.android.fursa.helpme.com.fursa.dev.rest.PlaceRequest;
import dev.android.fursa.helpme.com.fursa.dev.rest.models.Hospital;
import dev.android.fursa.helpme.com.fursa.dev.rest.response.Response;
import retrofit2.Call;
import retrofit2.Callback;


public class HospitalListFragment extends BaseFragment implements HospitalView {
    @Inject
     PlaceRequest mPlaceRequest;

    private RecyclerView mRecyclerView;
    private BaseAdapter mBaseAdapter;

    public HospitalListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        //http request
        mPlaceRequest.getPlace(ApiConst.HOSPITAL, ApiConst.API_KEY, ApiConst.LANGUAGE).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<HospitalItemBodyViewModel> list = new ArrayList<HospitalItemBodyViewModel>();
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    list.add(new HospitalItemBodyViewModel(
                            response.body().getResults().get(i).getName(),
                            response.body().getResults().get(i).getFormattedAddress()
                    ));
                }

                mBaseAdapter.addItems(list);
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        initAdapter(mRecyclerView);
    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_hospital);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void initAdapter(RecyclerView recyclerView) {
        mBaseAdapter = new BaseAdapter();
        recyclerView.setAdapter(mBaseAdapter);
    }






}
