package com.fuchs.navigation_activity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.fuchs.R;
import com.fuchs.navigation_activity.fragments.ApprovedFragment;
import com.fuchs.navigation_activity.fragments.PendingApprovalFragment;
import com.fuchs.navigation_activity.fragments.ShippedFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderSummaryActivity extends AppCompatActivity {

    @BindView(R.id.view1)
    View view1;

    @BindView(R.id.view2)
    View view2;

    @BindView(R.id.view3)
    View view3;

    @BindView(R.id.ivDrawer)
    ImageView ivDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);
        ButterKnife.bind(this);
        replaceFragment(new PendingApprovalFragment());
        changeColor(getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

    }


    public void changeColor(int color1, int color2, int color3) {

        view1.setBackgroundColor(color1);
        view2.setBackgroundColor(color2);
        view3.setBackgroundColor(color3);

    }

    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

    @OnClick({R.id.ll1, R.id.ll2, R.id.ll3,R.id.ivDrawer})
    public void onClick(View view) {
        if (view.getId() == R.id.ll1) {
            replaceFragment(new PendingApprovalFragment());
            changeColor(getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        }
       else if (view.getId() == R.id.ll2) {
            replaceFragment(new ApprovedFragment());
            changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        }
        else if (view.getId() == R.id.ll3) {
            replaceFragment(new ShippedFragment());
            changeColor(getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor));

        }
        else if(view.getId()==R.id.ivDrawer)
        {
            finish();
        }



    }

}
