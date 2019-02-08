package com.fuchs.navigation_activity.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fuchs.R;
import com.fuchs.navigation_activity.activity.AddToCartActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewOrderAdapter extends RecyclerView.Adapter<NewOrderAdapter.MyHolder> {
    Activity activity;

    public NewOrderAdapter(Activity activity) {
        this.activity = activity;

    }

    @NonNull
    @Override
    public NewOrderAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_items_image, parent, false);

        return new NewOrderAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewOrderAdapter.MyHolder myHolder, int pos) {
        myHolder.iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if(pos/2==0)
        {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.engine_oil));
        }
        else
        {
            myHolder.iv.setImageDrawable(activity.getResources().getDrawable(R.drawable.automatic_transmission));
        }


        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.startActivity(new Intent(activity,AddToCartActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
