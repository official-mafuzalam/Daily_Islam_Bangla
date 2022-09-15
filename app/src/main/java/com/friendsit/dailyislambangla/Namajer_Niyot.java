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

public class Namajer_Niyot extends AppCompatActivity {

    GridView graidView_namajerNiyot;

    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namajer_niyot);
        this.setTitle(getString(R.string.Namajer_niyot));

        graidView_namajerNiyot = findViewById(R.id.graidView_namajerNiyot);

        creatTable();


        MyAdapter myAdapter = new MyAdapter();
        graidView_namajerNiyot.setAdapter(myAdapter);


    }
    //-----------------------------------------------------------------------------------------

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
            View myView = layoutInflater.inflate(R.layout.item_niyot, parent, false);


            //==============================================
            TextView item_titel = myView.findViewById(R.id.niyot_titel);
            TextView item_desc = myView.findViewById(R.id.niyot_des);
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


    private void creatTable() {

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.fojor_name));
        hashMap.put("des", getString(R.string.niyot_fojor));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.johor_name));
        hashMap.put("des", getString(R.string.niyot_johor));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.asor_name));
        hashMap.put("des", getString(R.string.niyot_asor));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.magrib_name));
        hashMap.put("des", getString(R.string.niyot_magrib));
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("titel", getString(R.string.esha_name));
        hashMap.put("des", getString(R.string.niyot_esha));
        arrayList.add(hashMap);


    }

}