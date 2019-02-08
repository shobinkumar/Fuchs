package com.fuchs.navigation_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.OrderSummaryActivity;
import com.fuchs.navigation_activity.fragments.ApprovedFragment;
import com.fuchs.navigation_activity.fragments.PendingApprovalFragment;
import com.fuchs.navigation_activity.fragments.ShippedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashboardFragment extends Fragment {
    View view;

    @BindView(R.id.rl1)
    RelativeLayout rl1;

    @BindView(R.id.rl2)
    RelativeLayout rl2;

    @BindView(R.id.rl3)
    RelativeLayout rl3;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, null);
        ButterKnife.bind(this,view);
        initViews();
        return view;
    }

    private void initViews() {
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        textview.setText("Dashboard");
    }
    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3})
    public void onClick(View view) {
        if (view.getId() == R.id.rl1) {

        }
        else if (view.getId() == R.id.rl2) {

        }
        else if (view.getId() == R.id.rl3) {

        }
        startActivity(new Intent(getActivity(),OrderSummaryActivity.class));



    }
}
