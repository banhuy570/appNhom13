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

public class NewsFragment extends Fragment {

    private ListView listView, listView2;
    Context context;
    private ConstraintLayout rela, rela2;
    private ArrayList<NewModel> newData;
    private NewAdapter newAdapter;
    private NewModel newModel;


    //1
    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context=getActivity();
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        listView = root.findViewById(R.id.listView);
        rela = root.findViewById(R.id.rela);
        newData = new ArrayList<>();

        //add Countries Data
        listnew();

        newAdapter = new NewAdapter(context, newData);
        listView.setAdapter(newAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, newData.get(position).getNoidung1(), Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }

    private void listnew() {

        newModel=new NewModel();
        newModel.setId(1);
        newModel.setAvata(R.drawable.bao);
        newModel.setNoidung1("Bão số 10 gây mưa lớn tại khu vực miền Trung và Tây Nguyên");
        newModel.setNoidung2("VietNamPlus . 1 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.thucung);
        newModel.setNoidung1("Nestle ra mắt dòng thức ăn thân thiện với môi trường cho thú cưng");
        newModel.setNoidung2("World . 20 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.doanhnghiep);
        newModel.setNoidung1("Kỳ vọng mới phần thúc đẩy doanh nghiệp phát triển");
        newModel.setNoidung2("Tài Chính . 2 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.hoian);
        newModel.setNoidung1("Khu nghỉ dưỡng phức hợp HOIANA vinh dự nhận...");
        newModel.setNoidung2("VietNamPlus . 20 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.thucung);
        newModel.setNoidung1("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ");
        newModel.setNoidung2("DTCK . 10 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.thucung);
        newModel.setNoidung1("Nestle ra mắt dòng thức ăn thân thiện với môi trường cho thú cưng");
        newModel.setNoidung2("World . 20 phút");
        newData.add(newModel);

        newModel=new NewModel();
        newModel.setId(2);
        newModel.setAvata(R.drawable.thucung);
        newModel.setNoidung1("Nestle ra mắt dòng thức ăn thân thiện với môi trường cho thú cưng");
        newModel.setNoidung2("World . 20 phút");
        newData.add(newModel);



    }

}
