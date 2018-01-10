package com.example.suv12.checkedlistview;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suv12 on 2018-01-08.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    // 1. context 추가, lists 추가
    private Context context         = null;
    private List<ModelPerson> lists = null;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super(context, resource, objects);

        // 2.
        this.context = context;
        this.lists   = objects;
    }

    // 4. getView Override 해서 사용
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

//        // 4.
//        ViewHolder holder;
//
//        // 5.
//        View rowView = convertView;
//
//        if (rowView == null) {
//
//            rowView = new ViewPerson( context,null,0 );
//
//            holder = new ViewHolder();
//
//            holder.image_photo = rowView.findViewById( R.id.image_photo );
//            holder.text_name   = rowView.findViewById( R.id.text_name   );
//            holder.text_age    = rowView.findViewById( R.id.text_age    );
//            holder.image_check = rowView.findViewById( R.id.image_check );
//
//            rowView.setTag(holder);
//
//        } else {
//
//            holder = (ViewHolder) rowView.getTag();
//
//        }
//
//        // 6.
//        ModelPerson person = lists.get(position);
//
//        holder.image_photo.setImageDrawable( person.getImage_photo() );
//        holder.text_name  .setText         ( person.getText_name()   );
//        holder.text_age   .setText         ( person.getText_age()    );
//        holder.image_check.setChecked      ( person.getImage_check() );
//
//        return rowView; // 7. 리스트뷰 추가 등 작업하러 MainActivity 로 이동 ...

        return getViewWidjet( position, convertView, parent );
    }

    // d-3
    public View getViewWidjet(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // e.
        ViewHolder holder;

        // f.
        View rowView = convertView;

        if ( rowView == null ) {

            rowView = new ViewPerson( context,null,0 );

            holder = new ViewHolder();

            holder.image_photo = rowView.findViewById( R.id.image_photo );
            holder.text_name   = rowView.findViewById( R.id.text_name   );
            holder.text_age    = rowView.findViewById( R.id.text_age    );
            holder.image_check = rowView.findViewById( R.id.image_check );
            holder.rLayout     = rowView.findViewById( R.id.rLayout     );

            rowView.setTag( holder );

        } else {

            holder = ( ViewHolder ) rowView.getTag();

        }

        // g. 값 설정 후 --> 체크박스 클릭 이벤트 달러 ViewPerson 으로 이동
        ModelPerson person = lists.get( position );

        holder.image_photo.setImageDrawable( person.getPhoto() );
        holder.text_name  .setText         ( person.getName()  );
        holder.text_age   .setText         ( person.getAge()   );
        holder.image_check.setChecked      ( person.isCheck()  );

        // i.
        if( lists.get( position ).isCheck() ) {
            holder.rLayout.setBackgroundColor( Color.MAGENTA );
        }
        else {
            holder.rLayout.setBackgroundColor( Color.TRANSPARENT );
        }

        holder.image_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean newState = !lists.get( position ).isCheck();
                lists.get( position ).setCheck( newState );
                if( newState ) {
                    ((View)v.getParent()).setBackgroundColor( Color.MAGENTA );
                }
                else {
                    ((View)v.getParent()).setBackgroundColor( Color.TRANSPARENT );
                }

                Log.d( "getViewWidget", getItem( position ).toString() );
            }
        });

        return rowView;
    }

    // 3. ViewHolder class 만들기
    private class ViewHolder {
        ImageView image_photo;
        TextView  text_name;
        TextView  text_age;
        CheckBox  image_check;
        RelativeLayout rLayout;
    }
}
