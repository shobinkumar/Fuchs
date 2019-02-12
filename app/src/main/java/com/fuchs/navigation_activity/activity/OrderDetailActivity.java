package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderDetailActivity extends Activity {
    View rl1;
    View rl2;

    @BindView(R.id.tvSapId)
    TextView tvSapId;



    TextView tvName, tvStreet, tvPostal, tvCity, tvRegion, tvCountry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        ButterKnife.bind(this);


        initViews();


        rl1=findViewById(R.id.add1);
        rl2=findViewById(R.id.add2);


        tvName = (TextView) rl1.findViewById(R.id.tvName);
        tvStreet = (TextView) rl1.findViewById(R.id.tvStreet);
        tvPostal = (TextView) rl1.findViewById(R.id.tvPostal);
        tvCity = (TextView) rl1.findViewById(R.id.tvCity);
        tvRegion = (TextView) rl1.findViewById(R.id.tvRegion);
        tvCountry = (TextView) rl1.findViewById(R.id.tvCountry);


        tvName.setText("Dutch");
        tvStreet.setText("Deansgate");
        tvPostal.setText(" 01275");
        tvCity.setText("Bristol");
        tvRegion.setText("F7");
        tvCountry.setText("England");




        ImageView imageViewSearch=(ImageView)findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.GONE);




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

    private void initViews() {
        if(getIntent().getIntExtra("value",9)==1)
        {
            tvSapId.setVisibility(View.INVISIBLE);
        }
        else
        {
            tvSapId.setVisibility(View.VISIBLE);
        }

    }
}
