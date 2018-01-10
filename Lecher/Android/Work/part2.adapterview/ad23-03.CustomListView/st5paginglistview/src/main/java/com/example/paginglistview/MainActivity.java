package com.example.paginglistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    ListView listView1;

    EditText edit_input;
    Button btn_search;

    // Adapter 선언
    AdapterItem adapter;
    private List<ModelItem> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView1 = findViewById(R.id.listView1);

        // 데이터 만들기
        lists = initData();

        // adapter 생성
        adapter = new AdapterItem(MainActivity.this, R.layout.customview_item, lists);

        // adapter 연결
        listView1.setAdapter( adapter );

        // adapter scroll 리스너 설정
        listView1.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if( totalItemCount == firstVisibleItem + visibleItemCount ){
                    // 바닥이다.
                    // 데이터 추가.
                }
            }
        });

    }

    private List<ModelItem> initData() {
        lists = new ArrayList<ModelItem>();

        Random r = new Random();
        for(int i=0; i<20; i++){
            ModelItem person = new ModelItem();
            person.setIconItem( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );
            person.setDataItem01( "name " + i );
            person.setDataItem03( 20 + r.nextInt( 3000) + "");
            person.setDataItem02( getRandString() );
            lists.add( person );
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


    private int [] imageIds = {
              R.drawable.icon01
            , R.drawable.icon02
            , R.drawable.icon03
            , R.drawable.icon04
            , R.drawable.icon05
            , R.drawable.icon06
    };
}
