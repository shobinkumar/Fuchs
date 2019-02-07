package com.fuchs.navigation_activity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.AddToCartAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddToCartFragment extends Fragment {
    View view;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private TextView textView;
    private LinearLayout llActivityToolbar;
    private TextView tvHeading;


    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_add_to_cart, null);
        ButterKnife.bind(this, view);
        initViews();
        listeners();
        return view;
    }

    private void listeners() {

    }

    private void initViews() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AddToCartAdapter(getActivity()));
        textView = (TextView) getActivity().findViewById(R.id.tvNext);
        tvHeading = (TextView) getActivity().findViewById(R.id.tvHeading);
        llActivityToolbar = (LinearLayout) getActivity().findViewById(R.id.llActivityToolbar);
        tvHeading.setText("New Order");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, new ShippingAddressFragment());
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
    }
//    @OnClick(R.id.tvNext)
//    public void onClick(View view)
//    {
//        FragmentManager fm = getActivity().getSupportFragmentManager();
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.frame_container, new ShippingAddressFragment());
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        ft.commit();
//    }
}
