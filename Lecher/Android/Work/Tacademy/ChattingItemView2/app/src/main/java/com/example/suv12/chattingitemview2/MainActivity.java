package com.example.suv12.chattingitemview2;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    ListView listV;
    EditText messageView;
    RadioGroup messageType;
    ChattingAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listV = findViewById(R.id.listV);
        messageView = findViewById(R.id.edt_messageView);
        messageType = findViewById(R.id.radio_groupView);

        mAdapter = new ChattingAdapter();
        listV.setAdapter(mAdapter);
        listV.setDivider(null);

        Button btn_insert = findViewById(R.id.btn_insert);
        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageView.getText().toString();

                if (!TextUtils.isEmpty(message)) {

                    switch (messageType.getCheckedRadioButtonId()) {

                        case R.id.radio_send: {
                            SendData sendData = new SendData();
                            sendData.setMessage(message);
                            sendData.setPhoto(ContextCompat.getDrawable(MainActivity.this, R.drawable.han1));
                            mAdapter.add(sendData);
                            break;
                        }

                        case R.id.radio_receive: {
                            ReceiveData receiveData = new ReceiveData();
                            receiveData.setMessage(message);
                            receiveData.setPhoto(ContextCompat.getDrawable(MainActivity.this, R.drawable.han3));
                            mAdapter.add(receiveData);
                            break;
                        }

                        case R.id.radio_date: {
                            DateData dateData = new DateData();
                            dateData.setMessage(message);
                            mAdapter.add(dateData);
                            break;
                        }

                    }
                }
            }
        });
    }
}
