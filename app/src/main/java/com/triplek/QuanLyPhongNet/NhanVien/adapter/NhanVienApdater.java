package com.triplek.QuanLyPhongNet.NhanVien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.triplek.QuanLyPhongNet.NhanVien.model.NhanVien;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;

public class NhanVienApdater extends RecyclerView.Adapter<NhanVienApdater.MyViewHolder> {
    Context context;
    ArrayList<NhanVien>nhanvienArrayList;


    public NhanVienApdater(Context context, ArrayList<NhanVien> nhanvienArrayList) {
        this.context = context;
        this.nhanvienArrayList = nhanvienArrayList;
    }

    @NonNull
    @Override
    public NhanVienApdater.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.nhanvien_item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NhanVienApdater.MyViewHolder holder, int position) {
            NhanVien nhanvien=nhanvienArrayList.get(position);

            holder.ho.setText(nhanvien.getHo());
            holder.ten.setText(nhanvien.getTen());
            holder.tuoi.setText(nhanvien.getTuoi());
            holder.mnv.setText(nhanvien.getMaNV());
    }

    @Override
    public int getItemCount() {
        return nhanvienArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView ho,ten,tuoi,mnv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ho=itemView.findViewById(R.id.txtTenMon);
            ten=itemView.findViewById(R.id.txtGia);
            tuoi=itemView.findViewById(R.id.txtTuoi);
            mnv=itemView.findViewById(R.id.txt_MaNV);
        }
    }


}

