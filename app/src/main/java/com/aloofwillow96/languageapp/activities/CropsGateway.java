package com.aloofwillow96.languageapp.activities;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.aloofwillow96.languageapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class CropsGateway extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crops_gateway);
        ImageView riceView= (ImageView) findViewById(R.id.rice);

        riceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropsGateway.this,CropTemplate.class);
                intent.putExtra("crop","rice");
                startActivity(intent);
            }
        });

        ImageView horsegramView= (ImageView) findViewById(R.id.horsegram);

        horsegramView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropsGateway.this,CropTemplate.class);
                intent.putExtra("crop","horsegram");
                startActivity(intent);
            }
        });

        ImageView turView= (ImageView) findViewById(R.id.tur);

        turView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropsGateway.this,CropTemplate.class);
                intent.putExtra("crop","tur");
                startActivity(intent);
            }
        });

        ImageView cowpeaView= (ImageView) findViewById(R.id.cowpea);

        cowpeaView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropsGateway.this,CropTemplate.class);
                intent.putExtra("crop","cowpea");
                startActivity(intent);
            }
        });

        ImageView jowarView= (ImageView) findViewById(R.id.jowar);

        jowarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CropsGateway.this,CropTemplate.class);
                intent.putExtra("crop","jowar");
                startActivity(intent);
            }
        });
    }
}
