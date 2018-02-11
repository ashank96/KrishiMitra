package com.aloofwillow96.languageapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
