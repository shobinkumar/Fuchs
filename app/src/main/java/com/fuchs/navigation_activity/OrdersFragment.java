package com.fuchs.navigation_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.NewOrderStepsActivity;
import com.fuchs.navigation_activity.adapters.OrdersAdapter;
import com.fuchs.navigation_activity.model.OrderItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrdersFragment extends Fragment {
    View view;


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    RecyclerView.LayoutManager layoutManager;
    ArrayList<OrderItemModel> al = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, null);
        ButterKnife.bind(this,view);
        initOtherViews();
        initViews();
        return view;
    }

    private void initOtherViews() {

    }

    private void initViews() {
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Orders");
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        addItems();
        recyclerView.setAdapter(new OrdersAdapter(al,getActivity()));


    }

    private void addItems() {
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));
        al.add(new OrderItemModel("01-FEb-19", "CG Automation and Fix System", "1"));

    }
    @OnClick(R.id.fab)
    public void onClick(View view)
    {
startActivity(new Intent(getActivity(),NewOrderStepsActivity.class));
    }
}
