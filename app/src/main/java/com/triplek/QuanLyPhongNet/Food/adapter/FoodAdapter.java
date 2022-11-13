package com.triplek.QuanLyPhongNet.Food.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.triplek.QuanLyPhongNet.Food.model.Food;

import com.triplek.QuanLyPhongNet.Game.model.Game;
import com.triplek.QuanLyPhongNet.R;


import java.util.ArrayList;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{
    Context context;
    ArrayList<Food> foodArrayList;

    public FoodAdapter(Context context, ArrayList<Food> foodArrayList) {
        this.context = context;
        this.foodArrayList = foodArrayList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.food_item,parent,false);

        return new FoodAdapter.FoodViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food=foodArrayList.get(position);

        holder.tenmon.setText(food.getTenMon());
        holder.gia.setText(food.getGia());
        Glide.with(holder.imageView.getContext()).load(foodArrayList.get(position).getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }


    public static class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView tenmon,gia;
        ImageView imageView;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            tenmon=itemView.findViewById(R.id.txtTenMon);
            gia=itemView.findViewById(R.id.txtGia);
            imageView=itemView.findViewById(R.id.FoodImage);
        }
    }
}
