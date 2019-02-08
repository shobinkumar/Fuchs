package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;

public class OrderDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ImageView imageView=(ImageView)findViewById(R.id.ivDrawer);
        TextView tv=(TextView)findViewById(R.id.tvHeading);
        tv.setText("Order Details");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
