package com.fuchs.navigation_activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.OrderSummaryActivity;

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

    @BindView(R.id.tvRefresh)
    TextView tvRefresh;

    ProgressDialog progressDialog;
    private ProgressDialog  dialog;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, null);
        ButterKnife.bind(this, view);
        progressDialog=new ProgressDialog(getActivity());
        initViews();
        return view;
    }

    private void initViews() {
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        ImageView ivCalendar = (ImageView) getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch = (ImageView) getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE);
        textview.setText("Dashboard");


    }

    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.tvRefresh})
    public void onClick(View view) {
        if (view.getId() == R.id.rl1) {
            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",1));

        } else if (view.getId() == R.id.rl2) {
            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",2));

        } else if (view.getId() == R.id.rl3) {
            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",3));

        } else if (view.getId() == R.id.tvRefresh) {
            dialog = new ProgressDialog(getActivity());
            dialog.getWindow().setBackgroundDrawable(new
                    ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
            dialog.setContentView(R.layout.my_progress);

            new Handler().postDelayed(new Runnable() {
               @Override
               public void run() {
                   dialog.dismiss();
               }
           },2000);

        }

    }
}
