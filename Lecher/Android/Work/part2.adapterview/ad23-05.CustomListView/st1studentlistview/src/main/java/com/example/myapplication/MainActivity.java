package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //위젯 선언
    private ListView listView1;
    private ArrayAdapter<String> adapter;
    private List<String> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView1  = findViewById(R.id.list_view);

        //위젯 리스너 설정
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });


        data = new ArrayList<>();
        data.add("aaaaaa");
        data.add("bbbbbb");
        data.add("cccccc");

        //adapter 만들기
        adapter = new ArrayAdapter<String>( MainActivity.this, android.R.layout.simple_list_item_1, data);


        // listview
        listView1.setAdapter(adapter);





    }
}
