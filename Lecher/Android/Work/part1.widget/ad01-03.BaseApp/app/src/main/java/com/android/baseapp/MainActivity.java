package com.android.baseapp;

import android.app.IntentService;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;





public class MainActivity extends AppCompatActivity {

    private Button google;
    private Button gallery;
    private Button amb;
    private Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        google = (Button) findViewById(R.id.google);
        amb = (Button)findViewById(R.id.amb);
        gallery = (Button)findViewById(R.id.gallery);
        end = (Button)findViewById(R.id.end);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Toast.makeText(getApplicationContext(),"네이트 홈페이지 열기", Toast.LENGTH_SHORT).show();

               Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
               startActivity(i);

            }
        });

        amb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(), R.string.clickmsg2,
                        Toast.LENGTH_LONG).show();

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel://119"));
                startActivity(i);
            }
        });




        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //이 부분에 버튼을클릭할때 동작할 코드를 넣음
                Toast.makeText(getApplicationContext(),  R.string.clickmsg3,
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
                Toast.makeText(getApplicationContext(),  R.string.clickmsg4,
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}
