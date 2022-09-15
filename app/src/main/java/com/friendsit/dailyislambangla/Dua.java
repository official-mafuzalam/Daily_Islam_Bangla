package com.friendsit.dailyislambangla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

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

public class Dua extends AppCompatActivity {


    ListView listView_dua;
    ProgressBar progressBar;


    ArrayList<HashMap<String, String>> arrayList = new ArrayList();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua);

        listView_dua = findViewById(R.id.listView_dua);
        progressBar = findViewById(R.id.progressBar_dua);

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
                    listView_dua.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Dua.this);
        requestQueue.add(jsonArrayRequest);

    }


    private class Myadapter extends BaseAdapter{

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




            return null;
        }
    }

}