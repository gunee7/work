package com.example.suv12.checkedlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 7. 위젯 선언
    private ListView listView       = null;

    // 8-2. List<ModelPerson> lists 선언
    private List<ModelPerson> lists = null;

    // 8-6.
    private int[] images = { R.drawable.sample_0
                           , R.drawable.sample_1
                           , R.drawable.sample_2
                           , R.drawable.sample_3
                           , R.drawable.sample_4
                           , R.drawable.sample_5
                           , R.drawable.sample_6
                           , R.drawable.sample_7 };

    // 9-1.
    private AdapterPerson adapter = null;

    // 11-1
    private EditText edit_inputt;
    private Button   btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 7-1. 위젯 찾기
        listView = findViewById(R.id.listView);

        // 8. 데이터 만들기
        //  8-1. lists 필드에 선언
        //  8-3. makeData() 메서드 만들기
        lists = makeData();

        // 9. adapter 필드에 선언 후 만들기
        adapter = new AdapterPerson(MainActivity.this, R.layout.view_person, lists);

        // 10. listView 와 adapter 연결
        listView.setAdapter(adapter);

        // 11.
        View headerView = LayoutInflater.from( MainActivity.this ).inflate( R.layout.header_list_item,null );
        edit_inputt = headerView.findViewById( R.id.edit_input );
        btn_search  = headerView.findViewById( R.id.btn_search );
        listView.addHeaderView( headerView );

        // 12
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_inputt.getText().toString();
                if( !( text.isEmpty() ) ){
                    Toast.makeText( MainActivity.this, text, Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }

    // 8-4.
    private List<ModelPerson> makeData() {
        List<ModelPerson> items = new ArrayList<>();

        ModelPerson person;
        for (int i = 0; i < 20; i++) {
            person = new ModelPerson();
                                                             // 8-5 필드에 이미지 배열 만들기
            person.setPhoto ( getResources().getDrawable( images[i % images.length], null ) );
            person.setName  ( "name " + i );
            person.setAge   ( i + ""      );
            person.setCheck ( false       );
            items.add(person);
        }

        return items;
    }
}
