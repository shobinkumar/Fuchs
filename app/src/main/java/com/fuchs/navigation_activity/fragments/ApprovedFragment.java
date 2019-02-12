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

public class ApprovedFragment extends Fragment {
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
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        textview.setText("Approved Orders");
        initViews();
        listeners();
        return view;
    }

    private void listeners() {

    }

    private void initViews() {
        addArray();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PendingApprovalAdapter(getActivity(), al, 0));

    }

    private void addArray() {

        al.add(new PendingApprovalModel("PO12345", "18 Feb, 2019", "12 Feb, 2019", "Party Name(75321)", "Party Name(45789)", "$120"));
        al.add(new PendingApprovalModel("PO12398", "31 Jan, 2019", "9 Jan, 2019", "Party Name(45789)", "Party Name(98563)", "$125"));
        al.add(new PendingApprovalModel("PO12385", "14 Mar, 2019", "26 Feb, 2019", "Party Name(12458)", "Party Name(14258)", "$110"));
        al.add(new PendingApprovalModel("PO112456", "1 Apr, 2019", "17 Mar, 2019", "Party Name(41256)", "Party Name(65478)", "$110"));
        al.add(new PendingApprovalModel("PO763981", "2 Mar, 2019", "26 Feb, 2019", "Party Name(74859)", "Party Name(12547)", "$123"));


    }


}
