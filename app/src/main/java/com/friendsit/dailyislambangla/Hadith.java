package com.friendsit.dailyislambangla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Hadith extends AppCompatActivity {

    ListView listView_hadith;
    ProgressBar progressBar;


    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadith);

        listView_hadith = findViewById(R.id.listView_hadith);
        progressBar = findViewById(R.id.progressBar);


        String url = "https://official-mafuz-alam.000webhostapp.com/Daily_Islam_Bangla/Daily_Hadith.json";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {

                progressBar.setVisibility(View.GONE);

                try {

                    for (int x = 0; x < jsonArray.length(); x++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(x);

                        String title = jsonObject.getString("title");
                        String des = jsonObject.getString("des");
                        String book_Name = jsonObject.getString("book_Name");

                        hashMap = new HashMap<>();
                        hashMap.put("title", title);
                        hashMap.put("des", des);
                        hashMap.put("book_Name", book_Name);
                        arrayList.add(hashMap);

                    }


                    Myadapter myAdapter = new Myadapter();
                    listView_hadith.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Hadith.this);
        requestQueue.add(jsonArrayRequest);

    }


    private class Myadapter extends BaseAdapter {

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
            View myView = layoutInflater.inflate(R.layout.item_hadith, parent, false);


            //==============================================
            TextView item_title = myView.findViewById(R.id.textView_title);
            TextView item_des = myView.findViewById(R.id.textView_des);
            TextView item_bookName = myView.findViewById(R.id.textView_bookName);
            //==============================================

            HashMap<String, String> hashMap = arrayList.get(position);

            String title = hashMap.get("title");
            String des = hashMap.get("des");
            String book_Name = hashMap.get("book_Name");

            item_title.setText(title);
            item_des.setText(des);
            item_bookName.setText(book_Name);


            return myView;
        }
    }


}