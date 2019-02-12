package com.fuchs.navigation_activity.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.OrderDetailActivity;
import com.fuchs.navigation_activity.model.PendingApprovalModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PendingApprovalAdapter extends RecyclerView.Adapter<PendingApprovalAdapter.MyHolder> {
    Context context;
    ArrayList<PendingApprovalModel> al;
    int value;
    public PendingApprovalAdapter(Context context, ArrayList<PendingApprovalModel> al, int i) {
        this.context = context;
        this.al = al;
        value=i;
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
        PendingApprovalModel model=al.get(i);
        myHolder.tvOrderNo.setText(model.getOrder_num());
        myHolder.tvOrderDate.setText(model.getOrder_date());
        myHolder.tvRequestDate.setText(model.getRequest_date());
        myHolder.tvSoldParty.setText(model.getSold_to_party());
        myHolder.tvShipParty.setText(model.getShip_to_party());
        myHolder.tvValue.setText(model.getValue());


        myHolder.ivNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                context.startActivity(new Intent(context, OrderDetailActivity.class).putExtra("value",value));
            }
        });

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivNavigate)
        ImageView ivNavigate;

        @BindView(R.id.tvOrderNo)
        TextView tvOrderNo;

        @BindView(R.id.tvOrderDate)
        TextView tvOrderDate;
        @BindView(R.id.tvRequestDate)
        TextView tvRequestDate;
        @BindView(R.id.tvSoldParty)
        TextView tvSoldParty;
        @BindView(R.id.tvShipParty)
        TextView tvShipParty;
        @BindView(R.id.tvValue)
        TextView tvValue;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

        }


    }
}
