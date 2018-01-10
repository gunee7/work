package com.example.suv12.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


/**
 * Created by suv12 on 2018-01-01.
 */

public class MyAdapter extends BaseAdapter {

    private List<MyData> mData;
    private Context mContext;

    public MyAdapter(Context context, List<MyData> data) {
        mContext = context;
        mData = data;
    }

    // mData 개수
    @Override
    public int getCount() {
        return mData.size();
    }

    // position 번째 데이터 리턴
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // position 번째 데이터 id 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 최초 로드시
        if (convertView == null) {
            // 레이아웃을 가져오는 객체
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }

        // 데이터를 연결 할 View
        ImageView imageView = convertView.findViewById(R.id.img1);
        TextView textView1 = convertView.findViewById(R.id.txt_title);
        TextView textView2 = convertView.findViewById(R.id.txt_desc);

        // 데이터
        MyData myData = (MyData) getItem(position);

        // 데이터 설정
        imageView.setImageResource(myData.getImageResource());
        textView1.setText(myData.getTitle());
        textView2.setText(myData.getDescription());

        return convertView;
    }
}
