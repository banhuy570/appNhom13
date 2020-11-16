package com.example.mmm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class NewAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln;
    ArrayList<NewModel> newData;
    LayoutInflater layoutInflater;
    NewModel newModel;

    public NewAdapter(Context context, ArrayList<NewModel> newData) {
        this.context = context;
        this.newData = newData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return newData.size();
    }

    @Override
    public Object getItem(int i) {
        return newData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return newData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.list_new, null, true);
        }
        //link views
        ImageView avata = rowView.findViewById(R.id.avata);
        TextView noidung1 = rowView.findViewById(R.id.noidung1);
        TextView noidung2 = rowView.findViewById(R.id.noidung2);


        newModel = newData.get(position);

        avata.setImageResource(newModel.getAvata());
        noidung1.setText(newModel.getNoidung1());
        noidung2.setText(newModel.getNoidung2());


        return rowView;
    }

//    public void RemoveItem(int position) {
//        profileData.remove(position);
//        notifyDataSetChanged();
//    }

}
