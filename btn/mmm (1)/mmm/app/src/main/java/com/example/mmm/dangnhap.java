package com.example.mmm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class dangnhap extends AppCompatActivity {

    EditText edtuser,edtpassword;
    Button btdangky,btdangnhap,btthoat;
    String ten,mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }
    private void ControlButton() {
        btthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(dangnhap.this, R.style.Theme_AppCompat_Light_Dialog);
                builder.setTitle("Bạn có muốn thoát khỏi app?");
                builder.setMessage("Lựa chọn bên dưới để xác nhận!");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btdangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(dangnhap.this);
                dialog.setTitle("Hop thoai xu ly");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edittk = (EditText)dialog.findViewById(R.id.edittk);
                final EditText editmk = (EditText)dialog.findViewById(R.id.editmk);
                Button btnhuy = (Button)dialog.findViewById(R.id.btnhuy);
                Button btdongy = (Button)dialog.findViewById(R.id.btndongy);
                btdongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edittk.getText().toString().trim();
                        mk = editmk.getText().toString().trim();

                        edtuser.setText(ten);
                        edtpassword.setText(mk);

                        dialog.cancel();

                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser.getText().length() != 0 && edtpassword.getText().length() !=0){
                    if(edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(dangnhap.this,"Bạn đã đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dangnhap.this,NewsActivity.class);
                        startActivity(intent);
                    }else if(edtuser.getText().toString().equals("Admin") && edtpassword.getText().toString().equals("123")){
                        Toast.makeText(dangnhap.this,"Bạn đã đăng nhập thành công !", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dangnhap.this,NewsActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(dangnhap.this,"Thông tin đăng nhập không chính xác !", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(dangnhap.this,"Vui long nhập đầy đủ thông tin !", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void Anhxa() {
        edtuser = (EditText)findViewById(R.id.edittextuser);
        edtpassword = (EditText)findViewById(R.id.edittextpassword);
        btdangnhap = (Button)findViewById(R.id.btndangnhap);
        btdangky = (Button)findViewById(R.id.btndangky);
        btthoat = (Button)findViewById(R.id.btnthoat);
    }
}