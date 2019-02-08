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

public class PendingApprovalAdapter extends RecyclerView.Adapter<PendingApprovalAdapter.MyHolder> {
    Context context;

    public PendingApprovalAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PendingApprovalAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_pending_approvals, parent, false);

        return new PendingApprovalAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PendingApprovalAdapter.MyHolder myHolder, int i) {
        myHolder.ivNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,OrderDetailActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivNavigate)
        ImageView ivNavigate;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }


    }
}
