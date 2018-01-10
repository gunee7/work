package com.example.suv12.paginglistview;

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
 * Created by suv12 on 2018-01-05.
 */

public class AdapterItem extends ArrayAdapter<ModelItem> {
    private final Context context;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ModelItem> objects) {
        super(context, resource, objects);

        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.customvie_item, null, false);

        ViewHolder holder = (ViewHolder) convertView.getTag();

        if (holder == null) {
            holder = new ViewHolder();

            holder.iconItem   = convertView.findViewById( R.id.iconItem   );
            holder.dataItem01 = convertView.findViewById( R.id.dataItem01 );
            holder.dataItem02 = convertView.findViewById( R.id.dataItem02 );
            holder.dataItem03 = convertView.findViewById( R.id.dataItem03 );

            convertView.setTag(holder);
        }

        holder.iconItem.setImageDrawable ( getItem(position).getIconItem()   );
        holder.dataItem01.setText        ( getItem(position).getDataItem01() );
        holder.dataItem02.setText        ( getItem(position).getDataItem02() );
        holder.dataItem03.setText        ( getItem(position).getDataItem03() );


        return convertView;
    }

    private class ViewHolder {
        ImageView iconItem;
        TextView dataItem01;
        TextView dataItem02;
        TextView dataItem03;
    }
}
