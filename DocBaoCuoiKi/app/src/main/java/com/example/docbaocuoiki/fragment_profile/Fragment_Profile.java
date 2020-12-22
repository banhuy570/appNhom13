package com.example.docbaocuoiki.fragment_profile;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.docbaocuoiki.Login.Login;
import com.example.docbaocuoiki.R;

public class Fragment_Profile extends Fragment {
    TextView txtDanhDau,txtDangTheoDoi,txtDocOff,txtThongBao;
    Button btndangxuat;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View root = inflater.inflate(R.layout.activity_fragment__profile, container, false);

        btndangxuat = root.findViewById(R.id.btnDangXuat);
        btndangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThoat();
            }
        });
        txtDocOff=root.findViewById(R.id.txtDocOff);
        txtDocOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOffline();
            }
        });
        txtDanhDau=root.findViewById(R.id.txtDaDanhDau);
        txtDanhDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDaDanhDau();
            }
        });
        txtDangTheoDoi=root.findViewById(R.id.txtDangTheoDoi);
        txtDangTheoDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDangTheoDoi();
            }
        });
        txtThongBao=root.findViewById(R.id.txtThongBao);
        txtThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openThongBao();
            }
        });
        return root;
    }

    private void openThongBao() {
        Intent it= new Intent(Fragment_Profile.this.getActivity(),ThongBao.class);
        startActivity(it);
    }

    private void openDangTheoDoi() {
        Intent it= new Intent(Fragment_Profile.this.getActivity(), DangTheoDoi.class);
        startActivity(it);
    }

    private void openDaDanhDau() {
        Intent it= new Intent(Fragment_Profile.this.getActivity(),DaDanhDau.class);
        startActivity(it);
    }

    private void openThoat() {
        Intent it= new Intent(Fragment_Profile.this.getActivity(), Login.class);
        startActivity(it);
    }
    private void openOffline() {
        Intent it= new Intent(Fragment_Profile.this.getActivity(),DocOffline.class);
        startActivity(it);
    }

}