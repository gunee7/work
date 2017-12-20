package com.android.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TextX = null;
    private EditText TextY = null;
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button button5 = null;
    private TextView TextZ = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextX = findViewById(R.id.TextX);
        TextY = findViewById(R.id.TextY);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        TextZ = findViewById(R.id.TextZ);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.valueOf(TextX.getText().toString());
                int y = Integer.valueOf(TextY.getText().toString());
                int rs = x+y;
                String s = String .valueOf(rs);
                TextZ.setText("결과는 :" + s);
             }
            });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.valueOf(TextX.getText().toString());
                int y = Integer.valueOf(TextY.getText().toString());
                int rs = x-y;
                String s = String .valueOf(rs);
                TextZ.setText("결과는 :" + s);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.valueOf(TextX.getText().toString());
                int y = Integer.valueOf(TextY.getText().toString());
                int rs = x*y;
                String s = String .valueOf(rs);
                TextZ.setText("결과는 :" + s);
            }
        });



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.valueOf(TextX.getText().toString());
                int y = Integer.valueOf(TextY.getText().toString());
                int rs = x/y;
                String s = String .valueOf(rs);
                TextZ.setText("결과는 :" + s);
            }
        });




        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.valueOf(TextX.getText().toString());
                int y = Integer.valueOf(TextY.getText().toString());
                int rs = x%y;
                String s = String .valueOf(rs);
                TextZ.setText("결과는 :" + s);
            }
        });




    }


}