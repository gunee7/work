package com.example.suv12.customlistview;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter();

        // 리스트뷰 참조 및 Adapter 달기
        listview = (ListView) findViewById(R.id.listView);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_box_black_24dp),
                "Box", "Account Box Black 24dp");
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_account_circle_black_24dp),
                "Circle", "Account Circle Black 24dp");
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ic_assignment_ind_black_24dp),
                "Ind", "Assignment Ind Black 24dp");

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);

                String title = item.getTitle();
                String desc = item.getDesc();
                Drawable icon = item.getIcon();

                Toast.makeText(getApplicationContext(), icon + ", " + title + ", " + desc, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
