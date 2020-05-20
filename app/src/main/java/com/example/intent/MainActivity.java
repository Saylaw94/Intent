package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    LinearLayout loc, web, phone, wifi, bluetooth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loc = findViewById(R.id.loc);
        phone = findViewById(R.id.phone);
        web = findViewById(R.id.web);
        wifi = findViewById(R.id.wifi);
        bluetooth = findViewById(R.id.bluetooth);

        phone.setOnClickListener(this);
        web.setOnClickListener(this);
        wifi.setOnClickListener(this);
        loc.setOnClickListener(this);
        bluetooth.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phone:{
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:" + 974748061));

                if (i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            } break;
            case R.id.wifi:{
                Intent i = new Intent(Settings.ACTION_WIFI_SETTINGS);

                if (i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            } break;
            case R.id.web:{
                Uri webpage = Uri.parse("https://kun.uz");
                Intent i = new Intent(Intent.ACTION_VIEW, webpage);

                if (i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            } break;
            case R.id.loc:{
                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                if (i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            } break;
            case R.id.bluetooth:{
                Intent i = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                if (i.resolveActivity(getPackageManager()) !=null){
                    startActivity(i);
                }
            } break;
        }
    }
}
