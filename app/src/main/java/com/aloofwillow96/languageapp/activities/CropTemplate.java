package com.aloofwillow96.languageapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.aloofwillow96.languageapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class CropTemplate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        if(intent.getStringExtra("crop").equals("rice"))
            setContentView(R.layout.activity_rice);
        else if(intent.getStringExtra("crop").equals("jowar"))
            setContentView(R.layout.jowar);
        else if(intent.getStringExtra("crop").equals("tur"))
            setContentView(R.layout.tur);
        else if(intent.getStringExtra("crop").equals("cowpea"))
            setContentView(R.layout.cowpea);
        else if(intent.getStringExtra("crop").equals("horsegram"))
            setContentView(R.layout.horsegram);
    }
}
