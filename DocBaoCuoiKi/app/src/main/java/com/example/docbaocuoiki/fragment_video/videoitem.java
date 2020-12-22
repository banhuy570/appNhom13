package com.example.docbaocuoiki.fragment_video;


import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.docbaocuoiki.R;


public class videoitem extends AppCompatActivity {
    Button btnmp4;
    VideoView videoView;
    TextView textView,textView1,textView2;

    public void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_item);
        btnmp4 = (Button) findViewById(R.id.buttonmp4);
        textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Dịch bênh covid ngày 12/11");

        textView1 = (TextView) findViewById(R.id.textView4);
        textView1.setText("VietNamnNet");
        textView2 = (TextView) findViewById(R.id.textView5);
        textView2.setText("1 phút trước");
        videoView = (VideoView) findViewById(R.id.videoViewmp4);
        btnmp4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.covid1));
                videoView.start();

                MediaController mediaController = new MediaController(videoitem.this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
            }
        });
    }
}






