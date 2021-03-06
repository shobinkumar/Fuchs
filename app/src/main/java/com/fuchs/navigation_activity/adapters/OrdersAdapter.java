package com.fuchs.navigation_activity.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.OrderDetailActivity;
import com.fuchs.navigation_activity.activity.OrderSummaryActivity;
import com.fuchs.navigation_activity.model.OrderItemModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.MyHolder> {
    ArrayList<OrderItemModel> al;
    Context context;

    public OrdersAdapter(ArrayList<OrderItemModel> al, Context context) {
        this.al = al;
        this.context = context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_orders, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.ivClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,OrderDetailActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivClick)
        ImageView ivClick;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
