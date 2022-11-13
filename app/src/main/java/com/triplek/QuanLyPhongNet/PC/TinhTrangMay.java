package com.triplek.QuanLyPhongNet.PC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import com.triplek.QuanLyPhongNet.PC.adapter.MayTinhadapter;
import com.triplek.QuanLyPhongNet.PC.model.MayTinh;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;

public class TinhTrangMay extends AppCompatActivity {
    GridView gridView;
    MayTinhadapter mayTinhadapter;
    String[] pcName={"PC01","PC02","PC03","PC04","PC05","PC06","PC07","PC08","PC09","PC10"};
    int[] pcImage={R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc};
    int[] pcImage2={R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh,R.drawable.maytinh};
    Button btnStart;
    ArrayList<MayTinh> dsMayTinh=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinh_trang_may);
        gridView=findViewById(R.id.gridViewPC);
        CustomAdapter customAdapter=new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),PC.class);
                intent.putExtra("name",pcName[position]);
                intent.putExtra("image",pcImage2[position]);
                startActivity(intent);
            }
        });
    }

    private void addControls() {

    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return pcImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View row, ViewGroup parent) {
            View row1=getLayoutInflater().inflate(R.layout.pc_item,null);
            TextView name=row1.findViewById(R.id.TenGame);
            ImageView imageView=row1.findViewById(R.id.FoodImage);
            name.setText(pcName[position]);
            imageView.setImageResource(pcImage[position]);
            return row1;
        }
    }
}


