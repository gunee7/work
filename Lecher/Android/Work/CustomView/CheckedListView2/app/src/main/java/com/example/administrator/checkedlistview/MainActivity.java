package com.example.administrator.checkedlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView       = null;
    private List<ModelPerson> lists = null;
    private AdapterPerson adapter   = null;

    private int[] images = {
              R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById( R.id.listView );

        lists = initData();

        adapter = new AdapterPerson( MainActivity.this, R.layout.view_person, lists );

        listView.setAdapter( adapter );
    }

    private List<ModelPerson> initData() {
        List<ModelPerson> lists = new ArrayList<>();
        ModelPerson person;

        for ( int i = 0; i < 20; i++ ) {
            person = new ModelPerson();
            person.setImage_photo( getResources().getDrawable( images[ i % images.length ], null ) );
            person.setText_name( "item " + i );
            person.setText_age( i + "" );
            person.setImage_check( false );
            lists.add( person );
        }

        return lists;
    }
}
