package com.example.suv12.paginglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private ListView listV;
    private List<ModelItem> lists;

    private AdapterItem adapter;

    private int[] imageIDs = { R.drawable.icon01
                             , R.drawable.icon02
                             , R.drawable.icon03
                             , R.drawable.icon04
                             , R.drawable.icon05
                             , R.drawable.icon06 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listV = findViewById( R.id.listV );

        // 데이터 만들기
        lists = initData();

        // 아답터 생성
        adapter = new AdapterItem(MainActivity.this, R.layout.customvie_item, lists);

        // 아답터 연결
        listV.setAdapter(adapter);
    }

    private List<ModelItem> initData() {
        lists = new ArrayList<ModelItem>();

        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            ModelItem item = new ModelItem();
            item.setIconItem( getResources().getDrawable(imageIDs[i % imageIDs.length], null) );
            item.setDataItem01( "name" + i );
            item.setDataItem03( 20 + r.nextInt(3000) + "" );
            item.setDataItem02( getRandString() );
            lists.add(item);
        }

        return lists;
    }

    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random()*10000); i++) {
            //char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf( (char) ((Math.random() * 26) + 97) );
        }
        return str;
    }
}
