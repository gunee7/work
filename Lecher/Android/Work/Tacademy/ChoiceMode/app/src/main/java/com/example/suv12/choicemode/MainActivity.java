package com.example.suv12.choicemode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listV;
    ArrayAdapter<String> mAdapter;

    Button btn_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV = findViewById(R.id.listV);

        String[] items = getResources().getStringArray(R.array.list_item);
        List<String> lists = new ArrayList<>(Arrays.asList(items));

        // single choice mode
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, lists);
        listV.setAdapter(mAdapter);
        listV.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        btn_del = findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listV.getChoiceMode() == ListView.CHOICE_MODE_SINGLE) {
                    int position = listV.getCheckedItemPosition();
                    String item = (String) listV.getItemAtPosition(position);
                    mAdapter.remove(item);
                    listV.clearChoices();
                }
            }
        });

        // multiple choice mode
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, lists);
        listV.setAdapter(mAdapter);
        listV.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        btn_del = findViewById(R.id.btn_del);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listV.getChoiceMode() == ListView.CHOICE_MODE_MULTIPLE) {
                    SparseBooleanArray array = listV.getCheckedItemPositions();
                    ArrayList<String> select = new ArrayList<>();

                    for (int i = 0; i < array.size(); i++) {
                        int position = array.keyAt(i);
                        if (array.get(position)) {
                            select.add((String) listV.getItemAtPosition(position));
                        }
                    }

                    for (String s : select) {
                        mAdapter.remove(s);
                        listV.clearChoices();
                    }
                }
            }
        });

    } //onCreate()
}
