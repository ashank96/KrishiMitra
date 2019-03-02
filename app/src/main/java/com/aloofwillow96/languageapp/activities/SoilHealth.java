package com.aloofwillow96.languageapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.aloofwillow96.languageapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SoilHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_health);
        Intent intent=getIntent();
    }
}
