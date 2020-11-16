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

public class QuanTamAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln2;
    ArrayList<QuanTamModel> quantamData;
    LayoutInflater layoutInflater;
    QuanTamModel quantamModel;

    public QuanTamAdapter(Context context, ArrayList<QuanTamModel>  quantamData) {
        this.context = context;
        this.quantamData = quantamData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return quantamData.size();
    }

    @Override
    public Object getItem(int i) {
        return quantamData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return quantamData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.list_quantam, null, true);
        }
        //link views
        ImageView avata2 = rowView.findViewById(R.id.avata2);
        TextView noidung3 = rowView.findViewById(R.id.noidung3);
        TextView noidung4 = rowView.findViewById(R.id.noidung4);


        quantamModel = quantamData.get(position);

        avata2.setImageResource(quantamModel.getAvata2());
        noidung3.setText(quantamModel.getNoidung3());
        noidung4.setText(quantamModel.getNoidung4());


        return rowView;
    }

//    public void RemoveItem(int position) {
//        profileData.remove(position);
//        notifyDataSetChanged();
//    }

}
