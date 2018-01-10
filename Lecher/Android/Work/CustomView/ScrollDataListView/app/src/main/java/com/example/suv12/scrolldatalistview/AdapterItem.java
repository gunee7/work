package com.example.suv12.scrolldatalistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suv12 on 2018-01-08.
 */

public class AdapterItem extends ArrayAdapter<ModelItem> {

    // 1.
    private Context context       = null;
    private List<ModelItem> lists = null;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);

        // 2.
        this.context = context;
        this.lists   = objects;
    }

    // 4.
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder;

        View rowView = convertView;

        if ( rowView == null ) {

            rowView = LayoutInflater.from( this.context ).inflate( R.layout.layout_item, null, false );

            holder = new ViewHolder();
            holder.iconItem   = rowView.findViewById( R.id.iconItem   );
            holder.dataItem01 = rowView.findViewById( R.id.dataItem01 );
            holder.dataItem02 = rowView.findViewById( R.id.dataItem02 );
            holder.dataItem03 = rowView.findViewById( R.id.dataItem03 );

            rowView.setTag( holder );

        } else {

            holder = ( ViewHolder ) rowView.getTag();

        }

        // 5.
        holder.iconItem.setImageDrawable( getItem(position).getIconItem()   );
        holder.dataItem01.setText       ( getItem(position).getDataItem01() );
        holder.dataItem02.setText       ( getItem(position).getDataItem02() );
        holder.dataItem03.setText       ( getItem(position).getDataItem03() );

        return rowView;
    }

    // 3.
    private class ViewHolder {
        ImageView iconItem;
        TextView  dataItem01;
        TextView  dataItem02;
        TextView  dataItem03;
    }
}
