package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.NewOrderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewOrderActivity extends Activity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        initViews();
        ButterKnife.bind(this);
    }

    private void initViews() {
    gridLayoutManager=new GridLayoutManager(this,2);
    recyclerView.setLayoutManager(gridLayoutManager);
    recyclerView.setAdapter(new NewOrderAdapter(this));

    }
}
