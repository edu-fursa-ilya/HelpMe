package dev.android.fursa.helpme.com.fursa.dev.ui.holder;


import android.view.View;
import android.widget.TextView;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.model.body.HospitalItemBodyViewModel;

public class HospitalItemBodyHolder extends BaseViewHolder<HospitalItemBodyViewModel>{

    public TextView mTitle;
    public TextView mAddress;


    public HospitalItemBodyHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.title);
        mAddress = (TextView) itemView.findViewById(R.id.address);
    }

    @Override
    public void bindViewHolder(HospitalItemBodyViewModel hospitalItemBodyViewModel) {
        mTitle.setText(hospitalItemBodyViewModel.getTitle());
        mAddress.setText(hospitalItemBodyViewModel.getAddress());
    }

    @Override
    public void unbindViewHolder() {
        mTitle.setText(null);
        mAddress.setText(null);
    }
}
