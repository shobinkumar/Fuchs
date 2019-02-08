package com.fuchs.navigation_activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuchs.R;

public class AnalysisFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_analysis_report,null);
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Analysis Report");
        return view ;
    }
}
