package com.example.suv12.checklistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 빈 데이터 리스트 생성
        final ArrayList<String> items = new ArrayList<>();

        // 어댑터 만들기 & 데이터 연결 & 아이템 View 를 선택 (multipleChoice) 가능하도록 설정
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, items);

        // 리스트 생성 & 어댑터 연결
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // 추가 버튼 이벤트 처리
        Button btn_Add = findViewById(R.id.btn_Add);
        btn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count;
                count = adapter.getCount();

                // 아이템 추가
                items.add("List " + /*Integer.toString*/(count + 1));

                // 리스트 뷰에 변경 사항 적용
                adapter.notifyDataSetChanged();

                // 마지막 위치로 자동 스크롤
                listView.smoothScrollToPosition(items.size() - 1);

            }
        });

        // 삭제 버튼 이벤트 처리
        Button btn_Delete = findViewById(R.id.btn_Delete);
        btn_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // SparseBooleanArray 는 점수 값들을 boolean 값들로 매핑 시키는 기능을 하는 클래스입니다.
                // 여기서 정숫값은 ListView 아이템의 위치(position)로 사용하고, boolean 값은 선택(Checked) 여부로 사용됩니다.
                // SparseBooleanArray 의 get () 함수를 사용하면 인자로 입력되는 position 의 상태가 Checked 인지 확인할 수 있습니다
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions();

                int count = adapter.getCount();

                for (int i = count - 1; i >= 0; i--) {
                    if (checkedItems.get(i)) {
                        items.remove(i); // 데이터를 삭제할 땐 "마지막 아이템부터" 루프를 실행해야 한다는 것을 꼭 명심
                    }
                }

                listView.clearChoices();

                adapter.notifyDataSetChanged();

            }
        });

        // 전체 선택 이벤트 처리
        Button btn_All = findViewById(R.id.btn_All);
        btn_All.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = adapter.getCount();

                for (int i = 0; i < count; i++) {
                    listView.setItemChecked(i, true); // 아이템 선택을 위해 호출하는 함수는 setItemChecked()
                }                                            // setItemChecked() 함수는 입력받은 position 에 대해서만 선택 여부를 설정

            }
        });
    }
}
