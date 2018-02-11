package com.aloofwillow96.languageapp;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String loadLanguage=null;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case R.id.kannada:
                if(loadLanguage.equals("en")) {
                    loadLanguage = "kn";
                    Locale locale = new Locale(loadLanguage);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
                    editor.putString("id", loadLanguage);
                    editor.apply();
                    finish();
                    startActivity(getIntent());

                    Toast.makeText(this, "Language changed to Kannada", Toast.LENGTH_SHORT).show();
                }

                return true;
            case R.id.english:
                if(loadLanguage.equals("kn")) {
                    loadLanguage = "en";
                    Locale locale = new Locale(loadLanguage);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.setLocale(locale);
                    getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
                    editor.putString("id",loadLanguage);
                    editor.apply();
                    finish();
                    startActivity(getIntent());
                    Toast.makeText(this, "Language changed to English", Toast.LENGTH_SHORT).show();
                }
                return true;
            default:return false;


        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String a=prefs.getString("id",null);
        if(a!=null){
            Locale locale = new Locale(a);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            loadLanguage=a;
            SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();
            editor.putString("id",loadLanguage);
            editor.apply();
        }else{
            Locale locale = new Locale("kn");
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            loadLanguage="kn";
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }

        setContentView(R.layout.activity_main);

        ImageView cropView=(ImageView)findViewById(R.id.crop);
        ImageView soilView=(ImageView)findViewById(R.id.soilhealth);
        ImageView pestView=(ImageView)findViewById(R.id.pestcontrol);
        ImageView insuranceView=(ImageView)findViewById(R.id.insurance);
        ImageView faqView=(ImageView)findViewById(R.id.faq);
        ImageView linkView=(ImageView)findViewById(R.id.links);
        ImageView aboutView=(ImageView)findViewById(R.id.aboutus);


        cropView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CropsGateway.class);
                startActivity(intent);
            }
        });
        soilView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SoilHealth.class);
                startActivity(intent);
            }
        });
        pestView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PestControl.class);
                startActivity(intent);
            }
        });

        linkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ImportantLinks.class);
                startActivity(intent);
            }
        });
        faqView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FAQ.class);
                startActivity(intent);
            }
        });

        insuranceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Insurance.class);
                startActivity(intent);
            }
        });
        aboutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AboutUs.class);
                startActivity(intent);
            }
        });







    }

}
