package dev.android.fursa.helpme.com.fursa.dev.model.view;


import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.android.fursa.helpme.R;
import dev.android.fursa.helpme.com.fursa.dev.ui.holder.BaseViewHolder;

public abstract class BaseViewModel {

    public abstract LayoutTypes getType();

    public BaseViewHolder createViewHolder(ViewGroup parent) {
        return onCreateViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getType().getValue(), parent, false));
    }

    protected abstract BaseViewHolder onCreateViewHolder(View view);

    public enum LayoutTypes {
        HospitalItemLayout(R.layout.hospital);

        private final int id;

        LayoutTypes(int resId) {
            this.id = resId;
        }

        @LayoutRes
        public int getValue() {
            return id;
        }
    }
}
