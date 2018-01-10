package com.example.suv12.studentcustomlistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by suv12 on 2018-01-01.
 */

// 1. extends ArrayAdapter<PersonData> 상속받기
public class StudentAdapter extends ArrayAdapter<ModelStudent> {

    int uniquekey = 1;

    // 3-1. ArrayList<객체> 선언
    ArrayList<ModelStudent> items;

    // 2. ArrayList<PersonData> items, 생성자가 ArrayList 를 매개변수로 받도록 변경
    public StudentAdapter(@NonNull Context context, int resource, @NonNull ArrayList<ModelStudent> items) {
        super(context, resource, items);

        // 3-2. 매개변수로 넘어온 ArrayList 와 현재 필드의 ArrayList 를 연결
        this.items = items;
    }

    // 4. Code > Override Methods 에서 getView 를 찾아 생성
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        // 5. convertView 가 null 일 때 인플레이션
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view_student, parent, false);

            // 6. 생성된 뷰홀더에 커스텀 뷰의 뷰들을 연결
            TextView txt_Name = convertView.findViewById(R.id.txt_Name);
            TextView txt_Num = convertView.findViewById(R.id.txt_Num);
            TextView txt_Dept = convertView.findViewById(R.id.txt_Dept);

            // 7.
            holder = new ViewHolder();
            holder.txt_Name = txt_Name;
            holder.txt_Num = txt_Num;
            holder.txt_Dept = txt_Dept;

            // 8.
            convertView.setTag(holder);

        } else {
            // 9. 재활용
            holder = (ViewHolder) convertView.getTag();
        }

        // 10. 데이터
        ModelStudent student = getItem(position);

        // 11 . 데이터 설정
        holder.txt_Name.setText(student.getName());
        holder.txt_Num.setText(student.getNumber());
        holder.txt_Dept.setText(student.getDepartment());

        return convertView;
    }

    // 6-1. 뷰 홀더 클래스 만들기
    private static class ViewHolder {
        private TextView txt_Name;
        private TextView txt_Num;
        private TextView txt_Dept;
    }

    // Adapter 에서 ArrayList 에 add 하는 메서드
    public void addItem(String name, String number, String department) {
        ModelStudent student = new ModelStudent();

        student.setName(name);
        student.setNumber(number);
        student.setDepartment(department);
        student.setUniquekey(uniquekey);
        uniquekey++;

        items.add(student);
    }
}
