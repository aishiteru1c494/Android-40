package com.triplek.QuanLyPhongNet.PC.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.triplek.QuanLyPhongNet.PC.model.MayTinh;
import com.triplek.QuanLyPhongNet.R;

import java.util.List;

public class MayTinhadapter extends ArrayAdapter<MayTinh> {
    String[] pcName={"PC01","PC02","PC03","PC04","PC05","PC06","PC07","PC08","PC09","PC10"};
    int[] pcImage={R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc,R.drawable.pc};
    Activity context;
    int resource;
    @NonNull
    List<MayTinh> objects;
    public MayTinhadapter(@NonNull Activity context, int resource, @NonNull List<MayTinh> objects) {
        super(context, resource, objects);
        this.context=context;
        this.objects=objects;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View row, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        row=layoutInflater.inflate(this.resource,null);

        TextView name=row.findViewById(R.id.TenGame);
        ImageView imageView=row.findViewById(R.id.FoodImage);

        MayTinh mayTinh=this.objects.get(position);
        name.setText(mayTinh.get_maPC());
        imageView.setImageResource(mayTinh.get_LinkAnh());

        return row;
    }
}
