package com.example.st1drawermenu.Cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.content.Intent;

import com.example.st1drawermenu.MainActivity;
import com.example.st1drawermenu.NavPackage.Event.EventActivity;
import com.example.st1drawermenu.R;
import com.example.st1drawermenu.SubuMenu.QrcodeActivity;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView cartListview = null;
    private CartAdapter cartAdapter;
    private List<CartModel> data;
    List<CartModel> list = new ArrayList<>();

    private ImageView btn_back;
    private ImageView btn_barket;
    private Button btn_menuadd;
    private Button btn_checking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListview = findViewById( R.id.cart_listview );

        data = MakeData();

        cartAdapter = new CartAdapter( CartActivity.this,R.layout.cart_custom, data );
        cartAdapter.notifyDataSetChanged();
        cartListview.setAdapter( cartAdapter );

        btn_back = findViewById( R.id.btn_back );
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( /* context */ CartActivity.this  ,  /* class 이름 */ MainActivity.class);
                startActivity ( i );
            }
        });


        btn_barket = findViewById( R.id.btn_barket );
        btn_barket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( /* context */ CartActivity.this  ,  /* class 이름 */ CartActivity.class);
                startActivity ( i );

            }
        });


        btn_menuadd = findViewById( R.id.btn_menuadd );
        btn_menuadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( /* context */ CartActivity.this  ,  /* class 이름 */ MainActivity.class);
                startActivity ( i );
            }
        });

        btn_checking = findViewById( R.id.btn_checking );
        btn_checking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( /* context */ CartActivity.this  ,  /* class 이름 */ QrcodeActivity.class);
                startActivity ( i );
            }
        });
    }

    private List<CartModel> MakeData() {

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String price = i.getStringExtra("price");
        String number = i.getStringExtra("number");

        CartModel cart = new CartModel();
        cart.setCoffeeName( name );
        cart.setCoffePrice( price +"");
        cart.setCoffeeCount( number+"" );

        list.add( cart );

        return list;
    };


}
