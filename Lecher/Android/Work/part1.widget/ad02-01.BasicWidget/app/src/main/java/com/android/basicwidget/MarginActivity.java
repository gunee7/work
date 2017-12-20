package com.android.basicwidget;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MarginActivity extends AppCompatActivity {

    private TextView textView = null;
    private EditText editText = null;
    private Button button = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margin);

        button = (Button)  findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"메인으로 이동합니다.",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                    startActivity(i);
                    }


        });






            }
}
