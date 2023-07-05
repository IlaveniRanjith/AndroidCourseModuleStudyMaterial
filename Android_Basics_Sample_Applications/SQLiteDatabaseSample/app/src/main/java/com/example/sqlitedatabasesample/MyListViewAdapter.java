package com.example.sqlitedatabasesample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<SContact> myContacts;

    public MyListViewAdapter(Context context, ArrayList<SContact> myContacts) {
        this.context = context;
        this.myContacts = myContacts;
    }

    @Override
    public int getCount() {
        return myContacts.size();
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

        view = LayoutInflater.from(context).inflate(R.layout.list_view_single_item_layout, viewGroup, false);

        TextView tvID = view.findViewById(R.id.tv_ID_list_item);
        TextView tvName = view.findViewById(R.id.tv_name_list_item);
        TextView tvPhone = view.findViewById(R.id.tv_phone_list_item);

        //SContact contact = myContacts.get(i);

        tvID.setText(myContacts.get(i).getId() + "");
        tvName.setText(myContacts.get(i).getName());
        tvPhone.setText(myContacts.get(i).getPhone());

        return view;
    }
}
