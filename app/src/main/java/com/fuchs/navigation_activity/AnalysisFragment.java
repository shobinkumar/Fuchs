package com.fuchs.navigation_activity;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuchs.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnalysisFragment extends Fragment {
    View view;
    private ProgressDialog  dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_analysis_report,null);
        ButterKnife.bind(this,view);
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Analytic Report");
        return view ;
    }
    @OnClick(R.id.tvRefresh)

    public void onClick(View view){
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
        }, 2000);
    }

}
