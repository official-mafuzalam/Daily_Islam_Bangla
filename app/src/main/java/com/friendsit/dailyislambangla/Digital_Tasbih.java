package com.friendsit.dailyislambangla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Digital_Tasbih extends AppCompatActivity {

    TextView tv_Output;
    Button breset;
    LinearLayout linearLayout_add;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_tasbih);
        this.setTitle(getString(R.string.tasbih));

        tv_Output = findViewById(R.id.tv_Output);
        linearLayout_add = findViewById(R.id.linearLayout_add);
        breset = findViewById(R.id.breset);

        // Digital Tasbih Add One//
        linearLayout_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = count+1;
                tv_Output.setText(""+count);

            }
        });


        // Digital Tasbih Add One//
        breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count = 0;
                tv_Output.setText(""+count);
            }
        });

    }
}