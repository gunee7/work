package com.example.tabpager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentTab2 extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;



    // 위젯 선언. 필드에

    private List<String> mData = null;
    private ListView     mlistView1 = null;
    private ArrayAdapter<String> mAdapter = null;

    private View inflatedView = null;
    private Button btnAdd = null;
    private Button btbtn_modifynAdd = null;
    private Button btn_delete = null;

    private EditText editText1 = null;


    public FragmentTab2() {

    }



    public static FragmentTab2 newInstance(String param1, String param2) {
        FragmentTab2 fragment = new FragmentTab2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflatedView = inflater.inflate(R.layout.fragment_tab2, container, false);
        return inflatedView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ListView찾기
        mlistView1 = inflatedView.findViewById(R.id.list_view);
        mData = makeData();
        //ArrayAdapter 생성

        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mData);
        ///ListView와 ArrayAdapter 연결

        mlistView1.setAdapter(mAdapter);

        editText1 = inflatedView.findViewById(R.id.edit_text);

    }

    private List<String> makeData() {
        List<String> data = new ArrayList<>();
        data.add("item 01");
        data.add("item 02");
        data.add("item 03");
        data.add("item 04");
        data.add("item 05");
        return data;

    }

    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int position = -1;
            String temp = "";
            SparseBooleanArray sarray = null;

            switch ( v.getId() ) {
                case R.id.btn_add: // 데이터 추가
                    temp = editText1.getText().toString();
                    mData.add( temp );
                    mAdapter.notifyDataSetChanged(); // ListView 새로고침.
                    mlistView1.smoothScrollToPosition( mData.size() -1 ); // 마지막 레코드로 이동.

                    editText1.setText("");  // 입력값 지우기
                    break;
                case R.id.btn_modify: // 데이터 수정
                    // 선택된 체크박스의 인덱스 번호 가져오기.
                    sarray = mlistView1.getCheckedItemPositions();

                    temp = editText1.getText().toString();
                    for(int i=0; i<sarray.size(); i++){
                        position = sarray.keyAt( i );
                        mData.set( position, temp);
                    }
                    mAdapter.notifyDataSetChanged(); // ListView 새로고침.
                    mlistView1.smoothScrollToPosition( position ); // 수정하는 레코드로 이동.

                    editText1.setText("");  // 입력값 지우기
                    break;
                case R.id.btn_delete: // 데이터 삭제.
                    // 선택된 레코드의 인덱스 번호 가져오기.
                    sarray = mlistView1.getCheckedItemPositions();

                    for(int i=sarray.size()-1; i>=0; i--){
                        position = sarray.keyAt( i );
                        mData.remove( position );
                    }
                    mAdapter.notifyDataSetChanged(); // ListView 새로고침.
                    mlistView1.clearChoices();  // radio 선택 해제

                    mData.remove( position );
                    break;
            }

        }

}
}



