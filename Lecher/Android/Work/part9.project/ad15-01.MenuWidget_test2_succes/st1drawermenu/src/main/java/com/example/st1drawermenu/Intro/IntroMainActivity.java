package com.example.st1drawermenu.Intro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.st1drawermenu.Main2Activity;
import com.example.st1drawermenu.MainActivity;
import com.example.st1drawermenu.R;

public class IntroMainActivity extends AppCompatActivity {

    private ImageView intro_image1;
    private ImageView intro_image2;
    private ImageView intro_image3;
    private ImageView intro_image4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_main);

        intro_image1 = findViewById(R.id.intro_image1);


        intro_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기

            }
        });


        intro_image2 = findViewById(R.id.intro_image2);


        intro_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i); //새창 띄우기

            }
        });


        intro_image3 = findViewById(R.id.intro_image3);


        intro_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i); //새창 띄우기

            }
        });


        intro_image4 = findViewById(R.id.intro_image4);


        intro_image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "give coffee에 오신걸 환영합니다", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i); //새창 띄우기

            }
        });

    }
}
