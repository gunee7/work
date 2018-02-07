package com.example.st1drawermenu.Fragment.Tab1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st1drawermenu.Fragment.Tab1.Tab1_Model_Card;
import com.example.st1drawermenu.R;

import java.util.List;

public class Tab1_Adapter_Card extends ArrayAdapter<Tab1_Model_Card> {

    public  Context context            = null;
    private ViewHolder holder         = null;
    private LayoutInflater inflater1  = null;
    private View inflaterView1;

    public Tab1_Adapter_Card(@NonNull Context context, int resource, @NonNull List<Tab1_Model_Card> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private class ViewHolder {

        private ImageView tab1_main_image1View;
        private TextView tab1_main_text1View;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        inflater1 = LayoutInflater.from( context );
        inflaterView1 = inflater1.inflate( R.layout.fragment_tab1_custom, parent , false );

        holder = ( ViewHolder ) inflaterView1.getTag();

        if ( holder == null ){

            holder = new ViewHolder();

            holder.tab1_main_image1View = inflaterView1.findViewById( R.id.tab1_main_image1 );
            holder.tab1_main_text1View  = inflaterView1.findViewById( R.id.tab1_main_text1  );

            inflaterView1.setTag( holder );
        }

        holder.tab1_main_image1View  .setImageDrawable(this.getItem(position).getTab1_main_image1());
        holder.tab1_main_text1View   .setText         (this.getItem(position).getTab1_main_text1() );

        return inflaterView1;
    }


}
