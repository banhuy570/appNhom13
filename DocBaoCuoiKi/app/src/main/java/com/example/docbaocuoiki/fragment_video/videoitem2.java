package com.example.docbaocuoiki.fragment_video;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.docbaocuoiki.R;

public class videoitem2 extends AppCompatActivity {
    Button btnmp4;
    VideoView videoView;
    TextView textView,textView1,textView2;
@Override
    public void onCreate(Bundle savedInstanceState) {
    getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_item);
        btnmp4 = (Button) findViewById(R.id.buttonmp4);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Dịch bệnh covid ngày 10/11 ");
    textView1 = (TextView) findViewById(R.id.textView4);
    textView1.setText("VietNamnNet");
    textView2 = (TextView) findViewById(R.id.textView5);
    textView2.setText("10 phút trước");
        videoView = (VideoView) findViewById(R.id.videoViewmp4);
        btnmp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.covid1011));
                videoView.start();
                MediaController mediaController = new MediaController(videoitem2.this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
            }
        });
    }
}