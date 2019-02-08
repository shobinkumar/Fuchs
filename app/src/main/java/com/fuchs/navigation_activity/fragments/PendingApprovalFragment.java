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
import com.fuchs.navigation_activity.adapters.PendingApprovalAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingApprovalFragment extends Fragment {
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
        view = inflater.inflate(R.layout.fragment_pending_approval, null);
        ButterKnife.bind(this, view);
        initViews();
        listeners();
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        textview.setText("Pending Approval Orders");
        return view;
    }

    private void listeners() {

    }

    private void initViews() {
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PendingApprovalAdapter(getActivity()));

    }


}
