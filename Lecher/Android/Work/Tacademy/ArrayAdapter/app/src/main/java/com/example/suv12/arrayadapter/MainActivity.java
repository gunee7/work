package com.example.suv12.arrayadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ListView listV;
    ArrayAdapter<Person> mAdapter;

    TextView txt_message;
    EditText edt_input;
    Button btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1);
        listV = findViewById(R.id.listV);
        listV.setAdapter(mAdapter);

        // 아이템 선택 TextView 표시
        txt_message = findViewById(R.id.txt_message);
        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person) listV.getItemAtPosition(position);
                txt_message.setText(p.name);
            }
        });

        // 아이템 추가
        edt_input = findViewById(R.id.edt_input);
        btn_add = findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edt_input.getText().toString();
                if (text != null && !text.equals("")) {
                    mAdapter.add(makePerson(text));
                    edt_input.setText("");
                    listV.smoothScrollToPosition(mAdapter.getCount() - 1);
                }
            }
        });
    }

    public Person makePerson(String text) {
        Person p = new Person();
        p.name = text;
        p.age = 20 + new Random().nextInt(40);
        return p;
    }
}
