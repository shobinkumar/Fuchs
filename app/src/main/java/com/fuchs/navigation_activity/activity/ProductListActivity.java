package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.NewOrderAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductListActivity extends Activity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        ButterKnife.bind(this);
        ImageView imageView = (ImageView) findViewById(R.id.ivDrawer);
        TextView tv = (TextView) findViewById(R.id.tvHeading);
        ImageView imageViewSearch=(ImageView)findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.GONE);
        tv.setText("New Order");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        initViews();
        ButterKnife.bind(this);
    }

    private void initViews() {
    gridLayoutManager=new GridLayoutManager(this,2);
    recyclerView.setLayoutManager(gridLayoutManager);
    recyclerView.setAdapter(new NewOrderAdapter(this));

    }


}