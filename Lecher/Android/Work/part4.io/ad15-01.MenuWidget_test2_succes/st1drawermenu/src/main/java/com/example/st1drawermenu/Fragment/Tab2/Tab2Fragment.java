package com.example.st1drawermenu.Fragment.Tab2;


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

import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;
import com.example.st1drawermenu.Tab2MenuButton;

import java.util.ArrayList;
import java.util.List;

public class Tab2Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private View         inflatedview     = null ;
    private Tab2_Adapter_Card tab1Adapter;
    private GridView tab1GridView;
    private List<Tab2_Model_Card> data;
    private int[] coffee_images = Tab2MenuButton.caffee_icon;
    private int[] latte_iamges =  Tab2MenuButton.lattee_icon;
    private Button btn_menu1 = null;
    private Button btn_menu2 = null;
    private Button btn_menu3 = null;
    private Button btn_menu4 = null;
    private Button btn_menu5 = null;



    public Tab2Fragment() {

    }

    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
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
        inflatedview = inflater.inflate(R.layout.fragment_tab2, container, false);

        data = MakeData1( 0 , 15 );

        tab1Adapter = new Tab2_Adapter_Card( getContext(), R.layout.fragment_tab2_custom, data );
        tab1GridView = inflatedview.findViewById( R.id.gridView );
        tab1GridView.setAdapter( tab1Adapter );

        btn_menu1 = inflatedview.findViewById( R.id.btn_menu1 );
        btn_menu2 = inflatedview.findViewById( R.id.btn_menu2 );
        btn_menu3 = inflatedview.findViewById( R.id.btn_menu3 );
        btn_menu4 = inflatedview.findViewById( R.id.btn_menu4 );
        btn_menu5 = inflatedview.findViewById( R.id.btn_menu5 );

        return inflatedview;
    }





    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab1GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position);
                startActivity(i);
            }
        });

        buttonClickListener bcListener = new buttonClickListener();
        btn_menu1.setOnClickListener( bcListener );
        btn_menu2.setOnClickListener( bcListener );
        btn_menu3.setOnClickListener( bcListener );
        btn_menu4.setOnClickListener( bcListener );
        btn_menu5.setOnClickListener( bcListener );

    }

    private class buttonClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_menu1:
                    data = MakeData1( 0 , 15 );
                    tab1Adapter = new Tab2_Adapter_Card( getContext(), R.layout.fragment_tab2_custom, data );
                    tab1Adapter.notifyDataSetChanged();
                    tab1GridView.setAdapter( tab1Adapter );


                    break;
                case R.id.btn_menu2:
                    data = MakeData2( 0 , 13 );
                    tab1Adapter = new Tab2_Adapter_Card( getContext(), R.layout.fragment_tab2_custom, data );
                    tab1Adapter.notifyDataSetChanged();
                    tab1GridView.setAdapter( tab1Adapter );


                    break;
                case R.id.btn_menu3:

                    break;
                case R.id.btn_menu4:

                    break;
                case R.id.btn_menu5:

                    break;
            }
        }
    }
    private List<Tab2_Model_Card> MakeData1( int start, int end ) {

        String[] coffeeName = getResources().getStringArray(R.array.menu_coffee_name);
        List<Tab2_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab2_Model_Card item = new Tab2_Model_Card();
            item.setImageCoffee(getResources().getDrawable(coffee_images[i]));
            item.setTextCoffee( coffeeName[i] );

            list.add(item);
        }

        return list;
    }
    private List<Tab2_Model_Card> MakeData2( int start, int end ) {

        String[] coffeeName = getResources().getStringArray(R.array.menu_latte_name);
        List<Tab2_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab2_Model_Card item = new Tab2_Model_Card();
            item.setImageCoffee(getResources().getDrawable(latte_iamges[i]));
            item.setTextCoffee( coffeeName[i] );

            list.add(item);
        }

        return list;
    }


}