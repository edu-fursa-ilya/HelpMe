package dev.android.fursa.helpme.com.fursa.dev.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.app.ApiConst;
import dev.android.fursa.helpme.com.fursa.dev.app.MyApplication;
import dev.android.fursa.helpme.com.fursa.dev.common.rv.BaseAdapter;
import dev.android.fursa.helpme.com.fursa.dev.model.body.ListItemModel;
import dev.android.fursa.helpme.com.fursa.dev.mvp.view.ItemListView;
import dev.android.fursa.helpme.com.fursa.dev.rest.Api;
import dev.android.fursa.helpme.com.fursa.dev.rest.response.Response;
import retrofit2.Call;
import retrofit2.Callback;


public class PoliceFragment extends BaseFragment implements ItemListView {

    @Inject
    Api mApi;

    private RecyclerView mRecyclerView;
    private BaseAdapter mBaseAdapter;
    private ViewGroup progress;

    public PoliceFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        loadData();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_police;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.police_title;
    }

    @Override
    public void showProgressBar() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewComponents(view);
        initListAdapter(mRecyclerView);
        loadData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadData();
    }

    @Override
    public void onResume() {
        super.onResume();
        showProgressBar();
        loadData();
    }

    @Override
    public void loadData() {
        mApi.getPlace(ApiConst.POLICE, ApiConst.API_KEY, ApiConst.LANGUAGE).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                List<ListItemModel> list = new ArrayList<ListItemModel>();
                for (int i = 0; i < response.body().getResults().size(); i++) {
                    list.add(new ListItemModel(
                            response.body().getResults().get(i).getName(),
                            response.body().getResults().get(i).getFormattedAddress()
                    ));
                }
                mBaseAdapter.addItems(list);
                hideProgressBar();
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void initListAdapter(RecyclerView recyclerView) {
        mBaseAdapter = new BaseAdapter();
        recyclerView.setAdapter(mBaseAdapter);
    }

    @Override
    public void initViewComponents(View root) {
        progress = (ViewGroup) root.findViewById(R.id.progress);
        mRecyclerView = (RecyclerView) root.findViewById(R.id.rv_police);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
