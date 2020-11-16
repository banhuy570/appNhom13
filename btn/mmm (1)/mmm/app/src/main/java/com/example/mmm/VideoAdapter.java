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

public class VideoAdapter extends BaseAdapter {

    Context context;
    LinearLayout ln3;
    ArrayList<VideoModel> videoData;
    LayoutInflater layoutInflater;
   VideoModel videoModel;

    public VideoAdapter(Context context, ArrayList<VideoModel>  videoData) {
        this.context = context;
        this.videoData = videoData;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return videoData.size();
    }

    @Override
    public Object getItem(int i) {
        return videoData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return videoData.get(i).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View rowView = view;
        if (rowView == null) {
            rowView = layoutInflater.inflate(R.layout.list_video, null, true);
        }
        //link views
        ImageView avata3 = rowView.findViewById(R.id.avata4);
        TextView noidung5 = rowView.findViewById(R.id.noidung7);
        TextView noidung6 = rowView.findViewById(R.id.noidung8);


        videoModel = videoData.get(position);

        avata3.setImageResource(videoModel.getAvata4());
        noidung5.setText(videoModel.getNoidung7());
        noidung6.setText(videoModel.getNoidung8());


        return rowView;
    }

//    public void RemoveItem(int position) {
//        profileData.remove(position);
//        notifyDataSetChanged();
//    }

}
