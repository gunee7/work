package com.example.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017-12-22.
 */

public class personView extends RelativeLayout{

    private ImageView imagePhoto, imageCheck;
    private TextView textAge, textName;

    public personView(Context context) {
        super(context);
        init (context, null,0);
    }


    public personView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init (context, attrs,0);
    }


    public personView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       init (context, attrs,defStyleAttr);
    }



    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        // Layout 관련 속성 설정.


        // inflation 하기.

        LayoutInflater inflater = LayoutInflater.from( context);
        inflater.inflate( R.layout.view_person, this, true );

        textName = this.findViewById(R.id.text_name);
        textAge = this.findViewById(R.id.text_age);
        imagePhoto = this.findViewById(R.id.image_photo);
        imageCheck = this.findViewById(R.id.image_check);


        // CustomView 속성값 가져오기. 디자인에서
        if( attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.PersonView, defStyleAttr, 0);
            String name = ta.getString(R.styleable.PersonView_name);
            int    age = ta.getInt(R.styleable.PersonView_age, -1);
            Drawable photo = ta.getDrawable(R.styleable.PersonView_photo);

            ta.recycle(); // styleable 재사용

            //자식에 값 설정
            textName.setText(name);
            textAge.setText(age+"");
            imagePhoto.setImageDrawable(photo);

        }
    }

    // 인터페이스 정의 : image
}
