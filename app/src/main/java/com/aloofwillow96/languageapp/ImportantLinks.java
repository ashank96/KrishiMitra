package com.aloofwillow96.languageapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class ImportantLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_links);
        RelativeLayout weblink1=(RelativeLayout)findViewById(R.id.krishikannada);
        RelativeLayout weblink2=(RelativeLayout)findViewById(R.id.krishidarshan);
        weblink1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.krishikannada.com/"));

                startActivity(intent);
            }
        });
        weblink2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCi4gLprmCQtVfXNfNHOkdDA"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink3=(RelativeLayout)findViewById(R.id.krishijagattu);
        weblink3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://krishijagattu.wordpress.com/"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink4=(RelativeLayout)findViewById(R.id.krishimobile);
        weblink4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.krishikannada.com/mobileapps/"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink5=(RelativeLayout)findViewById(R.id.krishimaratavahini);
        weblink5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.krishimaratavahini.kar.nic.in/"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink6=(RelativeLayout)findViewById(R.id.ekrishi);
        weblink6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://e-krishiuasb.karnataka.gov.in/"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink7=(RelativeLayout)findViewById(R.id.agriculturemedia);
        weblink7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://krushimadhyama.org/index_1.html"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink8=(RelativeLayout)findViewById(R.id.kisan);
        weblink8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://kisan.in/"));

                startActivity(intent);
            }
        });

        RelativeLayout weblink9=(RelativeLayout)findViewById(R.id.raitamitra);
        weblink9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://raitamitra.kar.nic.in/KAN/index.asp"));

                startActivity(intent);
            }
        });




    }
}
