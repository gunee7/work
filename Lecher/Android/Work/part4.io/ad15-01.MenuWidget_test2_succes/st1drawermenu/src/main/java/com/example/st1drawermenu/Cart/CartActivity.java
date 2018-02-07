package com.example.st1drawermenu.Cart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.content.Intent;

import com.example.st1drawermenu.R;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView cartListview = null;
    private CartAdapter cartAdapter;
    private List<CartModel> data;
    List<CartModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListview = findViewById( R.id.cart_listview );

        data = MakeData();

        cartAdapter = new CartAdapter( CartActivity.this,R.layout.cart_custom, data );
        cartAdapter.notifyDataSetChanged();
        cartListview.setAdapter( cartAdapter );

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
