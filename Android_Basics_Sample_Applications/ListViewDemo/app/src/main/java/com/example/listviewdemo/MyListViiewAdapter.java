package com.example.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyListViiewAdapter extends BaseAdapter {

    Context context;
    String [] names;
    int [] images;


    MyListViiewAdapter (Context context, String [] names, int [] images){
        this.images = images;
        this.names = names;
        this.context = context;
    }



//important function for us
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    //main magic method
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //1. inflate the custom layout
        view = LayoutInflater.from(context).inflate(R.layout.list_view_single_item_layout, viewGroup, false);

        //2. bind the views
        TextView tvName = view.findViewById(R.id.tv_list_view_item);
        ImageView ivImage = view.findViewById(R.id.iv_list_view_item);

        //3. populate the views
        tvName.setText(names[i]);
        ivImage.setImageResource(images[i]);
        return view;
    }
}
