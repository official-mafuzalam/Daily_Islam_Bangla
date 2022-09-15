package com.friendsit.dailyislambangla;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import soup.neumorphism.NeumorphFloatingActionButton;
import soup.neumorphism.NeumorphImageButton;

public class About_Us extends AppCompatActivity {

    NeumorphFloatingActionButton fb;
    NeumorphImageButton btn_developer_Call;

    BottomNavigationView bottom_appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);


        fb = findViewById(R.id.fb);
        btn_developer_Call = findViewById(R.id.btn_developer_Call);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sAppLink = "fb://page/112708198032677";
                String sPackeg = "com.facebook.katana";
                String sWebLink = "https://www.facebook.com/fnditLTD";
                openLink(sAppLink, sPackeg, sWebLink);

            }
        });

        btn_developer_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "+8801621833839";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

    }

    //============== Facebook Link Open in FB app Start ======================
    private void openLink(String sAppLink, String sPackeg, String sWebLink) {

        try {
            Uri uri = Uri.parse(sAppLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setPackage(sPackeg);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } catch (ActivityNotFoundException activityNotFoundException){
            Uri uri = Uri.parse(sWebLink);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    //============== Facebook Link Open in FB app End ======================

}