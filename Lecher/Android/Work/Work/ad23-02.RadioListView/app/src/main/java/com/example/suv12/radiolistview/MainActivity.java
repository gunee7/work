package com.example.suv12.radiolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> items;

    Button btn_add;
    Button btn_modify;
    Button btn_delete;

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, items);

        listView = findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = adapter.getCount();
                items.add("List" + (count + 1));
                adapter.notifyDataSetChanged();
                listView.smoothScrollToPosition(adapter.getCount());
            }
        });

        btn_modify = findViewById(R.id.btn_modify);
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = adapter.getCount();

                if (count > 0) {
                    int checked = listView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        items.set(checked, checked + 1 + "번 수정");
                    }
                }

                adapter.notifyDataSetChanged();
            }
        });

        btn_delete = findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = adapter.getCount();

                if (count > 0) {
                    int checked = listView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        items.remove(checked);
                    }
                }

                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
    }
}
