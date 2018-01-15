package com.example.inflation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button btn1;
    LinearLayout parent;
    private Button btn2;
    private Button btn3;
    private android.view.View child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 찾기

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent = findViewById(R.id.parent);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);


                // inflater.inflate(R.layout.layout_sub1, parent,) == inflater.inflate(R.layout.layout_sub1, parent, false );
                inflater.inflate(R.layout.layout_sub1, parent, true);


                // checkvax 찾기
                CheckBox chk = parent.findViewById(R.id.checkBox);
                chk.setText("infation 완료");

                Button button = parent.findViewById(R.id.button);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        TextView textView = findViewById(R.id.textView);
                        textView = parent.findViewById(R.id.textView);

                        textView.setText("btn2 눌림");

                    }
                });
            }
        });



         btn2 = findViewById(R.id.btn2);
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 parent = findViewById(R.id.parent);
                 LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_sub1, parent, true);

                 // checkvax 찾기
                 CheckBox chk = parent.findViewById(R.id.checkBox);
                 chk.setText("infation 완료");

                 Button button = parent.findViewById(R.id.button);
                 btn3.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                         TextView textView = findViewById(R.id.textView);
                         textView = parent.findViewById(R.id.textView);

                         textView.setText("btn2 눌림");

                     }
                 });
             }
         });



        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                parent = findViewById(R.id.parent);
                LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_sub1, parent, false);

                parent.addView(child);

                // checkvax 찾기
                CheckBox chk = parent.findViewById(R.id.checkBox);
                chk.setText("infation 완료");

                Button button = parent.findViewById(R.id.button);
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        TextView textView = findViewById(R.id.textView);
                        textView = parent.findViewById(R.id.textView);

                        textView.setText("btn2 눌림");

                    }
                });
            }
        });




    }
}