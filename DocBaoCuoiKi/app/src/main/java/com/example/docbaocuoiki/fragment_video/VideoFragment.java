package com.example.docbaocuoiki.fragment_video;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.docbaocuoiki.R;

import java.util.ArrayList;

public class VideoFragment extends Fragment {

    private ListView listView4;
    Context context;
    private ConstraintLayout rela4;
    private ArrayList<VideoModel> videoData;
    private VideoAdapter videoAdapter;
    private VideoModel videoModel;

    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_video, container, false);
        listView4 = root.findViewById(R.id.listView4);
        rela4 = root.findViewById(R.id.rela4);
        videoData = new ArrayList<>();
        //add Countries Data
        listnew();
        videoAdapter = new VideoAdapter(context, videoData);
        listView4.setAdapter(videoAdapter);
        registerForContextMenu(listView4);
        listView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0 :
                    Toast.makeText(context, videoData.get(position).getNoidung7(), Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(VideoFragment.this.getActivity(), videoitem.class);
                    startActivity(it);
                break;
                    case 1:

                    Toast.makeText(context, videoData.get(position).getNoidung7(), Toast.LENGTH_SHORT).show();
                    Intent it1 = new Intent(VideoFragment.this.getActivity(), videoitem2.class);
                    startActivity(it1);
                    break;

                    case 2:
                    Intent it2 = new Intent(VideoFragment.this.getActivity(), videoitem3.class);
                    startActivity(it2);
                    Toast.makeText(context, videoData.get(position).getNoidung7(), Toast.LENGTH_SHORT).show();
                break;
                case 3:
                    Intent it3 = new Intent(VideoFragment.this.getActivity(), videoitem4.class);
                    startActivity(it3);
                    Toast.makeText(context, videoData.get(position).getNoidung7(), Toast.LENGTH_SHORT).show();
                    break;
            }
            }
        });
        return root;
    }
    private void listnew() {
        videoModel = new VideoModel();
        videoModel.setId(1);
        videoModel.setAvata4(R.drawable.video_anh1);
        videoModel.setNoidung7("Dịch Covid-19 hôm nay 12/11 không ca nhiễm mới virus corona mới . Thế giới vượt 53 triệu ca nhiễm");
        videoModel.setNoidung8("VietNamPlus . 1 phút");
        videoData.add(videoModel);
        videoModel = new VideoModel();
        videoModel.setId(2);
        videoModel.setAvata4(R.drawable.video_anh2);
        videoModel.setNoidung7("Dịch Covid-19 hôm nay 11/11");
        videoModel.setNoidung8("VietNamNet . 20 phút");
        videoData.add(videoModel);
        videoModel = new VideoModel();
        videoModel.setId(3);
        videoModel.setAvata4(R.drawable.video_anh3);
        videoModel.setNoidung7("Somewhere over the rainbow (kalimba cover)");
        videoModel.setNoidung8("Kalimba . 20 phút");
        videoData.add(videoModel);
        videoModel = new VideoModel();
        videoModel.setId(4);
        videoModel.setAvata4(R.drawable.video_anh4);
        videoModel.setNoidung7("Team UT: Trải nghiệm đồ Ấn với 100 gia vị nhức não");
        videoModel.setNoidung8("Schanel . 20 phút");
        videoData.add(videoModel);

    }
}