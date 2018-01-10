package com.example.suv12.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edt1;
    private Button btnAdd;

    ArrayAdapter adapter;
    List<String> listData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt1 = findViewById(R.id.edt1);
        btnAdd = findViewById(R.id.btnAdd);

        // 데이터 생성
        String[] data = getResources().getStringArray(R.array.data);
        listData = new ArrayList<>(Arrays.asList(data));

        // 아답터 생성 & 데이터 연결
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listData);

        // 리스트뷰에 아답터 연결
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edt1.getText().toString();
                if (!edt1.getText().toString().equals(""))
                    adapter.add(input);
                listView.smoothScrollToPosition(listData.size() - 1); // 데이터 추가시 자동 스크롤
                adapter.notifyDataSetChanged(); // 변경 사항 적용
            }
        });
    }
}
