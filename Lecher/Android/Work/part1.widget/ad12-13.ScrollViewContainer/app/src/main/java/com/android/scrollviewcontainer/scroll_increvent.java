package com.android.scrollviewcontainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Button;

public class scroll_increvent extends AppCompatActivity {

    private ScrollView scrollView1 = null;
    private LinearLayout buttonlayout = null;

    private ScrollView scroll;
    private LinearLayout layout;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_increvent);

        //찾기
        scroll = findViewById(R.id.scroll);
        layout = findViewById(R.id.lauout);

        // 설정
        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {


            }
        });
    }
}
