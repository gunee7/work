package com.example.st1drawermenu.Intro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.st1drawermenu.MainActivity;
import com.example.st1drawermenu.R;
import com.example.st1drawermenu.promotion.PromotionActivity;

public class IntroMainActivity extends AppCompatActivity {

    private ImageView intro_logo;
    private ImageView promotion1;
    private ImageView promotion2;
    private ImageView intro_coffee;
    private ImageView intro_bean;
    private ImageView intro_bingsu;
    private ImageView intro_beverage;
    private ImageView intro_desert;

    private TextView coffeetext;
    private TextView beantext;
    private TextView bingsutext;
    private TextView beveragetext;
    private TextView deserttext;

    private Button btnback;
    private Button btnnext;
    private WebView webView;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_main);





        promotion1     = findViewById(R.id.promotion1);
        promotion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), PromotionActivity.class);
                startActivity(i); //새창 띄우기
            }
        });


        intro_coffee   = findViewById(R.id.intro_coffee);
        intro_coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        intro_bean     = findViewById(R.id.intro_bean    );
        intro_bean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        intro_bingsu   = findViewById(R.id.intro_bingsu  );
        intro_bingsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        intro_beverage = findViewById(R.id.intro_beverage);
        intro_beverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        intro_desert   = findViewById(R.id.intro_desert  );
        intro_desert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        coffeetext   = findViewById(R.id.coffeetext);
        coffeetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        beantext     = findViewById(R.id.beantext    );
        beantext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        bingsutext   = findViewById(R.id.bingsutext  );
        bingsutext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        beveragetext = findViewById(R.id.beveragetext);
        beveragetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

        deserttext   = findViewById(R.id.deserttext  );
        deserttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });



        deserttext   = findViewById(R.id.deserttext  );
        deserttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기
            }
        });

    }
}







