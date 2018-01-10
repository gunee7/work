package com.example.suv12.customadapterlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<People> mData;
    private CustomAdapter mAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 데이터 준비
        initData();

        // 2. Adapter 준비
        initAdapter();

        // 3. ListView 에 Adapter 를 장착
        initListView();

    }

    private void initListView() {
        mListView = findViewById(R.id.listV);
        mListView.setAdapter(mAdapter);

    }

    private void initAdapter() {
        mAdapter = new CustomAdapter(getApplicationContext(), mData);
    }

    private void initData() {
        mData = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            People data;

            if (i % 3 == 0)
                data = new People(R.drawable.han2, "☆ 한지민 ☆", "010-3333-3333");
            else if (i % 3 == 1)
                data = new People(R.drawable.han1, "♡ 한지민 ♡", "010-1111-1111");
            else
                data = new People(R.drawable.han3, "♧ 한지민 ♧", "010-2222-2222");

            mData.add(data);
        }
    }
}
