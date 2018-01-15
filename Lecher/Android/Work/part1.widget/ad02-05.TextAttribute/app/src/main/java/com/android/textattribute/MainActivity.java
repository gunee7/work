package com.android.textattribute;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt1 = null;
    private TextView txt2 = null;
    private TextView txt3 = null;
    private TextView txt4 = null;
    private TextView txt5 = null;
    private TextView txt6 = null;
    private Button btn1 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);


        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //타이틀 변경.
                setTitle("속성 변경 후 : 타이밍");
                setTitle(R.string.app_name2);

                // txt1.size변경
                txt1.setTextSize(10);

                // txt2.color변경
                txt2.setTextColor(Color.BLUE);

                // txt3.ITALIC변경
                txt3.setTypeface(txt3.getTypeface(), Typeface.BOLD | Typeface.ITALIC);
                txt3.setTypeface(txt3.getTypeface(), Typeface.BOLD_ITALIC);

                txt4.setTextSize(5);
                txt5.setTextSize(15);
                txt6.setTextSize(25);

            }
        });
    }
}
