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

        List<MyData> data = new ArrayList<>();

        for (int i = 0; i < 102; i++) {
            if (i % 3 == 0)
                data.add(new MyData(R.drawable.han2, (i + 1) + "", "대한민국"));
            else if (i % 3 == 1)
                data.add(new MyData(R.drawable.han3, (i + 1) + "", "여배우"));
            else
                data.add(new MyData(R.drawable.han1, (i + 1) + "", "한지민"));
        }

        MyAdapter adapter = new MyAdapter(this, data);

//        ListView listV = findViewById(R.id.listV);
//        listV.setAdapter(adapter);

        GridView gridV = findViewById(R.id.gridV);
        gridV.setAdapter(adapter);
    }
}
