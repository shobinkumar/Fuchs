package com.fuchs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Login", Toast.LENGTH_SHORT).show();
    }
}
