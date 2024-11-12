package abhishek.widgets.mycontactswithcontentprovider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyContactListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MyContact> myContactArrayList;

    public MyContactListAdapter(Context context, ArrayList<MyContact> myContactArrayList) {
        this.context = context;
        this.myContactArrayList = myContactArrayList;
    }

    @Override
    public int getCount() {
        return myContactArrayList.size();
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

        view = LayoutInflater.from(context).inflate(R.layout.layout_contacts_list_view_single_item, viewGroup, false);

        TextView tvID = view.findViewById(R.id.tv_c_id);
        TextView tvName = view.findViewById(R.id.tv_c_name);
        TextView tvPhone = view.findViewById(R.id.tv_c_phone);
        TextView tvEmail = view.findViewById(R.id.tv_c_email);

        tvEmail.setText(myContactArrayList.get(i).getEmail());
        tvID.setText(String.valueOf(myContactArrayList.get(i).getId()));
        tvName.setText(myContactArrayList.get(i).getName());
        tvPhone.setText(myContactArrayList.get(i).getPhone());


        return view;
    }
}
