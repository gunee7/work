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
 * Created by suv12 on 2017-12-31.
 */

public class MyAdapter extends BaseAdapter {

    private Context mContex;
    private List<MyItem> mData;
    private LayoutInflater minflater;

    public MyAdapter(Context context, List<MyItem> data) {
        mContex = context;
        mData = data;

        minflater = LayoutInflater.from(mContex);
    }

    // 아이템의 개수
    @Override
    public int getCount() {
        return mData.size();
    }

    // position 번째 아이템 리턴
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // position 번째 아이템 id 리턴
    @Override
    public long getItemId(int position) {
        return position;
    }

    // 아이템 한 개의 View 를 완성 하는 곳
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) { // 최초 로드 할 때
            // 레이아웃을 가져오게 하는 객체
            convertView = minflater.inflate(R.layout.item_list, parent, false);

            // 데이터를 연결 할 View
            ImageView img_han = convertView.findViewById(R.id.img_han);
            TextView txt_title = convertView.findViewById(R.id.txt_title);
            TextView txt_desc = convertView.findViewById(R.id.txt_desc);

            holder = new ViewHolder();
            holder.img_han = img_han;
            holder.txt_title = txt_title;
            holder.txt_desc = txt_desc;

            convertView.setTag(holder);

        } else {
            // 재활용
            holder = (ViewHolder) convertView.getTag();

        }

        // 데이터
        MyItem item = (MyItem) getItem(position);

        // 데이터 설정
        holder.img_han.setImageResource(item.getImageRes());
        holder.txt_title.setText(item.getTitle());
        holder.txt_desc.setText(item.getDescription());

        return convertView;
    }

    private static class ViewHolder {
        ImageView img_han;
        TextView txt_title;
        TextView txt_desc;
    }
}
