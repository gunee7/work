package com.example.serialization;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class SubActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView textView = findViewById(R.id.text);

        //이젠 activity 에서 intent받기
        Intent i = getIntent();

        String d1 = i.getStringExtra("data");
        if (!d1.isEmpty())
            text.setText( text.getText() + " : " + d1 + "\n");

        int [] array = i.getIntArrayExtra("data");
        if(array !=null)
            text.setText( text.getText() + " : " + array.toString()+"\n");

    }

    }
}
