package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;

public class OrderDetailActivity extends Activity {
    View rl1;
    View rl2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        ImageView imageViewSearch=(ImageView)findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.GONE);


        rl1=findViewById(R.id.add1);
        rl2=findViewById(R.id.add2);

        TextView textView=(TextView)rl1.findViewById(R.id.txtAddress);
        TextView textView1=(TextView)rl2.findViewById(R.id.txtAddress);
        textView.setText("Sold to Party");
        textView1.setText("Ship to Party");
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
