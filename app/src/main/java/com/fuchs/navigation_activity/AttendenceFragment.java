package com.fuchs.navigation_activity;

import android.os.Bundle;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttendenceFragment extends Fragment {
    View view;
    @BindView(R.id.rl1)
    RelativeLayout rl1;

    @BindView(R.id.rl2)
    RelativeLayout rl2;

    @BindView(R.id.includeShow)
    RelativeLayout includeShow;


    @BindView(R.id.includeEnter)
    RelativeLayout includeEnter;

    @BindView(R.id.includeAttendence)
    RelativeLayout includeAttendence;


    @BindView(R.id.tvSubmit)
    TextView tvSubmit;
    ;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_attendence, null);
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        textview.setText("Attendence");
        ImageView ivCalendar=(ImageView)getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch=(ImageView)getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.rl1, R.id.rl2, R.id.tvSubmit})
    public void onClick(View view)
    {
        if(view.getId()==R.id.rl1)
        {
            includeShow.setVisibility(View.GONE);
            includeAttendence.setVisibility(View.GONE);
            includeEnter.setVisibility(View.VISIBLE);
        }
        else if(view.getId()==R.id.rl2)
        {
            includeShow.setVisibility(View.GONE);
            includeEnter.setVisibility(View.GONE);
            includeAttendence.setVisibility(View.VISIBLE);
        }
        else if(view.getId()==R.id.tvSubmit)
        {

            includeEnter.setVisibility(View.GONE);
            includeAttendence.setVisibility(View.GONE);
            includeShow.setVisibility(View.VISIBLE);
        }

    }
}
