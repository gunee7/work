package com.example.startactivityforresut;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private Button btnFinish;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtView = findViewById(R.id.txt_view);

        android.content.Intent i = getIntent();
        int p1 = i.getIntExtra("p1", 0 );
        int p2 = i.getIntExtra("p2", 0 );

        StringBuilder sb = new StringBuilder();
        sb.append("p1 : " + p1 );
        sb.append("\n");
        sb.append("p2 : " + p2 );
        txtView.setText( sb.toString() );


        btnFinish = findViewById(R.id.btn_finish);


    }
}
