package com.triplek.QuanLyPhongNet.PC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.triplek.QuanLyPhongNet.R;

import java.util.Timer;
import java.util.TimerTask;

public class PC extends AppCompatActivity {
    TextView name,timertext;
    ImageView imageView;
    Button btnTime;
    boolean timerStarted=false;
    Timer timer;
    TimerTask timerTask;
    Double time=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pc);
        addControls();
    }

    private void addControls() {
        name=findViewById(R.id.griddata);
        imageView=findViewById(R.id.imageView);
        timertext=findViewById(R.id.txtTimer);
        btnTime=findViewById(R.id.btnTime);

        Intent intent=getIntent();
        name.setText(intent.getStringExtra("name"));
        imageView.setImageResource(intent.getIntExtra("image",0));

        timer=new Timer();

    }

    public void resetTapped(View view){

    }
    public void startStopTapped(View view){
        if(timerStarted==false)
        {
            timerStarted=true;
            btnTime.setText("STOP");
            startTime();
        }else {
            timerStarted=false;
            btnTime.setText("START");
            timerTask.cancel();
        }
    }

    private void startTime() {
        timerTask =new TimerTask() {
            @Override
            public void run() {
                {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            time++;
                            timertext.setText(getTimerText());
                        }
                    });
                }

            }
        };
        timer.scheduleAtFixedRate(timerTask,0,10);
    }

    private String getTimerText() {
        int rounded=(int)Math.round(time);
        int seconds=((rounded%86400)%3600)%60;
        int minutes=((rounded%86400)%3600)/60;
        int hours=((rounded%86400)/3600);
        return formatTime(seconds,minutes,hours);
    }

    private String formatTime(int seconds, int minutes, int hours) {
        return  String.format("%02d",hours)+" : "+String.format("%02d",minutes)+" : "+String.format("%02d",seconds);
    }
}