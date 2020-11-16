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

public class TinNongAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln2;
    ArrayList<TinNongModel> tinnongData;
    LayoutInflater layoutInflater;
    TinNongModel tinnongModel;

    public TinNongAdapter(Context context, ArrayList<TinNongModel>  tinnongData) {
        this.context = context;
        this.tinnongData = tinnongData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tinnongData.size();
    }

    @Override
    public Object getItem(int i) {
        return tinnongData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return tinnongData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.dongtinnong, null, true);
        }
        //link views
        ImageView avata3 = rowView.findViewById(R.id.avata3);
        TextView noidung5 = rowView.findViewById(R.id.noidung5);
        TextView noidung6 = rowView.findViewById(R.id.noidung6);


        tinnongModel = tinnongData.get(position);

        avata3.setImageResource(tinnongModel.getAvata3());
        noidung5.setText(tinnongModel.getNoidung5());
        noidung6.setText(tinnongModel.getNoidung6());


        return rowView;
    }

//    public void RemoveItem(int position) {
//        profileData.remove(position);
//        notifyDataSetChanged();
//    }

}
