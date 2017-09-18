package dev.android.fursa.helpme.com.fursa.dev.ui.holder;


import android.view.View;
import android.widget.TextView;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.model.body.ListItemModel;

public class HospitalItemBodyHolder extends BaseViewHolder<ListItemModel>{

    public TextView mTitle;
    public TextView mAddress;


    public HospitalItemBodyHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.title);
        mAddress = (TextView) itemView.findViewById(R.id.address);
    }

    @Override
    public void bindViewHolder(ListItemModel listItemModel) {
        mTitle.setText(listItemModel.getTitle());
        mAddress.setText(listItemModel.getAddress());
    }

    @Override
    public void unbindViewHolder() {
        mTitle.setText(null);
        mAddress.setText(null);
    }
}
