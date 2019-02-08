package com.fuchs;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fuchs.navigation_activity.AnalysisFragment;
import com.fuchs.navigation_activity.AttendenceFragment;
import com.fuchs.navigation_activity.ClaimsFragment;
import com.fuchs.navigation_activity.DashboardFragment;
import com.fuchs.navigation_activity.OrdersFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @BindView(R.id.navigationView)
    NavigationView nv;


    @BindView(R.id.llDashboardMain)
    LinearLayout llDashboardMain;
    @BindView(R.id.llDashboard)
    LinearLayout llDashboard;
    @BindView(R.id.tvDashboard)
    TextView tvDashboard;


    @BindView(R.id.ivDrawer)
    ImageView ivDrawer;
    @BindView(R.id.tvHeading)
    TextView tvHeading;

    @BindView(R.id.llOrderMain)
    LinearLayout llOrderMain;
    @BindView(R.id.llOrder)
    LinearLayout llOrder;
    @BindView(R.id.tvOrder)
    TextView tvOrder;

    @BindView(R.id.llClaimsMain)
    LinearLayout llClaimsMain;
    @BindView(R.id.llClaims)
    LinearLayout llClaims;
    @BindView(R.id.tvClaims)
    TextView tvClaims;

    @BindView(R.id.llAttendenceMain)
    LinearLayout llAttendenceMain;
    @BindView(R.id.llAttendence)
    LinearLayout llAttendence;
    @BindView(R.id.tvAttendence)
    TextView tvAttendence;

    @BindView(R.id.llAnalysisReportMain)
    LinearLayout llAnalysisReportMain;
    @BindView(R.id.llAnalysisReport)
    LinearLayout llAnalysisReport;
    @BindView(R.id.tvAnalysis)
    TextView tvAnalysis;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row_navigation_drawer);
        initOtherViews();

    }

    private void initOtherViews() {

        ButterKnife.bind(this);
        changeFragment(new DashboardFragment());
        changeFragments(getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));



    }

    @OnClick({R.id.llDashboardMain, R.id.llOrderMain, R.id.llClaimsMain, R.id.llAttendenceMain, R.id.llAnalysisReportMain,R.id.ivDrawer,R.id.tvLogout})
    public void pickDoor(View view) {
        if (view.getId() == R.id.llDashboardMain) {
            changeFragment(new DashboardFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));
        } else if (view.getId() == R.id.llOrderMain) {
            changeFragment(new OrdersFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.llClaimsMain) {
            changeFragment(new ClaimsFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.llAttendenceMain) {
            changeFragment(new AttendenceFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getDrawable(R.drawable.circle_blue), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor));

        } else if (view.getId() == R.id.llAnalysisReportMain) {
            changeFragment(new AnalysisFragment());
            changeFragments(getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_blue), getResources().getDrawable(R.drawable.circle_red), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerUnSelectedColor), getResources().getColor(R.color.colorDrawerSelectedColor));

        }
        else if (view.getId() == R.id.ivDrawer) {
          drawerLayout.openDrawer(Gravity.START);
        }
        else if (view.getId() == R.id.tvLogout) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
            startActivity(intent);
            finish();

        }

    }

    private void changeFragments(Drawable drawable, Drawable drawable1, Drawable drawable2, Drawable drawable3, Drawable drawable4, int color, int color1, int color2, int color3, int color4) {
        llDashboard.setBackground(drawable);
        llOrder.setBackground(drawable1);
        llClaims.setBackground(drawable2);
        llAttendence.setBackground(drawable3);
        llAnalysisReport.setBackground(drawable4);
        tvDashboard.setTextColor(color);
        tvOrder.setTextColor(color1);
        tvClaims.setTextColor(color2);
        tvAttendence.setTextColor(color3);
        tvAnalysis.setTextColor(color4);


    }

    void changeFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayout, fragment);
            ft.commit();
            drawerLayout.closeDrawers();
        }
    }
}
