package com.example.suv12.itemview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listV;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new MyAdapter(this);
        mAdapter.setOnAdapterLikeListener(new MyAdapter.OnAdapterLikeListener() {

            @Override
            public void onAdapterLike(MyAdapter adapter, View view, ItemData data) {
                Toast.makeText(MainActivity.this, "Like Item Click", Toast.LENGTH_SHORT).show();
            }
        });

        listV = findViewById(R.id.listV);
        listV.setAdapter(mAdapter);
        initData();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            ItemData data = new ItemData();
            data.imageId = R.drawable.icon01;
            data.name = "name " + i;
            data.desc = "desc " + i;
            data.likeCount = i;
            mAdapter.add(data);
        }
    }
}
