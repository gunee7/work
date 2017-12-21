package com.android.eventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //찾기
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);


        //선언
        button1.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "무명 클래스 리스터", Toast.LENGTH_SHORT).show();
             process("AnonymousClass");
            }
            private void process(String anonymousClass) {
            }
        });
    }






    button2.setOnClickListener(new View.OnClickListener() {

    }
    @Override
    public void inlineclick(View view) {
        Toast.makeText(getApplicationContext(), "인라인 리스터", Toast.LENGTH_SHORT).show();
        switch (view.getId()) {
            case R.id.button2 ;
                finish();
                break;

            default:
        }
});






    public void inlineclick(View view) {
        Toast.makeText(getApplicationContext(), "인라인 리스터", Toast.LENGTH_SHORT).show();

        switch (view.getId()) {
            case R.id.button2;
            finish();
            break;

            default:
                break;
        }
    }






    button3.setOnClickListener(new View.OnClickListener() {


    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "implements 리스터", Toast.LENGTH_SHORT).show();

    }
    }

    @Override
    public void onClick(View view) {

    });


    private class innerclass implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "내부 클래스 리스터", Toast.LENGTH_SHORT).show();

        }
    }
}