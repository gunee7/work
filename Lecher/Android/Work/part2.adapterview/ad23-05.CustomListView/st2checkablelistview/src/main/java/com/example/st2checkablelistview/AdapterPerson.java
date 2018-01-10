package com.example.st2checkablelistview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018-01-05.
 */

public class AdapterPerson extends ArrayAdapter<ModelPerson> {

    private final Context context;

    public AdapterPerson(@NonNull Context context, int resource, @NonNull ModelPerson[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }


    @Override
    public String toString() {
        return "AdapterPerson{" +
                "context=" + context +
                '}';
    }


    @Nullable
    @Override
    public ModelPerson getItem(int position) {
        return super.getItem(position);
    }
}





