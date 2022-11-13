package com.triplek.QuanLyPhongNet.Camera;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.triplek.QuanLyPhongNet.R;

public class Camera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.triplek.QuanLyPhongNet.R.layout.activity_camera);
        this.setTitle("Phong Net 1");
        VideoView videoView=findViewById(R.id.video_View);
        String videoPath="android.resource://"+getPackageName()+"/"+R.raw.video;
        Uri uri= Uri.parse(videoPath);
        videoView.setVideoURI(uri);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}