package com.android.basicwidget;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

class MainActivity21 extends AppCompatActivity {

    private TextView mTextMessage;
    private ImageView imageview;

    private Button btngivebean;
    private Button btnfriend;
    private Button btnchat;
    private Button btnmygive;
    private Button btnview;


    private ImageView imageView = null;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_givebean:
                    imageview.setImageDrawable( getResources().getDrawable(R.drawable.mov01, null) );

                    return true;

                case R.id.navigation_friend:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.mov02, null) );


                    return true;

                case R.id.navigation_chatting:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.mov03, null) );

                    return true;

                case R.id.navigation_mygive:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.mov04, null) );


                    return true;

                case R.id.navigation_more:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.mov05, null) );


                    return true;
            }
            return false;
        }
    };






    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);

        btngivebean = findViewById(R.id.btngivebean);
        btnfriend = findViewById(R.id.btnfriend);
        btnchat = findViewById(R.id.btnchat);
        btnmygive = findViewById(R.id.btnmygive);
        btnview = findViewById(R.id.btnview);


        imageView = findViewById(R.id.imageView);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



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

            Intent i = new Intent(getApplicationContext(), MainActivity21.class);
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

            Intent i = new Intent(getApplicationContext(), MainActivity21.class);
            startActivity(i); //새창 띄우기

        }
    });

    }
}
