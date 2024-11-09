package my.first.customlistviewtake2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyContactListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MyContact> myContactsDetailedList;

    public MyContactListAdapter(Context context, ArrayList<MyContact> inputList){
        this.myContactsDetailedList = inputList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return myContactsDetailedList.size();
    }

    @Override
    public Object getItem(int position) {
        return myContactsDetailedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // most important method
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //1. to inflate the custom design (layout)
        convertView = LayoutInflater.from(context).inflate(R.layout.layout_contact_list_single_item, viewGroup, false);
        //2. access the widgets from your custom layout
        ImageView ivContactPhoto = convertView.findViewById(R.id.iv_contact_photo);
        TextView tvContactName = convertView.findViewById(R.id.tv_contact_name);
        TextView tvContactNumber = convertView.findViewById(R.id.tv_contact_number);
        ImageButton ibCallPhone = convertView.findViewById(R.id.ib_call);

        //3. do the operation like setting or getting the data
        ivContactPhoto.setImageResource(myContactsDetailedList.get(position).getPhotoID());

        tvContactName.setText(myContactsDetailedList.get(position).getName());
        tvContactNumber.setText(myContactsDetailedList.get(position).getPhoneNum());

        ibCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Call button pressedd.....", Toast.LENGTH_SHORT).show();

                //Implicit Intent
                Intent dialPhoneNumber = new Intent(Intent.ACTION_DIAL);

                String phoneNumberToDial = myContactsDetailedList.get(position).getPhoneNum();
                dialPhoneNumber.setData(Uri.parse("tel:"+phoneNumberToDial));
                context.startActivity(dialPhoneNumber);

            }
        });
        
        
        
        
        //4. return the layout
        return convertView;
    }
}
