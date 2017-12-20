package com.android.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //위젯 선언
    private Button btn1 ;
    private Button btn2 ;
    private Button btn3 ;
    private Button btn4 ;
    private Button btn5 ;
    private Button btn6 ;
    private Button btn7 ;
    private Button btn8 ;

    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯찾기
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        pager = findViewById(R.id.pager);


        //핸들러 설정
        ClickHandler handler = new ClickHandler();
        btn1.setOnClickListener(handler);
        btn2.setOnClickListener(handler);
        btn3.setOnClickListener(handler);
        btn4.setOnClickListener(handler);
        btn5.setOnClickListener(handler);
        btn6.setOnClickListener(handler);
        btn7.setOnClickListener(handler);
        btn8.setOnClickListener(handler);

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
                case R.id.btn1:
                    pager.setCurrentItem(0,true);
                break;
                case  R.id.btn2:
                    pager.setCurrentItem(1,true);
                break;
                case  R.id.btn3:
                    pager.setCurrentItem(2,true);
                break;
                case  R.id.btn4:
                    pager.setCurrentItem(3,true);
                    break;
                case  R.id.btn5:
                    pager.setCurrentItem(4,true);
                    break;
                case  R.id.btn6:
                    pager.setCurrentItem(5,true);
                    break;
                case  R.id.btn7:
                    pager.setCurrentItem(6,true);
                    break;
                case  R.id.btn8:
                    pager.setCurrentItem(7,true);
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
             return 8;
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
                 case 5 :
                     v = inflater.inflate(R.layout.inflate_six, null, false);
                     break;
                 case 6 :
                     v = inflater.inflate(R.layout.inflate_seven, null, false);
                     break;
                 case 7 :
                     v = inflater.inflate(R.layout.inflate_eight, null, false);
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
