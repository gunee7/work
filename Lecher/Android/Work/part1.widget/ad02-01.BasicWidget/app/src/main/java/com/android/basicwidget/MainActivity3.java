package com.android.basicwidget;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity3 extends AppCompatActivity {


    private Button btngivebean;
    private Button btnfriend;
    private Button btnchat;
    private Button btnmygive;
    private Button btnview;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);


        btngivebean = findViewById(R.id.btngivebean);
        btnfriend = findViewById(R.id.btnfriend);
        btnchat = findViewById(R.id.btnchat);
        btnmygive = findViewById(R.id.btnmygive);
        btnview = findViewById(R.id.btnview);


        btngivebean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnfriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "친구를 찾아보세요", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(i); //새창 띄우기


            }
        });


        btnchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "채팅을 시작합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnmygive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "나의 기부", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(i); //새창 띄우기

            }
        });


        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "더많은 메뉴로 넘어갑니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Menu6Activity.class);
                startActivity(i); //새창 띄우기

            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "가난한 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "배고픈 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "고아들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "거리의 객들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
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


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "아프리카아이들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
                startActivity(i);
            }
        });


        button7.setOnClickListener(new View.OnClickListener() {
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
