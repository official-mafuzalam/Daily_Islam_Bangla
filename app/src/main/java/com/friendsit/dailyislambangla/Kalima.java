package com.friendsit.dailyislambangla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class Kalima extends AppCompatActivity {

    GridView graidView_kalima;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalima);
        this.setTitle(getString(R.string.kalima));

        graidView_kalima = findViewById(R.id.graidView_kalima);

        creatTable();


        MyAdapter myAdapter = new MyAdapter();
        graidView_kalima.setAdapter(myAdapter);


    }

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
            View myView = layoutInflater.inflate(R.layout.item_kalima, parent, false);


            //==============================================
            TextView item_titel = myView.findViewById(R.id.kalima_titel);
            TextView item_desc = myView.findViewById(R.id.kalima_des);
            //==============================================


            HashMap<String, String> hashMap = arrayList.get(position);

            String titel = hashMap.get("titel");
            String des = hashMap.get("des");

            item_titel.setText(titel);
            item_desc.setText(des);

            item_titel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (item_desc.getVisibility() == View.GONE) {
                        item_desc.setVisibility(View.VISIBLE);
                    } else {
                        item_desc.setVisibility(View.GONE);
                    }

                }
            });


            return myView;
        }
    }

//=======================================

    private void creatTable() {

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_kalima_taiyyeba));
        hashMap.put("des", getString(R.string.kalima_taiyyeba));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_sahadat));
        hashMap.put("des", getString(R.string.sahadat));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_tauheed));
        hashMap.put("des", getString(R.string.tauheed));
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_tamjeed));
        hashMap.put("des", getString(R.string.tamjeed));
        arrayList.add(hashMap);

    }
}