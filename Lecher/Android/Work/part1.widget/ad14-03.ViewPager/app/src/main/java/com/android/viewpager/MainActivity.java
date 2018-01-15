package com.android.viewpager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //위젯 선언
    private Button btngivebean;
    private Button btnfriend;
    private Button btnchat;
    private Button btnmygive;
    private Button btnview;


    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯찾기
        btngivebean = findViewById(R.id.btngivebean);
        btnfriend = findViewById(R.id.btnfriend);
        btnchat = findViewById(R.id.btnchat);
        btnmygive = findViewById(R.id.btnmygive);
        btnview = findViewById(R.id.btnview);


        pager = findViewById(R.id.pager);




        //핸들러 설정
        ClickHandler handler = new ClickHandler();
        btngivebean.setOnClickListener(handler);
        btnfriend.setOnClickListener(handler);
        btnchat.setOnClickListener(handler);
        btnmygive.setOnClickListener(handler);
        btnview.setOnClickListener(handler);


        //pager 와 adpater연결
        pager = findViewById(R.id.pager);
        MyPagerAdater adater = new MyPagerAdater(getApplicationContext());
        pager.setAdapter( adater );
    }

    //버튼 click 핸들러
     private class ClickHandler implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btngivebean:
                    pager.setCurrentItem(0,true);
                break;
                case  R.id.btnfriend:
                    pager.setCurrentItem(1,true);
                break;
                case  R.id.btnchat:
                    pager.setCurrentItem(2,true);
                break;
                case  R.id.btnmygive:
                    pager.setCurrentItem(3,true);
                    break;
                case  R.id.btnview:
                    pager.setCurrentItem(4,true);
                    break;


            }

        }
    }


     // ViewPager adapter 만들기
    private class MyPagerAdater extends PagerAdapter {

        //필드선언
         private LayoutInflater inflater;

         //디폴트 생성자 : 반드시 Context 생성자의 매개변수로 받아야 한다.
         public  MyPagerAdater(Context c) {
             this.inflater = LayoutInflater.from( c );
         }

         @Override
         public int getCount() {
             return 5;
         }

         @Override
         public boolean isViewFromObject(View view, Object object) {
             return view == object;
         }


         @Override
         public Object instantiateItem(View container, int position) {
             View v = null;

             switch (position) {
                 case 0:
                  v = inflater.inflate(R.layout.inflate_one, null, false);
                 break;

                 case 1 :
                     v = inflater.inflate(R.layout.inflate_two, null, false);
                     break;

                 case 2 :
                     v = inflater.inflate(R.layout.inflate_three, null, false);
                     break;
                 case 3 :
                     v = inflater.inflate(R.layout.inflate_four, null, false);
                     break;
                 case 4 :
                     v = inflater.inflate(R.layout.inflate_five, null, false);
                     break;

             }
             pager.addView( v );
             return v;
         }

         @Override
         public void destroyItem(View container, int position, Object object) {
             pager.removeView((View) object);
         }


     }
}
