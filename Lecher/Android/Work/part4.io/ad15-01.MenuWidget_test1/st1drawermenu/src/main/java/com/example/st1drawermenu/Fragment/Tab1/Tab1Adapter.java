package com.example.st1drawermenu.Fragment.Tab1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.st1drawermenu.R;

import java.util.ArrayList;
import java.util.List;

public class Tab1Adapter extends ArrayAdapter<Tab1Model>{

    private Context context;

    public Tab1Adapter(@NonNull Context context, int resource, @NonNull List<Tab1Model> objects) {
        super(context, resource, objects);
        this.context = context;
    }


    private class ViewHolder {
        TextView name       ;
        TextView number     ;
        TextView department ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout = LayoutInflater.from( context )
                .inflate(R.layout.fragment_tab1_custom, parent, false );

        ViewHolder holder = (ViewHolder) itemLayout.getTag();

        if( holder == null ) {
            holder = new ViewHolder();

            holder.name       = itemLayout.findViewById(R.id.text_name      );
            holder.number     = itemLayout.findViewById(R.id.text_number    );
            holder.department = itemLayout.findViewById(R.id.text_department);

            itemLayout.setTag( holder );
        }

        holder.name      .setText( getItem(position).getName      () );
        holder.number    .setText( getItem(position).getNumber    () );
        holder.department.setText( getItem(position).getDepartment() );

        return itemLayout;
    }
}
