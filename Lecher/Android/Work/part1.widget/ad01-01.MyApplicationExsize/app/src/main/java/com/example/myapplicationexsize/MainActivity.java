package com.example.myapplicationexsize;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView3 = null;
    private EditText editText1 = null;
    private EditText editText2 = null;
    private Button btn1 = null;
    private Button btn2 = null;
    private TextView textView2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView3 = findViewById(R.id.imageView3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        textView2 = findViewById(R.id.textView2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);



        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://givecoffeemall.com"));
                startActivity(i);

            }
        });


        editText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText1.setText(" ");
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText2.setText(" " );


            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str3 =editText1.getText().toString();
                String str4 =editText2.getText().toString();
                String str5 = str3 + str4;
                textView2.setText(str5 +"내용이 맞으면 확인을 눌러주세요");


            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText( MainActivity.this,"기브에 오신것을 환영합니다", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://givecoffeemall.com"));
                startActivity(i);

            }
        });


    }
}
