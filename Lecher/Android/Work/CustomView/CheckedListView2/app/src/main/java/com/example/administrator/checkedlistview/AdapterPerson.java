package com.example.administrator.checkedlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018-01-10.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    private Context context;
    private List<ModelPerson> lists;


    public AdapterPerson(@NonNull Context context, int resource, @NonNull List<ModelPerson> objects) {
        super( context, resource, objects );
        this.context = context;
        this.lists   = objects;
    }

    @NonNull
    @Override
    public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        return getViewClass( position, convertView, parent );
    }

    public View getViewClass( int position, @Nullable View convertView, @NonNull ViewGroup parent ) {
        // xml  ->  class  -> getView
        // getView 에서 하던 inflation 을 class 로 이전하기 위해 ViewPerson 만들기
        // 리스트뷰 의 row 는 ViewPerson 이다
        ViewPerson rowView = ( ViewPerson ) convertView;

        if( rowView == null ){
            rowView = new ViewPerson( parent.getContext() );
        }

        // 데이터 ViewPerson 에 데이터 설정
        ModelPerson person = lists.get( position );
        rowView.setPerson( person );

        return rowView;
    }
}
