package com.fuchs.navigation_activity.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fuchs.R;
import com.fuchs.navigation_activity.fragments.AddToCartFragment;
import com.fuchs.navigation_activity.fragments.PaymentFragment;
import com.fuchs.navigation_activity.fragments.ShippedFragment;
import com.fuchs.navigation_activity.fragments.ShippingAddressFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewOrderStepsActivity extends AppCompatActivity {

    @BindView(R.id.view1)
    View view1;

    @BindView(R.id.view2)
    View view2;

//    @BindView(R.id.view3)
//    View view3;

    Fragment addToCart;
   // Fragment payment;
    Fragment address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order_steps);
        ButterKnife.bind(this);
        initViews();
        listeners();

    }

    private void listeners() {
        replaceFragment(new ShippingAddressFragment());
        changeColor(getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));


    }

    public void changeColor(int color1, int color2, int color3) {

        view1.setBackgroundColor(color1);
       view2.setBackgroundColor(color2);
      //  view3.setBackgroundColor(color3);

    }


    private void initViews() {
        addToCart = new AddToCartFragment();
        address = new ShippingAddressFragment();
       // payment = new PaymentFragment();

    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
    }

}
