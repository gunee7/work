package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class AdapterStudent extends ArrayAdapter<ModelStudent> {


    public AdapterStudent(@NonNull Context context, int resource, @NonNull List<ModelStudent> objects) {
        super(context, resource, objects);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemLayout =super.getView(position, convertView, parent);

        TextView name = itemLayout.findViewById(R.id.text_name);
        TextView number = itemLayout.findViewById(R.id.text_number);
        TextView department = itemLayout.findViewById(R.id.text_department);


        name.setText( getItem(position).getName());
        number.setText( getItem(position).getName());
        department.setText( getItem(position).getName());
        return itemLayout;
    }



}
