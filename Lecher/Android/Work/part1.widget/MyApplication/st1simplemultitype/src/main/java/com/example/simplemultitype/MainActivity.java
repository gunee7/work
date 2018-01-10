package com.example.simplemultitype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listview1;
    private List<ModelItem> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위젯 찾기
        listview1 = findViewById(R.id.listview1);
        //위젯 설정 : 리스너 설정 . 없음.

        //데이터 만들기
        list = makeData();
        //adapter만들기

        //listview와 adapter 연결하기
    }

    private List<ModelItem> makeData() {
    }

    public ListView getListview1() {
        return listview1;
    }

    public void setListview1(ListView listview1) {
        this.listview1 = listview1;
    }

    public List<ModelItem> getList() {
        return list;
    }

    public void setList(List<ModelItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MainActivity{" +
                "listview1=" + listview1 +
                ", list=" + list +
                '}';
    }

    public MainActivity(List<ModelItem> list) {
        this.list = list;
    }
}
