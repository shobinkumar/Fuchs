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
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.NewOrderActivity;
import com.fuchs.navigation_activity.activity.NewOrderStepsActivity;
import com.fuchs.navigation_activity.adapters.OrdersAdapter;
import com.fuchs.navigation_activity.fragments.ApprovedFragment;
import com.fuchs.navigation_activity.fragments.PendingApprovalFragment;
import com.fuchs.navigation_activity.fragments.ShippedFragment;
import com.fuchs.navigation_activity.model.OrderItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrdersFragment extends Fragment {
    View view;



    @BindView(R.id.view1)
    View view1;

    @BindView(R.id.view2)
    View view2;

    @BindView(R.id.view3)
    View view3;

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
        changeColor(getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

    }

    private void initViews() {
        TextView textview = (TextView)getActivity().findViewById(R.id.tvHeading);
        textview.setText("Orders");
        ImageView ivCalendar=(ImageView)getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch=(ImageView)getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.VISIBLE);
        ivSearch.setVisibility(View.VISIBLE);


        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        addItems();
        recyclerView.setAdapter(new OrdersAdapter(al,getActivity()));


    }

    private void addItems() {
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));
        al.add(new OrderItemModel("01-FEb-19", "Power 4T 10W 30", "1"));

    }





    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3,R.id.fab})
    public void onClick(View view) {
        if (view.getId() == R.id.ll1) {
            changeColor(getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        }
        else if (view.getId() == R.id.ll2) {
            changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        }
        else if (view.getId() == R.id.ll3) {
            changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor));

        }
        else if(view.getId()==R.id.fab)
        {
            startActivity(new Intent(getActivity(),NewOrderActivity.class));
        }



    }

    public void changeColor(int color1, int color2, int color3) {

        view1.setBackgroundColor(color1);
        view2.setBackgroundColor(color2);
        view3.setBackgroundColor(color3);

    }

}
