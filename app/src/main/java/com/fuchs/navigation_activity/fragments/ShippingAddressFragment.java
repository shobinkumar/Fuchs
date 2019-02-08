package com.fuchs.navigation_activity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.NewOrderStepsActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShippingAddressFragment extends Fragment {
    View view;
    TextView textView;

    private LinearLayout llActivityToolbar;
    private TextView tvHeading;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_shipping_address,null);
        ((NewOrderStepsActivity)getActivity()).changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        tvHeading = (TextView) getActivity().findViewById(R.id.tvHeading);
        llActivityToolbar = (LinearLayout) getActivity().findViewById(R.id.llActivityToolbar);
        tvHeading.setText("New Order");



        textView=(TextView)getActivity().findViewById(R.id.tvNext);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, new AddToCartFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });

        llActivityToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();

            }
        });
        return view;
    }

}
