package com.fuchs.navigation_activity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.NewOrderStepsActivity;

import butterknife.ButterKnife;

public class PaymentFragment extends Fragment {
    View view;

    private LinearLayout llActivityToolbar;
    private TextView tvHeading;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_payment,null);
        ButterKnife.bind(this,view);

        tvHeading = (TextView) getActivity().findViewById(R.id.tvHeading);
        llActivityToolbar = (LinearLayout) getActivity().findViewById(R.id.llActivityToolbar);
        tvHeading.setText("New Order");


        ((NewOrderStepsActivity)getActivity()).changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor));
        llActivityToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();

            }
        });
        return view;
    }
}
