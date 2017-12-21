package com.example.st3toolbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private TextView textView = null;
    private Button button = null;
    private Button button2 = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.in.textView);
        button = findViewById(R.in.button);
        button2 = findViewById(R.in.button2);


    }
}
