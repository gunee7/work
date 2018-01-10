package com.example.suv12.baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 생성
        List<MyItem> myData = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0)
                myData.add(new MyItem(R.drawable.han1, "한지민♡", "대한민국\n여배우\n한지민입니다"));
            else if (i % 3 == 1)
                myData.add(new MyItem(R.drawable.han3, "한지민☆", "대한민국\n여배우\n한지민입니다"));
            else
                myData.add(new MyItem(R.drawable.han2, "한지민♧", "대한민국\n여배우\n한지민입니다"));
        }

        // 아답터 만들기 & 데이터 연결
        MyAdapter adapter = new MyAdapter(MainActivity.this, myData);

        ListView listV = findViewById(R.id.listV);                            GridView gridV = findViewById(R.id.gridV);
        listV.setAdapter(adapter);                                            gridV.setAdapter(adapter);
    }
}
