package com.example.st1drawermenu.Fragment.Tab5;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st1drawermenu.Fragment.Tab2.Tab2_Model_Card;
import com.example.st1drawermenu.R;

import java.util.List;

public class Tab5_Adapter_Card extends ArrayAdapter<Tab5_Model_Card> {

    public  Context context5            = null;
    private ViewHolder holder5         = null;
    private LayoutInflater inflater5  = null;
    private View inflaterView5;

    public Tab5_Adapter_Card(@NonNull Context context, int resource, @NonNull List<Tab5_Model_Card> objects) {
        super(context, resource, objects);
        this.context5 = context;
    }

    private class ViewHolder {

        private ImageView imageCoffeeView5;
        private TextView  textCoffeeView5 ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        inflater5 = LayoutInflater.from( context5 );
        inflaterView5 = inflater5.inflate( R.layout.fragment_tab5_custom , parent , false );

        holder5 = ( ViewHolder ) inflaterView5.getTag();

        if ( holder5 == null ){

            holder5 = new ViewHolder();

            holder5.imageCoffeeView5 = inflaterView5.findViewById( R.id.image_coffee );
            holder5.textCoffeeView5  = inflaterView5.findViewById( R.id.text_coffee  );

            inflaterView5.setTag( holder5 );
        }

        holder5.imageCoffeeView5  .setImageDrawable(this.getItem(position).getImageCoffee());
        holder5.textCoffeeView5   .setText         (this.getItem(position).getTextCoffee() );

        return inflaterView5;
    }


}
