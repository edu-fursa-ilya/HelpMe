package dev.android.fursa.helpme.com.fursa.dev.mvp.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.MvpView;

public interface ItemListView extends MvpView {

    void showProgressBar();

    void hideProgressBar();

    void loadData();

    void initListAdapter(RecyclerView recyclerView);

    void initViewComponents(View root);

}
