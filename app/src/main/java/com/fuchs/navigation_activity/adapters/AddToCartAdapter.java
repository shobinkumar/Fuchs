package com.fuchs.navigation_activity.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fuchs.R;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.MyHolder> {

    Context context;
    public AddToCartAdapter(Context context) {
    this.context=context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_add_to_cart, parent, false);

        return new AddToCartAdapter.MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        public MyHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
