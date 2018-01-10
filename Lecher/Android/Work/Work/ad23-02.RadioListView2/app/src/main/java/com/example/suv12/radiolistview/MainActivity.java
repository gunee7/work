package com.example.suv12.radiolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> items;
    private ArrayAdapter<String> adapter;

    private Button btn_Add;
    private Button btn_Modify;
    private Button btn_Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼 찾기
        btn_Add = findViewById(R.id.btn_Add);
        btn_Modify = findViewById(R.id.btn_Modify);
        btn_Delete = findViewById(R.id.btn_Delete);

        // 버튼 핸들러 설정
        BtnClick click = new BtnClick();
        btn_Add.setOnClickListener(click);
        btn_Modify.setOnClickListener(click);
        btn_Delete.setOnClickListener(click);

        // 데이터 생성
        items = new ArrayList<>();

        // 어댑터 만들기 & 데이터 연결 ( 데이터(items)를 어댑터에 연결 )
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);

        // 리스트 뷰 찾기 & 어댑터 연결 ( 리스트 뷰는 데이터를 가지고 있지 않다. 화면에 뿌려주는 용도로 활용된다. )
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

    }

    private class BtnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int count, checked;

            switch (v.getId()) {

                // 추가 버튼
                case R.id.btn_Add:

                    count = adapter.getCount(); // 데이터 전체 개수 ( 데이터 없을 시 count = 0 )

                    items.add("item " + /*String.valueOf*/(count + 1)); // 데이터 추가

                    adapter.notifyDataSetChanged(); // 변경 사항 적용

                    listView.smoothScrollToPosition(items.size() - 1); // 데이터 추가 시 자동 스크롤

                    break;

                // 수정 버튼
                case R.id.btn_Modify:

                    count = adapter.getCount();

                    checked = listView.getCheckedItemPosition(); // 리스트 뷰에서 선택된 위치 ( Position 은 0부터 시작 )

                    if (checked > -1 && checked < count) {
                        items.set(checked, /*String.valueOf*/(checked + 1) + "번째 수정 완료"); // 선택된 데이터 수정
                    }

                    adapter.notifyDataSetChanged();

                    break;

                // 삭제 버튼
                case R.id.btn_Delete:

                    count = adapter.getCount();

                    checked = listView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        items.remove(checked); // 선택된 데이터 삭제
                    }

                    adapter.notifyDataSetChanged();

                    listView.clearChoices(); // 체크 표시 없애기

                    break;
            }
        }
    }
}
