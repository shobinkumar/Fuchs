package com.fuchs.navigation_activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fuchs.R;
import com.fuchs.navigation_activity.adapters.DashboardAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class DashboardFragment extends Fragment {
    View view;

    @BindView(R.id.ivChart)
    ImageView ivChart;

    @BindView(R.id.ivSold)
    ImageView ivSold;
    @BindView(R.id.txtOrderZone)
    TextView txtOrderZone;

    @BindView(R.id.rlOrderZone)
RelativeLayout rlOrderZone;


    @BindView(R.id.llDots)
    LinearLayout llDots;


    @BindView(R.id.tvRefresh)
    TextView tvRefresh;

    ProgressDialog progressDialog;
    private ProgressDialog dialog;

    @BindView(R.id.dashboardRecycler)
    RecyclerView dashboardRecycler;
    RecyclerView.LayoutManager layoutManager;

    public static int width, height;
    ArrayList<Object> al=new ArrayList<>();
    private PopupWindow  mPopupWindow;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard, null);
        ButterKnife.bind(this, view);
        progressDialog = new ProgressDialog(getActivity());
       // ivChart.setBackground(getActivity().getResources().getDrawable(R.drawable.order_by_zone));

        ViewTreeObserver vto = dashboardRecycler.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    dashboardRecycler.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    dashboardRecycler.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                width = dashboardRecycler.getMeasuredWidth();
                height = dashboardRecycler.getMeasuredHeight();
                initViews();

            }
        });


        addDots(-1);

        return view;
    }

    public void addDots(int pos) {


        ImageView[] dots = new ImageView[2];

        llDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.circle_unselected));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(10, 0, 0, 0);
            dots[i].setLayoutParams(params);
            if(pos==i)
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.circle_selected));



            llDots.addView(dots[i]);
        }


    }

    private void initViews() {

        al.add("a");
        al.add(1);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        dashboardRecycler.setAdapter(new DashboardAdapter(getActivity(),this,al));
        dashboardRecycler.setLayoutManager(layoutManager);


        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        ImageView ivCalendar = (ImageView) getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch = (ImageView) getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE);
        textview.setText("Dashboard");


    }

    //    @OnClick({R.id.rl1, R.id.rl2, R.id.rl3, R.id.tvRefresh})
    @OnClick({R.id.tvRefresh,R.id.rlOrderZone})
    public void onClick(View view) {
//        if (view.getId() == R.id.rl1) {
//            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",1));
//
//        } else if (view.getId() == R.id.rl2) {
//            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",2));
//
//        } else if (view.getId() == R.id.rl3) {
//            startActivity(new Intent(getActivity(), OrderSummaryActivity.class).putExtra("pos",3));
//
//        } else
        if (view.getId() == R.id.tvRefresh) {
            dialog = new ProgressDialog(getActivity());
            dialog.getWindow().setBackgroundDrawable(new
                    ColorDrawable(android.graphics.Color.TRANSPARENT));
            dialog.setIndeterminate(true);
            dialog.setCancelable(true);
            dialog.show();
            dialog.setContentView(R.layout.my_progress);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            }, 2000);

        }
        else if(view.getId()==R.id.rlOrderZone) {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);

            // Inflate the custom layout/view
            View customView = inflater.inflate(R.layout.pop_up, null);
            TextView tvOrderZone=(TextView)customView.findViewById(R.id.tvOrderZone);
            TextView tvSoldParty=(TextView)customView.findViewById(R.id.tvSoldParty);
            tvOrderZone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    txtOrderZone.setText("Order by zone");
                    ivSold.setVisibility(View.GONE);
                    ivChart.setVisibility(View.VISIBLE);

                    mPopupWindow.dismiss();
                }
            });
            tvSoldParty.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ivChart.setVisibility(View.GONE);
                    ivSold.setVisibility(View.VISIBLE);
                    txtOrderZone.setText("Sold to party");
                    mPopupWindow.dismiss();
                }
            });
            mPopupWindow = new PopupWindow(
                    customView,
                    450,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );

            // Set an elevation value for popup window
            // Call requires API level 21
            if (Build.VERSION.SDK_INT >= 21) {
                mPopupWindow.setElevation(5.0f);
            }

            mPopupWindow.showAtLocation(rlOrderZone, Gravity.CENTER,0,0);
        }

    }
}
