package com.example.st2personview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017-12-26.
 */

public class PersonView extends RelativeLayout{



    //위젲 선언
    private ImageView imagephoto, imageCheck;
    private TextView textName,textAge;

    // OnImageClickListener 이벤트 발생시 전달할 데이터
    private PersonData person = null;

    //인터페이스 정의
    public  interface OnImageClickListener {
        void  onImageClick( PersonView view, PersonData person);

    }

    // 인터페이스 선언
    OnImageClickListener imageClickListener;
    public void setOnImageClickListener( OnImageClickListener listener) {
        this.imageClickListener = listener;
    }


    public PersonView(Context context) {
        super(context);
        init( context,null,0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init( context,attrs,0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init( context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
 

     //LinearLayout  관련 필수 속성 설정.


     // inflation 하기. 디자인 xml 파일 inflation 하기.
     // inflation이란 xml을 자바 인스턴스로 바꾸는 것

     LayoutInflater.from( context ).inflate( R.layout.view_person, this, true);

      

     // 위젯 찾rl
        textName = findViewById(R.id.text_name);
        textAge =  findViewById(R.id.text_age);
        imagephoto =  findViewById(R.id.image_photo);
        imageCheck =  findViewById(R.id.image_Check);

     // CustomView 디자인에서 attr로 정의한  속성값 가져오기.
        if( attrs !=null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
            String name = ta.getString(R.styleable.PersonView_my_age);
            textName.setText(name);

            // app:my_age에서 설정한 속성 값
            int age = ta.getInt(R.styleable.PersonView_my_age,-1);
            textAge.setText(age + "");

            //app:my_photo
            Drawable photo = ta.getDrawable(R.styleable.PersonView_my_photo);
            imagephoto.setImageDrawable(photo);

            // 재사용.반드시 호출.
            ta.recycle();

            // OnImageClickListerner 이벤트 발생시 전달할 데이터
            person = new PersonData(name, age, photo);
       }

        imagephoto.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View view) {
               if (imageClickListener != null) {
                   //컨테이너 위젯으로 이벤트 발생
                   //부모로 이벤트 발생시킴.

                   imageClickListener.onImageClick(PersonView.this, person);
               }
           }
       });

     // 첫번째 자식에 값 설정.


     // 두번째 자식에 값 설정.


     // 세번째 자식에 값 설정.



    }
}



                 