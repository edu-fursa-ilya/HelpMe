package dev.android.fursa.helpme.com.fursa.dev.model.body;


import android.view.View;

import dev.android.fursa.helpme.com.fursa.dev.model.view.BaseViewModel;
import dev.android.fursa.helpme.com.fursa.dev.ui.holder.BaseViewHolder;
import dev.android.fursa.helpme.com.fursa.dev.ui.holder.HospitalItemBodyHolder;

public class ListItemModel extends BaseViewModel {

    private String mTitle;
    private String mAddress;

    public ListItemModel(String mTitle, String mAddress) {
        this.mTitle = mTitle;
        this.mAddress = mAddress;
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.HospitalItemLayout;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new HospitalItemBodyHolder(view);
    }


    public String getTitle() {
        return mTitle;
    }

    public String getAddress() {
        return mAddress;
    }
}
