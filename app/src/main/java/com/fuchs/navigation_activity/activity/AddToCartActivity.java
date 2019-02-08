package com.fuchs.navigation_activity.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.AddToCartAdapter;
import com.fuchs.navigation_activity.fragments.ShippingAddressFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddToCartActivity extends AppCompatActivity {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    private TextView textView;
    private LinearLayout llActivityToolbar;
    private TextView tvHeading;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);
        ButterKnife.bind(this);
        initViews();

        TextView tvNext=(TextView)findViewById(R.id.tvNext);
        TextView tvPlaceOrder=(TextView)findViewById(R.id.tvPlaceOrder);
        tvNext.setVisibility(View.GONE);
        tvPlaceOrder.setVisibility(View.VISIBLE);
        tvPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(AddToCartActivity.this,ThanksActivity.class));
            }
        });

    }
    private void initViews() {
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new AddToCartAdapter(this));
        textView = (TextView) findViewById(R.id.tvNext);
        tvHeading = (TextView)findViewById(R.id.tvHeading);
        llActivityToolbar = (LinearLayout) findViewById(R.id.llActivityToolbar);
        ImageView imageViewSearch=(ImageView)findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.VISIBLE);
        tvHeading.setText("New Order");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm =getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, new ShippingAddressFragment());
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }
        });
        llActivityToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
