 package com.example.startactivityforresut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MAIN = 10000 ;

    // 위젯 선언
    private EditText edtText1;
    private EditText edtText2;
    private Button   btnStart;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        edtText1 = findViewById(R.id.edt_text1);
        edtText2 = findViewById(R.id.edt_text2);

        btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.content.Intent i = new android.content.Intent( MainActivity.this, SecondActivity.class);
                i.putExtra("p1",  Integer.valueOf( edtText1.getText().toString().isEmpty() ? "0" :  edtText1.getText().toString() ) );
                i.putExtra("p2",  Integer.valueOf( edtText2.getText().toString().isEmpty() ? "0" :  edtText2.getText().toString() ) );

                // 새창띄우기
                startActivityForResult(i, REQUEST_CODE_MAIN);
            }
        });

    }
}
