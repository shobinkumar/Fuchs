package com.fuchs.navigation_activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;

public class ClaimsFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_claims,null);
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Claims");
        ImageView ivCalendar=(ImageView)getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch=(ImageView)getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE);
        return view ;
    }
}
