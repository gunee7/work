package com.android.imageview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1 = null;
    private ImageView imageView2 = null;
    private ImageView imageView3 = null;
    private Button   btn1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);

        // 3. 위젯 핸들러 설정
        Button btn1 = null;
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 타이틀 변경.
                setTitle(R.string.app_name2);

                // txt1 size 변경.
                imageView1.setText(30);

                // txt2. color 변경
                imageView2.setTextColor(Color.BLUE);

                // txt3. italic 변경
                imageView3.setTypeface(imageView3.getTypeface(), Typeface.BOLD | Typeface.ITALIC);
                imageView3.setTypeface(imageView3.getTypeface(), Typeface.BOLD_ITALIC);


            }
        });
    }
}
