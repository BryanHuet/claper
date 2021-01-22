package com.example.appli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        desc = (TextView) findViewById(R.id.textView2);
        desc.setText(getIntent().getStringExtra("description"));
        // modifier les descriptions, etc ... dynamiquement
    }
}