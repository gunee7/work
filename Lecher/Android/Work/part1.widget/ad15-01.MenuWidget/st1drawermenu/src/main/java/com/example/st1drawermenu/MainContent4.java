package com.example.st1drawermenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainContent4 extends AppCompatActivity {

    private Button btnD1;
    private Button btnD2;
    private Button btnD3;
    private Button btnD4;
    private Button btnD5;
    private Button btnD6;
    private Button btnD7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main4);

        btnD1 = findViewById(R.id.btnD1);
        btnD2 = findViewById(R.id.btnD2);
        btnD3 = findViewById(R.id.btnD3);
        btnD4 = findViewById(R.id.btnD4);
        btnD5 = findViewById(R.id.btnD5);
        btnD6 = findViewById(R.id.btnD6);
        btnD7 = findViewById(R.id.btnD7);


        btnD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "가난한 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        btnD2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "배고픈 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        btnD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "고아들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        btnD4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "거리의 객들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        btnD5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(),  R.string.clickmsg3,
                        Toast.LENGTH_LONG).show();

                String url = "content://media/internal/images/media";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);
            }
        });


        btnD6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아프리카아이들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(i);
            }
        });


        btnD7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(), R.string.clickmsg2,
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });





    }
}
