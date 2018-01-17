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


public class MainContent2 extends AppCompatActivity {

    private Button btngivebean;
    private Button btnfriend;
    private Button btnchat;
    private Button btnmygive;
    private Button btnmore;

    private Button btnB1;
    private Button btnB2;
    private Button btnB3;
    private Button btnB4;
    private Button btnB5;
    private Button btnB6;
    private Button btnB7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        btngivebean = findViewById(R.id.btngivebean);
        btnfriend = findViewById(R.id.btnfriend);
        btnchat = findViewById(R.id.btnchat);
        btnmygive = findViewById(R.id.btnmygive);
        btnmore = findViewById(R.id.btnmore);

        btnB1 = findViewById(R.id.btnB1);
        btnB2 = findViewById(R.id.btnB2);
        btnB3 = findViewById(R.id.btnB3);
        btnB4 = findViewById(R.id.btnB4);
        btnB5 = findViewById(R.id.btnB5);
        btnB6 = findViewById(R.id.btnB6);
        btnB7 = findViewById(R.id.btnB7);


        btngivebean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainContent2.class);
                startActivity(i); //새창 띄우기


            }
        });


        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "채팅을 시작합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainContent3.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnmygive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "나의 기부", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainContent4.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "더많은 메뉴로 넘어갑니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainContent5.class);
                startActivity(i); //새창 띄우기

            }
        });

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "가난한 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "배고픈 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "고아들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "거리의 객들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        btnB5.setOnClickListener(new View.OnClickListener() {
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


        btnB6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아프리카아이들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(i);
            }
        });


        btnB7.setOnClickListener(new View.OnClickListener() {
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
