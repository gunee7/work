package com.example.st1drawermenu;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.content.Intent;

/**
 * Created by Administrator on 2018-01-19.
 */

public class TabBarView extends RelativeLayout  {


    private Button btngivebean, btnfriend, btnchat, btnmygive, btnview;

    public TabBarView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TabBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public TabBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.activity_tabbar, this, true);

        btngivebean = (Button)findViewById(R.id.btngivebean);
        btnfriend = (Button)findViewById(R.id.btnfriend);
        btnchat = (Button)findViewById(R.id.btnchat);
        btnmygive = (Button)findViewById(R.id.btnmygive);
        btnview = (Button)findViewById(R.id.btnview);

        ClickListener cl = new ClickListener();
        btngivebean.setOnClickListener(cl);
    }

    private class ClickListener implements View.OnClickListener {

        private final int FRAGMENT1 = 1;
        private final int FRAGMENT2 = 2;
        private final int FRAGMENT3 = 3;
        private final int FRAGMENT4 = 4;
        private final int FRAGMENT5 = 5;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btngivebean:
                    Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();

                    // '버튼1' 클릭 시 '프래그먼트1' 호출
                    break;

                case R.id.btnfriend :
                    Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();

                    // '버튼2' 클릭 시 '프래그먼트2' 호출
                    break;

                case R.id.btnchat :
                    Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();

                    // '버튼2' 클릭 시 '프래그먼트2' 호출
                    break;

                case R.id.btnmygive :
                    Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();

                    // '버튼2' 클릭 시 '프래그먼트2' 호출
                    break;

                case R.id.btnview :
                    Toast.makeText(getContext(), "Toast", Toast.LENGTH_SHORT).show();

                    // '버튼2' 클릭 시 '프래그먼트2' 호출
                    break;
            }
        }
    }





}


