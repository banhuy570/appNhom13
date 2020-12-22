package com.example.docbaocuoiki;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.docbaocuoiki.fragment_news.FragmentNews;
import com.example.docbaocuoiki.fragment_profile.Fragment_Profile;
import com.example.docbaocuoiki.fragment_video.VideoFragment;
import com.example.docbaocuoiki.fragment_xuhuong.FragmentXuHuong;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.btnbt);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.trangchu:
                        fragment = new FragmentNews();
                        break;
                    case R.id.video:
                        fragment = new VideoFragment();
                        break;
                    case R.id.xuhuong:
                        fragment = new FragmentXuHuong();
                        break;
                    case R.id.taikhoan:
                        fragment = new Fragment_Profile();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }

                fragmentTransaction.replace(R.id.hh,fragment);
                fragmentTransaction.commit();
                return true;
            }
        });


    }


}