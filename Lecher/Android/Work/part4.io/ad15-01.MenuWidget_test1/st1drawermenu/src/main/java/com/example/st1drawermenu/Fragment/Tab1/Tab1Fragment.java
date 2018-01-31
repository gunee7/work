package com.example.st1drawermenu.Fragment.Tab1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.st1drawermenu.R;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment  extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private View inflatedView;
    private ListView mlistView;
    private ArrayList<Object> data;
    private Tab1Adapter adapterListview;
    public Tab1Fragment() {

    }



    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
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
        // Inflate the layout for this fragment
        inflatedView = inflater.inflate(R.layout.fragment_tab1, container, false);
        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //ListView찾기
        mlistView = inflatedView.findViewById(R.id.list_view);
        // data생성
        data = new ArrayList<>();
        for(int i=0; i<10; i++){
            Tab1Model student  = new Tab1Model();
            student.setName("name " + i );
            student.setNumber("number " + i );
            student.setDepartment(i+"-"+i);
            data.add(student);
        }
        //ArrayAdapter 생성

        // adapterListview 만들기
        adapterListview = new Tab1Adapter( Tab1Fragment.this, R.layout.fragment_tab1_custom, data );

        ///ListView와 ArrayAdapter 연결

        mlistView.setAdapter(adapterListview);


    }

}

