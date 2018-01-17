package com.example.st1drawermenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainContent1 extends AppCompatActivity {



    private Button btnA1;
    private Button btnA2;
    private Button btnA3;
    private Button btnA4;
    private Button btnA5;
    private Button btnA6;
    private Button btnA7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main1);

       btnA1 = findViewById(R.id.btnA1);
       btnA2 = findViewById(R.id.btnA2);
       btnA3 = findViewById(R.id.btnA3);
       btnA4 = findViewById(R.id.btnA4);
       btnA5 = findViewById(R.id.btnA5);
       btnA6 = findViewById(R.id.btnA6);
       btnA7 = findViewById(R.id.btnA7);



        btnA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "가난한 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.givecoffeemall.com"));
                startActivity(i);
            }
        });


        btnA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "배고픈 사람들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);
            }
        });


        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "고아들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);
            }
        });


        btnA4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "거리의 객들", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(i);
            }
        });


        btnA5.setOnClickListener(new View.OnClickListener() {
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


        btnA6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(), R.string.clickmsg2,
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });


        btnA7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "끝내기", Toast.LENGTH_SHORT).show();

                switch (view.getId()) {
                    case R.id.btnA7:
                        finish();
                        break;

                    default:
                        break;
                }
            }
        });



    }
}
