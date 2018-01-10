package com.example.suv12.checkedlistview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ViewPerson extends RelativeLayout {

    // h. 인터페이스 정의
    public static interface OnClickListener {
        public void onClick( ViewPerson viewPerson, ModelPerson modelPerson );
    }

    // h-1. 인터페이스 리스너 선언
    private OnClickListener checkedListener;

    // h-2.
    public void setOnClickListener( OnClickListener listener ) {
        this.checkedListener = listener;
    }

    // a.
    ImageView image_photo;
    TextView  text_name;
    TextView  text_age;
    CheckBox  image_check;

    // h-5. ModelPerson 데이터 선언
    ModelPerson person;

    public ModelPerson getPerson() {
        return person;
    }

    public void setPerson( ModelPerson person ) {
        this.person = person;

        // h-6. 추가
        image_photo.setImageDrawable( person.getPhoto()          );
        text_name  .setText         ( person.getName()           );
        text_age   .setText         ( person.getAge() + ""       );
        this.setChecked             ( person.isCheck() /* h-7 */ );
    }

    // h-8.
    boolean isChecked;
    public void setChecked( boolean checked ) {
        if( isChecked != checked ) {
            this.isChecked = checked;
            drawCheck();
        }
    }

    // h-9. drawCheck() 작성하고 AdapterPerson 으로 이동
    private void drawCheck() {
        image_check.setChecked( this.isChecked );
        if( this.isChecked ) {
            this.setBackgroundColor( Color.MAGENTA );
        }
        else {
            this.setBackgroundColor( Color.TRANSPARENT );
        }

        Log.d("ViewPerson", isChecked + "" );
    }

    // b.
    public ViewPerson(Context context) {
        this( context, null, 0 );
    }

    // c.
    public ViewPerson(Context context, AttributeSet attrs) {
        this( context, attrs, 0 );
    }

    // d.
    public ViewPerson(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // d-1.
        // 커스텀뷰 디자인 파일 inflation 하기.
        // inflation 이란 xml 을 자바 인스턴스로 바꾸는 것.
        // res/layout/view_person.xml.
        LayoutInflater.from( context ).inflate( R.layout.view_person,this,true );

        // d-2. AdapterPerson 으로 이동
        // 위젯 찾기.
        image_photo = findViewById( R.id.image_photo );
        text_name   = findViewById( R.id.text_name   );
        text_age    = findViewById( R.id.text_age    );
        image_check = findViewById( R.id.image_check );

         // h-3.
        image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                            // h-4.
                checkedListener.onClick( ViewPerson.this, person );
            }
        });
    }
}
