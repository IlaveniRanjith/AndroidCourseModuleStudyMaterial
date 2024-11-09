package my.first.customlistviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomContactListAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<Contact> userContactList;

    public MyCustomContactListAdapter(Context context, ArrayList<Contact> userContactList) {
        this.context = context;
        this.userContactList = userContactList;
    }


    @Override
    public int getCount() {
        return userContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return userContactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // the magic method is this
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.layout_contact_list_single_item, parent, false);


        TextView tvContactName = convertView.findViewById(R.id.tv_contact_name);
        TextView tvContactNumber = convertView.findViewById(R.id.tv_contact_number);

        ImageView ivContactImage = convertView.findViewById(R.id.iv_contact_photo);

        ImageButton ibCallPhone = convertView.findViewById(R.id.ib_call);


        // set the data

        tvContactName.setText(userContactList.get(position).getName());
        tvContactNumber.setText(userContactList.get(position).getPhoneNumber());

        ivContactImage.setImageResource(userContactList.get(position).getPhotoID());

        return convertView;
    }
}
