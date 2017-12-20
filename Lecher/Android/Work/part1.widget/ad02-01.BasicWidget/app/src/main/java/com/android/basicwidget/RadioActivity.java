package com.android.basicwidget;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RadioActivity extends AppCompatActivity {


    private Button radioButton3 = null;
    private Button radioButton4 = null;
    private Button button12 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);


        radioButton3 = (Button) findViewById(R.id.radioButton3);


        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"확인을 눌러주세요", Toast.LENGTH_SHORT).show();

            }
        });






        radioButton4 = (Button) findViewById(R.id.radioButton4);



        radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"확인을 눌러주세요", Toast.LENGTH_SHORT).show();

            }
        });





        button12 = (Button) findViewById(R.id.button12);



        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"GB그룹에 오신것을 환영합니다.", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);

            }
        });


    }
}
