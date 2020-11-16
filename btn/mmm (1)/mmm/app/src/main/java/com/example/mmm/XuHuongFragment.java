package com.example.mmm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;

public class XuHuongFragment extends Fragment {

    private ListView listView2,listView3;
    Context context;
    private ConstraintLayout rela2,rela3;
    private ArrayList<QuanTamModel> quantamData;
    private QuanTamAdapter quantamAdapter;
    private QuanTamModel quantamModel;
    private ArrayList<TinNongModel> tinnongData;
    private TinNongAdapter tinnongAdapter;
    private TinNongModel tinnongModel;


    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_xu_huong, container, false);
        listView2 = root.findViewById(R.id.listView2);
        rela2 = root.findViewById(R.id.rela2);
        quantamData = new ArrayList<>();
        listView3 = root.findViewById(R.id.listView3);
        rela3 = root.findViewById(R.id.rela3);
        tinnongData = new ArrayList<>();



        //add Countries Data
        listquantam();
        listtinnong();
        quantamAdapter = new QuanTamAdapter(context, quantamData);
        listView2.setAdapter(quantamAdapter);
        registerForContextMenu(listView2);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, quantamData.get(position).getNoidung3(), Toast.LENGTH_SHORT).show();
            }
        });
        tinnongAdapter = new TinNongAdapter(context, tinnongData);
        listView3.setAdapter(tinnongAdapter);
        registerForContextMenu(listView3);
        listView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, tinnongData.get(position).getNoidung5(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void listquantam() {

        quantamModel=new QuanTamModel();
        quantamModel.setId(1);
        quantamModel.setAvata2(R.drawable.anh3);
        quantamModel.setNoidung3("Khuyến mãi 10.10 ");
        quantamModel.setNoidung4("Chốt đơn combo Buger King CHỈ 35K");
        quantamData.add(quantamModel);

        quantamModel=new QuanTamModel();
        quantamModel.setId(2);
        quantamModel.setAvata2(R.drawable.image1);
        quantamModel.setNoidung3("Thời tiết 11.11");
        quantamModel.setNoidung4("Bão số 12 gây mưa lớn ở miền trung, bão số 13 đã 'lấp ló' vào biển Đông");
        quantamData.add(quantamModel);

        quantamModel=new QuanTamModel();
        quantamModel.setId(3);
        quantamModel.setAvata2(R.drawable.image2);
        quantamModel.setNoidung3("Người lao động");
        quantamModel.setNoidung4("Lời kể cư dân vụ thi thể không đầu ở chung cư Quận 7");

        quantamModel=new QuanTamModel();
        quantamModel.setId(4);
        quantamModel.setAvata2(R.drawable.image3);
        quantamModel.setNoidung3("Thể thao 24/7");
        quantamModel.setNoidung4("Điểm nóng vòng 8 ngoại hạng Anh: MU hồi sinh, Liverpool gặp lớp 'Cực dị'");
        quantamData.add(quantamModel);
    }

    private void listtinnong() {

        tinnongModel=new TinNongModel();
        tinnongModel.setId(1);
        tinnongModel.setAvata3(R.drawable.image6);
        tinnongModel.setNoidung5("Thời tiết 10-11");
        tinnongModel.setNoidung6("Bão Vamco vào Hà Tĩnh- Quảng Bình");
        tinnongData.add(tinnongModel);

        tinnongModel=new TinNongModel();
        tinnongModel.setId(2);
        tinnongModel.setAvata3(R.drawable.image7);
        tinnongModel.setNoidung5("Thời sự 10-11");
        tinnongModel.setNoidung6("Ba thanh niên trong vụ đánh nam sinh lớp 12 tử vong ra đầu thú");
        tinnongData.add(tinnongModel);
        tinnongModel=new TinNongModel();
        tinnongModel.setId(3);
        tinnongModel.setAvata3(R.drawable.image6);
        tinnongModel.setNoidung5("Thời tiết 10-11");
        tinnongModel.setNoidung6("Bão Vamco vào Hà Tĩnh- Quảng Bình");
        tinnongData.add(tinnongModel);

        tinnongModel=new TinNongModel();
        tinnongModel.setId(4);
        tinnongModel.setAvata3(R.drawable.image7);
        tinnongModel.setNoidung5("Thời sự 10-11");
        tinnongModel.setNoidung6("Ba thanh niên trong vụ đánh nam sinh lớp 12 tử vong ra đầu thú");
        tinnongData.add(tinnongModel);



    }

}