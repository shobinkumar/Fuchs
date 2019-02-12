package com.fuchs.navigation_activity.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.PendingApprovalAdapter;
import com.fuchs.navigation_activity.model.PendingApprovalModel;

import java.util.ArrayList;

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
    ArrayList<PendingApprovalModel> al = new ArrayList<>();


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
        addArray();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PendingApprovalAdapter(getActivity(),al,1));

    }

    private void addArray() {

        al.add(new PendingApprovalModel("PO12399", "31 Jan, 2019", "6 Feb, 2019", "Party Name(65112)", "Party Name(65218)", "$120"));
        al.add(new PendingApprovalModel("PO12355", "21 Jan, 2019", "10 Jan, 2019", "Party Name(65218)", "Party Name(65444)", "$1620"));
        al.add(new PendingApprovalModel("PO12385", "11 Feb, 2019", "8 Feb, 2019", "Party Name(65268)", "Party Name(65678)", "$1000"));
        al.add(new PendingApprovalModel("PO11245", "1 Feb, 2019", "11 Jan, 2019", "Party Name(65233)", "Party Name(65555)", "$1980"));
        al.add(new PendingApprovalModel("PO76376", "2 Feb, 2019", "29 Jan, 2019", "Party Name(65345)", "Party Name(61234)", "$1920"));

    }


}
