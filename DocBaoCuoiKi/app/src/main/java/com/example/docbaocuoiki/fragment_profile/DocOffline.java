package com.example.docbaocuoiki.fragment_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.docbaocuoiki.R;

import java.util.ArrayList;

public class DocOffline extends AppCompatActivity {
    ListView lvTinOff;
    ArrayList<TinOfflineModel> tinOfflineModelArrayList;
    TinOfflineAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_offline);
        anhxa();
        adapter= new TinOfflineAdapter(this,R.layout.dongtintucoffline,tinOfflineModelArrayList);
        lvTinOff.setAdapter(adapter);
    }
    private void anhxa() {
        lvTinOff=findViewById(R.id.lvOffline);
        tinOfflineModelArrayList=new ArrayList<>();
        tinOfflineModelArrayList.add(new TinOfflineModel("Những người quyết không tin Trump thất cử","Thế giới"
                ,R.drawable.video_anh1,"3 giờ trước"));
        tinOfflineModelArrayList.add(new TinOfflineModel("Ngày mai tiêm thử vaccine Covid-19 Việt Nam","Báo Mới",R.drawable.video_anh2,"9h"));
//        lvTinOff.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if(position==0){
//                    startActivity(new Intent(DocOffline.this,TrumpTT.class));
//                }
//
//                if(position==1){
//                    startActivity(new Intent(DocOffline.this,Vacxin.class));
//                }
//            }
//        });
    }
}