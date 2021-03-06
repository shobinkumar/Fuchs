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

public class ShippedFragment extends Fragment {
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
        textview.setText("Shipped Orders");
        return view;
    }

    private void listeners() {

    }

    private void initViews() {
        addToArray();
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new PendingApprovalAdapter(getActivity(), al, 0));

    }

    private void addToArray() {

        al.add(new

                PendingApprovalModel("PO14578", "11 Mar, 2019", "24 Feb, 2019", "Party Name(78459)", "Party Name(45896)", "$120"));
        al.add(new

                PendingApprovalModel("PO78452", "2 Mar, 2019", "26 Feb, 2019", "Party Name(14253)", "Party Name(45721)", "$115"));
        al.add(new

                PendingApprovalModel("PO78569", "14 Mar, 2019", "19 Feb, 2019", "Party Name(45876)", "Party Name(45698)", "$210"));
        al.add(new

                PendingApprovalModel("PO12456", "18 Feb, 2019", "12 Feb, 2019", "Party Name(65472)", "Party Name(12564)", "$170"));
        al.add(new

                PendingApprovalModel("PO56982", "31 Jan, 2019", "28 Jan, 2019", "Party Name(14253)", "Party Name(36258)", "$123"));


    }


}
