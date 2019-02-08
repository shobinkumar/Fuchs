package com.fuchs.navigation_activity.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.MainActivity;
import com.fuchs.R;

public class ThanksActivity extends AppCompatActivity {

    TextView tvBackToHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        ImageView imageView = (ImageView) findViewById(R.id.ivDrawer);
        TextView tv = (TextView) findViewById(R.id.tvHeading);
        ImageView imageViewSearch=(ImageView)findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.GONE);
        imageView.setVisibility(View.GONE);
        tv.setText("New Order");


        tvBackToHome=(TextView)findViewById(R.id.tvBackToHome);
        tvBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ThanksActivity.this,MainActivity.class));
            }
        });
    }
}
