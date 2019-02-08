package com.fuchs.navigation_activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.fuchs.R;

import org.w3c.dom.Text;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ClaimsFragment extends Fragment {
    View view;

    @BindView(R.id.image_date)
    ImageView image_date;

    @BindView(R.id.month_edt)
    TextView month_edt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_claims, null);
        ButterKnife.bind(this, view);
        TextView textview = (TextView) getActivity().findViewById(R.id.tvHeading);
        textview.setText("Claims");
        ImageView ivCalendar = (ImageView) getActivity().findViewById(R.id.ivCalendar);
        ImageView ivSearch = (ImageView) getActivity().findViewById(R.id.ivSearch);
        ivCalendar.setVisibility(View.GONE);
        ivSearch.setVisibility(View.GONE);
        return view;
    }

    @OnClick(R.id.image_date)
    public void onImageClick(View view) {
        switch (view.getId()) {
            case R.id.image_date:
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


        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        month_edt.setText(dayOfMonth + "-" + monthOfYear+"-"+year);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();

    }

    @OnClick({R.id.tvSubmit,R.id.tvCancel})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tvCancel:
                method();
                break;
            case R.id.tvSubmit:
                method();
                break;

        }



    }

    void method(){
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new DashboardFragment());
        ft.commit();
    }

}
