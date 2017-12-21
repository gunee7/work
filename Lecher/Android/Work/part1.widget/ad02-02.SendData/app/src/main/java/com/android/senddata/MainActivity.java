package com.android.senddata;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // 1. 위젯 선언
    private EditText edtName = null;
    private Button   btnSend = null;
    private TextView txtMsg  = null;
    private Button button3  = null;
    private Button button4 = null;
    private Button button5 = null;
    private Button button6 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 2. 위젯 찾기
        edtName = findViewById(R.id.editText);
        btnSend = findViewById(R.id.btnSend);
        txtMsg = findViewById(R.id.textMsg);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);




        // 3. 위젯 설정정
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. edtName에서 값 가져오기
                String str = edtName.getText().toString();

                // 2. txtMsg 에 값을 설정하기.
                txtMsg.setText(str);

            }
        });




        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://givecoffeemall.com"));
                startActivity(i);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}




