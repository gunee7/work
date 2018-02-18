package com.example.st1drawermenu.Fragment.Tab5;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.content.Intent;

import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.SubMenuActivity;

import java.util.ArrayList;
import java.util.List;

public class Tab5Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    private View         inflatedview5     = null ;
    private Tab5_Adapter_Card tab5Adapter;
    private GridView tab5GridView;
    private List<Tab5_Model_Card> data5;

    private int[] sidemenu_iamges       =  Tab5MenuButton.sidemenu_icon;


    private int getid5 = 0;


    public Tab5Fragment() {

    }

    public static com.example.st1drawermenu.Fragment.Tab5.Tab5Fragment newInstance(String param1, String param2) {
        com.example.st1drawermenu.Fragment.Tab5.Tab5Fragment fragment = new com.example.st1drawermenu.Fragment.Tab5.Tab5Fragment();
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
        inflatedview5 = inflater.inflate(R.layout.fragment_tab5, container, false);

        data5 = MakeData5( 0 , sidemenu_iamges.length - 1 );

        tab5Adapter = new Tab5_Adapter_Card( getContext(), R.layout.fragment_tab5_custom, data5 );
        tab5GridView = inflatedview5.findViewById( R.id.gridView5 );
        tab5GridView.setAdapter( tab5Adapter );


        return inflatedview5;
    }




    @Override                    // 위젯 관련된 것은 이쪽에서
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated( savedInstanceState );


        tab5GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // intent 여기안에서 하기
                Intent i = new Intent ( getContext(), SubMenuActivity.class);
                i.putExtra( "position" , position );
                i.putExtra( "name"     , getid5 );
                startActivity(i);
            }
        });

    }


    private List<Tab5_Model_Card> MakeData5( int start, int end ) {

        String[] sidemenuName = getResources().getStringArray(R.array.menu_sidemenu_name);
        List<Tab5_Model_Card> list = new ArrayList<>();
        for(int i =start ; i<=end; i++){

            Tab5_Model_Card item = new Tab5_Model_Card();
            item.setImageCoffee(getResources().getDrawable(sidemenu_iamges[i]));
            item.setTextCoffee( sidemenuName[i] );

            list.add(item);
        }

        return list;
    }

}




