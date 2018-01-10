package com.example.suv12.headerviewfooterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listV;
    ArrayAdapter<ItemData> mAdapter;

    ImageView headerIconView;
    TextView headerTitleView;

    ImageView footerIconView;
    TextView footerTitleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV = findViewById(R.id.listV);

        View headerV = getLayoutInflater().inflate(R.layout.header_layout, null);
        headerIconView = headerV.findViewById(R.id.img_icon);
        headerTitleView = headerV.findViewById(R.id.txt_title);
        listV.addHeaderView(headerV, null, false);

        View footerV = getLayoutInflater().inflate(R.layout.footer_layout, null);
        footerIconView = footerV.findViewById(R.id.img_icon);
        footerTitleView = footerV.findViewById(R.id.txt_title);
        listV.addFooterView(footerV, null, false);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listV.setAdapter(mAdapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemData text = (ItemData) listV.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "position: " + position + ", text: " + text, Toast.LENGTH_SHORT).show();
            }
        });

        initData();
    }

    private void initData() {
        ItemData data;
        for (int i = 0; i < 10; i++) {
            data = new ItemData();
            data.setName("item " + i);
            mAdapter.add(data);
        }
    }
}
