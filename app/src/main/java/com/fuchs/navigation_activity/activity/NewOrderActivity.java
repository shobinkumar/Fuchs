package com.fuchs.navigation_activity.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.NewOrderAdapter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NewOrderActivity extends Activity {
//    @BindView(R.id.recyclerView)
//    RecyclerView recyclerView;
//    GridLayoutManager gridLayoutManager;

    TextView txtSold;
    TextView txtShip;


    @BindView(R.id.tvNext)
    TextView tvNext;
    @BindView(R.id.ivCalendar)
    ImageView ivCalendar;
    @BindView(R.id.ivCalendar2)
    ImageView ivCalendar2;
    @BindView(R.id.tvOrderDate)
    TextView tvOrderDate;
    @BindView(R.id.tvRequestDate)
    TextView tvRequestDate;

    Calendar dateSelected = Calendar.getInstance();
    private DatePickerDialog datePickerDialog;

    int from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        ButterKnife.bind(this);
        txtSold = (TextView) findViewById(R.id.txtSold);
        txtShip = (TextView) findViewById(R.id.txtShip);
        txtSold.setText("Sold to Party");
        txtShip.setText("Ship to Party");


        ImageView imageView = (ImageView) findViewById(R.id.ivDrawer);

        TextView tv = (TextView) findViewById(R.id.tvHeading);
        ImageView imageViewSearch = (ImageView) findViewById(R.id.ivSearch);
        imageViewSearch.setVisibility(View.GONE);
        tv.setText("New Order");
        imageViewSearch.setVisibility(View.GONE);
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
//    gridLayoutManager=new GridLayoutManager(this,2);
//    recyclerView.setLayoutManager(gridLayoutManager);
//    recyclerView.setAdapter(new NewOrderAdapter(this));

    }

    @OnClick(R.id.tvNext)
    public void onClick(View view) {
        startActivity(new Intent(this, ProductListActivity.class));
    }

    @OnClick({R.id.ivCalendar, R.id.ivCalendar2})
    public void onImageClick(View view) {
        switch (view.getId()) {
            case R.id.ivCalendar:
                from =0;
                setDateTimeField();
                break;

            case R.id.ivCalendar2:
                from =1;

                setDateTimeField();
                break;
        }

    }

    private void setDateTimeField() {
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        if (from==1)
                        tvRequestDate.setText(dayOfMonth + "-" + monthOfYear+"-"+year);
                        else
                        tvOrderDate.setText(dayOfMonth + "-" + monthOfYear+"-"+year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }


}
