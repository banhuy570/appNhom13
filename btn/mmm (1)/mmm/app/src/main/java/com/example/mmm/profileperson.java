package com.example.mmm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class profileperson extends AppCompatActivity {

   private Button btndangxuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileperson);
        btndangxuat =(Button)findViewById(R.id.btndangxuat);
        btndangxuat.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(profileperson.this,dangnhap.class);
                startActivity(intent);
            }
        });
    }
}