package com.example.st1drawermenu.Fragment.Tab1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;


import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private View                  inflatedview1     = null ;
    private Tab1_Adapter_Card     tab1Adapter;
    private ListView              tab1ListView;
    private List<Tab1_Model_Card> data1;

    private int[] poor_images            = Tab1MenuButton.poor_icon;


    private int getid1 = 0;

    public Tab1Fragment() {

    }

    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        inflatedview1 = inflater.inflate(R.layout.fragment_tab1, container, false);

        data1 = MakeDataA1( 0 , poor_images.length - 1 );

        tab1Adapter = new Tab1_Adapter_Card( getContext(), R.layout.fragment_tab1_custom, data1 );
        tab1ListView = inflatedview1.findViewById( R.id.tab1_main_listview );
        tab1ListView.setAdapter( tab1Adapter );

        return inflatedview1;
    }



    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab1ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position1" , position );
                i.putExtra( "name1"     , getid1 );
                startActivity(i);
            }
        });


    }



    private List<Tab1_Model_Card> MakeDataA1( int start, int end ) {

        String[] poorName = getResources().getStringArray(R.array.tab1_poor_text_name);
        List<Tab1_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab1_Model_Card item = new Tab1_Model_Card();
            item.setTab1_main_image1(getResources().getDrawable(poor_images[i]));
            item.setTab1_main_text1 ( poorName[i] );

            list.add(item);
        }

        return list;
    }


}
