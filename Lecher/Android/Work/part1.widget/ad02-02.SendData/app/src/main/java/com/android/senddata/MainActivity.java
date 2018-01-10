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
    private EditText editText = null;
    private Button   btnSend = null;
    private TextView txtMsg  = null;
    private Button button1  = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;
    private Button amb = null;
    private Button gallery = null;
    private Button end = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 2. 위젯 찾기
        editText = findViewById(R.id.editText);
        btnSend = findViewById(R.id.btnSend);
        txtMsg = findViewById(R.id.textMsg);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        amb = findViewById(R.id.amb);
        gallery = findViewById(R.id.gallery);
        end = findViewById(R.id.end);


        // 3. 위젯 설정정
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(" ");
            }
        });




        // 3. 위젯 설정정
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. edtName에서 값 가져오기
                String str = editText.getText().toString();

                // 2. txtMsg 에 값을 설정하기.

                txtMsg.setText(str);

            }
        });




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "다음으로 가실까요?", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.daum.co.kr"));
                startActivity(i);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "구글로 가실까요?", Toast.LENGTH_SHORT).show();;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);


            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://givecoffeemall.com"));
                startActivity(i);

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "네이버로 가실까요?", Toast.LENGTH_SHORT).show();;
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
                startActivity(i);

            }
        });


        amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(), "911로 연결하기",
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });



        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(),  "갤러리 열기",
                        Toast.LENGTH_LONG).show();

                String url = "content://media/internal/images/media";
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(i);


            }
        });



        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(),  "끝내기",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}




