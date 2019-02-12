package com.fuchs.navigation_activity.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.DashboardFragment;
import com.fuchs.navigation_activity.activity.OrderSummaryActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardAdapter extends RecyclerView.Adapter {
    private static final int FOR_STRING = 1;
    private static final int FOR_INT = 2;
    Context ctx;
    DashboardFragment fragment;
    ArrayList<Object> al;

    public DashboardAdapter(Context context, DashboardFragment dashboardFragment, ArrayList<Object> al) {
        ctx = context;
        fragment = dashboardFragment;
        this.al = al;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewType, int i) {
        View view;
        switch (i) {
            case FOR_STRING:
                view = LayoutInflater.from(viewType.getContext()).inflate(R.layout.row_dashboard_rectangle, viewType, false);
                return new StringHolder(view);
            case FOR_INT:
                view = LayoutInflater.from(viewType.getContext()).inflate(R.layout.row_dashboard2, viewType, false);
                return new IntHolder(view);

        }


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder.getItemViewType()==FOR_INT)
        {
            IntHolder holder=(IntHolder)viewHolder;
                holder.rl1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",1));
                    }
                });
            holder.rl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",2));

                }
            });
            holder.rl3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",3));
                }
            });

        }
        else
        {
            StringHolder holder=(StringHolder)viewHolder;
            holder.rl1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",1));

                }
            });
            holder.rl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",2));

                }
            });
            holder.rl3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ctx.startActivity(new Intent(ctx, OrderSummaryActivity.class).putExtra("pos",3));

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (al.get(position) instanceof String) {
            return FOR_STRING;
        } else {
            return FOR_INT;

        }
    }

    public class IntHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.rl1)
        RelativeLayout rl1;

        @BindView(R.id.rl21)
        RelativeLayout rl2;

        @BindView(R.id.rl3)
        RelativeLayout rl3;

        @BindView(R.id.tvCount)
        TextView tvCount;
        @BindView(R.id.tvTotalAmount)
        TextView tvTotalAmount;
        @BindView(R.id.tvText)
        TextView tvText;

        @BindView(R.id.tvCountPriorty)
        TextView tvCountPriorty;
        @BindView(R.id.tvTotalAmountPriorty)
        TextView tvTotalAmountPriorty;
        @BindView(R.id.tvTextPriorty)
        TextView tvTextPriorty;

        @BindView(R.id.tvCountAside)
        TextView tvCountAside;
        @BindView(R.id.tvTotalAmountAside)
        TextView tvTotalAmountAside;
        @BindView(R.id.tvTextAside)
        TextView tvTextAside;

        public IntHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

     class StringHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rl1)
        RelativeLayout rl1;

        @BindView(R.id.rl21)
        RelativeLayout rl2;

        @BindView(R.id.rl3)
        RelativeLayout rl3;

        @BindView(R.id.tvCount)
        TextView tvCount;
        @BindView(R.id.tvTotalAmount)
        TextView tvTotalAmount;
        @BindView(R.id.tvText)
        TextView tvText;

        @BindView(R.id.tvCountPriorty)
        TextView tvCountPriorty;
        @BindView(R.id.tvTotalAmountPriorty)
        TextView tvTotalAmountPriorty;
        @BindView(R.id.tvTextPriorty)
        TextView tvTextPriorty;

        @BindView(R.id.tvCountAside)
        TextView tvCountAside;
        @BindView(R.id.tvTotalAmountAside)
        TextView tvTotalAmountAside;
        @BindView(R.id.tvTextAside)
        TextView tvTextAside;

        public StringHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }
    }
}
