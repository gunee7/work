package com.example.suv12.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;

    Button button;
    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 생성
        String[] items = getResources().getStringArray(R.array.items); // <string-array name="items">
        listItems = new ArrayList<>(Arrays.asList(items));

        // 어댑터 생성 & 데이터 연결
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);

        // 리스트뷰에 어댑터 연결
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter); // 어댑터가 리스트뷰에 데이터를 공급

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        // add 버튼
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();

                if (!editText.getText().toString().equals(""))
                    adapter.add(input); // 리스트뷰가 아닌 어댑터에 데이터 추가!!

                listView.smoothScrollToPosition(listItems.size() - 1); // 데이터 추가시 맨 밑으로 자동 스크롤
                adapter.notifyDataSetChanged(); // 변경 사항 적용
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String click = ((TextView) view).getText().toString(); // 클릭한 곳 문자열 가져오기
                textView.setText(click);

                String text = (String) listView.getItemAtPosition(position); // 리스트뷰에 클릭한 곳 위치(방 번호)
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
