package com.example.docbaocuoiki.fragment_profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.docbaocuoiki.R;

import java.util.List;

public class TinOfflineAdapter extends BaseAdapter {
    private Context context;
    private int mylayout;
    private List<TinOfflineModel> tinOfflineModelList;

    public TinOfflineAdapter(Context context, int mylayout, List<TinOfflineModel> tinOfflineModelList) {
        this.context = context;
        this.mylayout = mylayout;
        this.tinOfflineModelList = tinOfflineModelList;
    }

    @Override
    public int getCount() {
        return tinOfflineModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.dongtintucoffline,null);
        TextView txtTenTin= convertView.findViewById(R.id.txtTenTin);
        TextView txtNguon= convertView.findViewById(R.id.txtNguon);
        TextView txtTime= convertView.findViewById(R.id.txtTime);
        ImageView imgAnhOff=convertView.findViewById(R.id.imgAnhOff);
        TinOfflineModel tinOfflineModel=tinOfflineModelList.get(position);
        txtTenTin.setText(tinOfflineModel.getTenTin());
        imgAnhOff.setImageResource(tinOfflineModel.getHinhAnh());
        txtNguon.setText(tinOfflineModel.getNguonTin());
        txtTime.setText(tinOfflineModel.getHour());
        return convertView;

    }
}
