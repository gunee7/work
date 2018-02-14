package com.example.st1drawermenu.Fragment.Tab1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.content.Intent;

import com.example.st1drawermenu.Fragment.Tab2.Tab2MenuButton;
import com.example.st1drawermenu.Fragment.Tab2.Tab2_Adapter_Card;
import com.example.st1drawermenu.Fragment.Tab2.Tab2_Model_Card;
import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private View         inflatedview1     = null ;
    private Tab1_Adapter_Card tab1Adapter;
    private GridView tab1GridView;
    private List<Tab1_Model_Card> data1;

    private int[] coffee_images    = Tab1MenuButton.caffee_icon;


    private int getid1 = 0;


    public Tab1Fragment() {

    }

    public static com.example.st1drawermenu.Fragment.Tab1.Tab1Fragment newInstance(String param1, String param2) {
        com.example.st1drawermenu.Fragment.Tab1.Tab1Fragment fragment = new com.example.st1drawermenu.Fragment.Tab1.Tab1Fragment();
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

        data1 = MakeData1( 0 , coffee_images.length - 1 );

        tab1Adapter = new Tab1_Adapter_Card( getContext(), R.layout.fragment_tab1_custom, data1 );
        tab1GridView = inflatedview1.findViewById( R.id.gridView3 );
        tab1GridView.setAdapter( tab1Adapter );


        return inflatedview1;
    }




    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab1GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position );
                i.putExtra( "name"     , getid1 );
                startActivity(i);
            }
        });

    }


    private List<Tab1_Model_Card> MakeData1( int start, int end ) {

        String[] beverageName = getResources().getStringArray(R.array.menu_coffee_name);
        List<Tab1_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab1_Model_Card item = new Tab1_Model_Card();
            item.setImageCoffee(getResources().getDrawable(coffee_images[i]));
            item.setTextCoffee( beverageName[i] );

            list.add(item);
        }

        return list;
    }

}




