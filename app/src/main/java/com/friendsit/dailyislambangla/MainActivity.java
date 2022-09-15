package com.friendsit.dailyislambangla;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    TextView toast1;
    ImageButton warning;

    GridView graidView;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        warning = findViewById(R.id.warning);
        toast1 = findViewById(R.id.toast1);

        graidView = findViewById(R.id.graidView);

        creatTable();


        MyAdapter myAdapter = new MyAdapter();
        graidView.setAdapter(myAdapter);

        //-------------- Navigation Drawer ------------------------------------


        setUpToolbar();
        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:

                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_aboutUs:

                        Intent intent1 = new Intent(MainActivity.this, About_Us.class);
                        startActivity(intent1);
                        break;
//Paste your privacy policy link

//                    case  R.id.nav_Policy:{
//
//                        Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse(""));
//                        startActivity(browserIntent);
//
//                    }
                    //       break;
                    case R.id.nav_share: {

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "http://play.google.com/store/apps/detail?id=" + getPackageName();
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;

                    case R.id.nav_rate: {
                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                        }
                    }
                }
                return false;
            }
        });


        //-------------- Navigation Drawer ------------------------------------


        toast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "আসসালামুআলাইকুম ওয়ারাহমাতুল্লাহি ওয়াবারাকাতুহ", Toast.LENGTH_SHORT).show();
            }
        });

        //Tost coding end -----------------------
        //---------------------------------------

        //Warning coding start ------------------
        //---------------------------------------
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String S_Warning_message = getString(R.string.warning_message);

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("ভালো করে পড়ুন")

                        .setMessage(S_Warning_message)

                        .setPositiveButton("জ্বি বুঝেছি", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })

                        .setIcon(R.drawable.red_warning)

                        .show();
            }
        });
        //Warning coding end --------------------
        //---------------------------------------

    }
    //-----------------------------------------------------------------------------
    // onCreate Bundle end --------------------------------------------------------

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.item_home, parent, false);


            //==============================================
            TextView item_button = myView.findViewById(R.id.home_TV);
            //==============================================


            HashMap<String, String> hashMap = arrayList.get(position);

            String titel = hashMap.get("titel");

            item_button.setText(titel);

            item_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (position == 0) {
                        startActivity(new Intent(MainActivity.this, Kalima.class));
                    }

                    if (position == 1) {
                        startActivity(new Intent(MainActivity.this, Digital_Tasbih.class));
                    }

                    if (position == 2) {
                        startActivity(new Intent(MainActivity.this, Surah.class));
                    }

                    if (position == 3) {
                        startActivity(new Intent(MainActivity.this, Namajer_Niyot.class));
                    }
////------------------------------------------------
                    if (position == 4) {
                        startActivity(new Intent(MainActivity.this, Allah_Name.class));
                    }

                    if (position == 5) {
                        startActivity(new Intent(MainActivity.this, Hadith.class));
                    }

                    if (position == 6) {
                        Toast.makeText(getApplicationContext(), "পরবর্তী আপডেটে যোগ করা হবে", Toast.LENGTH_SHORT).show();
                    }

                    if (position == 7) {
                        Toast.makeText(getApplicationContext(), "পরবর্তী আপডেটে যোগ করা হবে", Toast.LENGTH_SHORT).show();
                    }
//
//                    if (position == 7) {
//                        startActivity(new Intent(MainActivity.this, About.class));
//                    }
//
//                    if (position == 8) {
//                        startActivity(new Intent(MainActivity.this, Contact.class));
//                    }
//
//                    if (position == 9) {
//                        Toast.makeText(getApplicationContext(),"Coming soon...", Toast.LENGTH_SHORT).show();
//                    }

                }
            });


            return myView;
        }
    }

    //==========================================================================

    private void creatTable() {

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.kalima));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.tasbih));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.sura));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.Namajer_niyot));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.Allah_Name));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.daily_hadith));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.dua));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.daily_worng));
        arrayList.add(hashMap);
//
//
//        hashMap = new HashMap<>();
//        hashMap.put("titel", getString(R.string.Warning));
//        arrayList.add(hashMap);

    }


    //---------------------------------------------------------------
    // Back Press Action --------------------------------------------
    @Override
    public void onBackPressed() {
        //Back Press direct exit coding start---------
        //super.onBackPressed();
        //Back Press direct exit coding end-----------

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Confirm Exit?")
                .setMessage("Do you really want to exit?")
                .setIcon(R.drawable.red_warning)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .show();

    }
    // Back Press Action end ----------------------------------------
    //---------------------------------------------------------------


    //-------------- Navigation Drawer ------------------------------------

    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

    //-------------- Navigation Drawer ------------------------------------


}