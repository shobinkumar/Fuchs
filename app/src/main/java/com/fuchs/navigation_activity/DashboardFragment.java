package com.fuchs.navigation_activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuchs.MainActivity;
import com.fuchs.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardFragment extends Fragment {
    View view;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_dashboard,null);
        initViews();
        return view ;
    }

    private void initViews() {
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Dashboard");
    }
}
