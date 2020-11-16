package com.example.mmm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
//    ListView lvPeople;
//    ArrayList<News> arrayPeople;
//    NewsAdapter adapter;
//    String title;
//    String author;
//    int hinh;
//    Button button;
//
//    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        AnhXa();
//        adapter = new NewsAdapter(this, R.layout.line_info, arrayPeople);
//        lvPeople.setAdapter(adapter);
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
//
//        button = (Button) findViewById(R.id.btndangxuat);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NewsFragment()).commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_tintuc:
                            selectedFragment = new NewsFragment();
                            break;
                        case R.id.nav_video:
                            selectedFragment = new VideoFragment();
                            break;
                        case R.id.nav_xuhuong:
                            selectedFragment = new XuHuongFragment();
                            break;
                        case R.id.nav_person:
                            selectedFragment = new PersonFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

//    private void AnhXa() {
//        lvPeople = (ListView) findViewById(R.id.line1);
//        arrayPeople = new ArrayList<>();
//        arrayPeople.add(new News("Bão số 10 gây mưa lớn tại khu vực miền Trung và Tây Nguyên", "VietNamPlus . 1 phút", R.drawable.bao));
//        arrayPeople.add(new News("Nestle ra mắt dòng thức ăn thân thiện với môi trường cho thú cưng", "World", R.drawable.thucung));
//        arrayPeople.add(new News("Khu nghỉ dưỡng phức hợp HOIANA vinh dự nhận... ", "VietNamPlus", R.drawable.hoian));
//        arrayPeople.add(new News("Kỳ vọng mới phần thúc đẩy doanh nghiệp phát triển", "Tài chính", R.drawable.doanhnghiep));
//        arrayPeople.add(new News("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ", "DTCK", R.drawable.taichinh));
//        arrayPeople.add(new News("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ", "DTCK", R.drawable.taichinh));
//        arrayPeople.add(new News("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ", "DTCK", R.drawable.taichinh));
//        arrayPeople.add(new News("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ", "DTCK", R.drawable.taichinh));
//        arrayPeople.add(new News("Thị trường tài chính 24h: Chứng khoán châu Á bùng nổ", "DTCK", R.drawable.taichinh));
//    }

}
