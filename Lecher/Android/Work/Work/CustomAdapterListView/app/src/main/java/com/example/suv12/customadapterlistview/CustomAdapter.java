package com.example.suv12.customadapterlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suv12 on 2018-01-02.
 * <p>
 * People 데이터를 다루는 어댑터
 */

public class CustomAdapter extends BaseAdapter {
    private List<People> mData;
    private LayoutInflater inflater;

    /**
     * 생성자를 작성하고 레이아웃을 가져올 때 필요한 context 와 관리할 Data 를 인자로 받는다
     *
     * @param context 리소스에 접근하기 위해 필요함
     * @param mData
     */
    public CustomAdapter(Context context, List<People> mData) {
        this.mData = mData;
        inflater = LayoutInflater.from(context);
    }

    // 리스트 뷰에 표시할 데이터의 개수
    @Override
    public int getCount() {
        return mData.size();
    }

    // 해당 포지션에 위치하는 아이템 ( position 번째의 item )
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    // 해당 포지션에 위치하는 아이템 ID ( 각 item 의 ID )
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 각 아이템의 레이아웃을 결정 ( 각 position 번째의 item 을 보여줄 View )
     *
     * @param position    포지션
     * @param convertView 포지션의 View
     * @param parent      부모
     * @return 완성된 레이아웃
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;

        // 1. 레이아웃 구성
        // convertView 처음 로딩 될 때 초기화 과정을 거쳐서 viewHolder 에 저장
        if (convertView == null) {
            // layout 을 가져오기
            convertView = inflater.inflate(R.layout.people_item, parent, false);

            // 각 View 를 소스로 연결
            ImageView img_main = convertView.findViewById(R.id.img_main);
            TextView txt_name = convertView.findViewById(R.id.txt_name);
            TextView txt_phoneNumber = convertView.findViewById(R.id.txt_phoneNumber);

            // ViewHolder 를 생성 후, 가져온 View 를 연결
            viewholder = new ViewHolder();
            viewholder.image = img_main;
            viewholder.name = txt_name;
            viewholder.phone = txt_phoneNumber;

            // ViewHolder 를 convertView 의 태그로 저장
            convertView.setTag(viewholder);
        } else {
            // convertView 가 다시 로딩 될 때에는 viewHolder 에서 꺼내와서 재사용
            // 이점 : 속도가 빠르다
            viewholder = (ViewHolder) convertView.getTag();
        }

        // 2. 레이아웃에 데이터를 바인딩
        People people = (People) getItem(position);
        viewholder.image.setImageResource(people.getImageResourceId());
        viewholder.name.setText(people.getName());
        viewholder.phone.setText(people.getPhoneNumber());

        // 3. 완성된 View 를 리턴
        return convertView;
    }

    // 내부 클래스는 static 을 붙여 사용하자
    static class ViewHolder {
        ImageView image;
        TextView name;
        TextView phone;
    }
}
