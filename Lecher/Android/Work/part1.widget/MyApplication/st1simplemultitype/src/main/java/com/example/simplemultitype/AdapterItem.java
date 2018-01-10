package com.example.simplemultitype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;



public class AdapterItem extends ArrayAdapter<ListViewItem> {

    private static final int ITEM_ViEW_TYPE_TEXT = 1;
    private static final int ITEM_ViEW_TYPE_IMAGES = 2;
    private final Context context;
    private final List<ListViewItem> datas;
    private final LayoutInflater inflater;

    public AdapterItem(@NonNull Context context, int resource, @NonNull List<ListViewItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datas = objects;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rowView = convertView;

        int viewType = getItemViewType(position);

        ListViewItem item = datas.get(position);


        if( rowView == null) {

            //inflation

            holder = new ViewHolder();

            switch (viewType) {
                case ITEM_ViEW_TYPE_TEXT:
                    rowView = inflater.inflate(R.layout.listview_item1, parent, false);

                    holder title = rowView.findViewById(R.id.title);
                    holder desc = rowView.findViewById(R.id.desc);
                    break;

                case ITEM_ViEW_TYPE_IMAGES:
                    rowView = inflater.inflate(R.layout.listview_item1, parent, false);
                    holder image = rowView.findViewById(R.id.image);
                    holder name = rowView.findViewById(R.id.name);

                    break;
            }

            rowView.setTag(holder);
        }
        else{
            holder = (ViewHolder) rowView.getTag();
        }

        //데이터 보이기
        switch (viewType) {
            case ITEM_ViEW_TYPE_TEXT:
                holder title = setText.findViewById(R.id.title);
                holder desc = rowView.findViewById(R.id.desc);
                break;

            case ITEM_ViEW_TYPE_IMAGES:

                holder image = rowView.findViewById(R.id.image);
                holder name = rowView.findViewById(R.id.name);

                break;









    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    @Nullable
    @Override
    public int getViewTypeCount() {
        return 2;
    }
}