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

public class Surah extends AppCompatActivity {

    GridView graidView_surah;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        this.setTitle(getString(R.string.sura));


        graidView_surah = findViewById(R.id.graidView_surah);

        creatTable();


        MyAdapter myAdapter = new MyAdapter();
        graidView_surah.setAdapter(myAdapter);


    }

    //-------------------------------------------------------------------------------------

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
            View myView = layoutInflater.inflate(R.layout.item_surah, parent, false);


            //==============================================
            TextView item_titel = myView.findViewById(R.id.surah_titel);
            TextView item_desc = myView.findViewById(R.id.surah_des);
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
        hashMap.put("titel", getString(R.string.titel_fatiha));
        hashMap.put("des", getString(R.string.fatiha));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_nas));
        hashMap.put("des", getString(R.string.nas));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_falak));
        hashMap.put("des", getString(R.string.falak));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_ikhlas));
        hashMap.put("des", getString(R.string.ikhlas));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_lahab));
        hashMap.put("des", getString(R.string.lahab));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_nasor));
        hashMap.put("des", getString(R.string.nasor));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_kafirun));
        hashMap.put("des", getString(R.string.kafirun));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_kausar));
        hashMap.put("des", getString(R.string.kausar));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_maun));
        hashMap.put("des", getString(R.string.maun));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_kurais));
        hashMap.put("des", getString(R.string.kurais));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.titel_fel));
        hashMap.put("des", getString(R.string.fel));
        arrayList.add(hashMap);

    }

}