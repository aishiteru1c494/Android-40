package com.triplek.QuanLyPhongNet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.triplek.QuanLyPhongNet.Camera.Camera;
import com.triplek.QuanLyPhongNet.Food.FoodView;
import com.triplek.QuanLyPhongNet.Game.GameView;
import com.triplek.QuanLyPhongNet.NhanVien.NhanVienview;
import com.triplek.QuanLyPhongNet.PC.TinhTrangMay;

public class MainActivity extends AppCompatActivity {
    ImageView imgFood,imgMangager,imgPC,imgGame,imgCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }
    private void addControls() {
        imgFood=findViewById(R.id.imgFood);
        imgMangager=findViewById(R.id.imgMangager);
        imgGame=findViewById(R.id.imgGame);
        imgPC=findViewById(R.id.imgPC);
        imgCamera=findViewById(R.id.imgCamera);
        imgCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCameralayOut();
            }
        });
        imgFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFoodlayout();
            }
        });
        imgPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPclayout();
            }
        });
        imgMangager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManagerlayout();
            }
        });
        imgGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamelayout();
            }
        });
    }

    private void openCameralayOut() {
        Intent intent=new Intent(this, Camera.class);
        startActivity(intent);
    }

    private void openGamelayout() {
        Intent intent=new Intent(this, GameView.class);
        startActivity(intent);
    }

    private void openManagerlayout() {
        Intent intent=new Intent(this, NhanVienview.class);
        startActivity(intent);
    }

    private void openFoodlayout() {
        Intent intent=new Intent(this, FoodView.class);
        startActivity(intent);
    }

    private void openPclayout() {
        Intent intent=new Intent(this, TinhTrangMay.class);
        startActivity(intent);
    }
}