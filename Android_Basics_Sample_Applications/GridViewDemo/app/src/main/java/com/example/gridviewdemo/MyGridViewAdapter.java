package com.example.gridviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyGridViewAdapter extends BaseAdapter {

    Context context;
    ArrayList<MyImage> myPhotos;

    MyGridViewAdapter(Context context, ArrayList<MyImage> myImages){
        this.context = context;
        myPhotos = myImages;
    }



    @Override
    public int getCount() {
        return myPhotos.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.grid_view_single_item_layout, viewGroup, false);

        TextView tvImageName = view.findViewById(R.id.tv_grid_view);
        ImageView ivImage = view.findViewById(R.id.iv_grid_view);

        tvImageName.setText(myPhotos.get(i).getName());
        ivImage.setImageResource(myPhotos.get(i).getImageID());

        return view;
    }
}
