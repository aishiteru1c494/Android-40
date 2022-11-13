package com.triplek.QuanLyPhongNet.Game.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.triplek.QuanLyPhongNet.Game.model.Game;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;


public class GameApdater extends RecyclerView.Adapter<GameApdater.GameViewHolder>{
    Context context;
    ArrayList<Game> gameArrayList;


    public GameApdater(Context context, ArrayList<Game> gameArrayList) {
        this.context = context;
        this.gameArrayList = gameArrayList;
    }

    @NonNull
    @Override
    public GameApdater.GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.game_item,parent,false);

        return new GameApdater.GameViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GameApdater.GameViewHolder holder, int position) {
        Game game=gameArrayList.get(position);

        holder.tengame.setText(game.getTenGame());
        holder.theloai.setText(game.getTheLoai());

        Glide.with(holder.imageView.getContext()).load(gameArrayList.get(position).getImageUrl()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return gameArrayList.size();
    }

    public static class GameViewHolder extends RecyclerView.ViewHolder{
        TextView tengame,theloai;
        ImageView imageView;
        public GameViewHolder(@NonNull View itemView) {
            super(itemView);
            tengame=itemView.findViewById(R.id.txtTenGame);
            theloai=itemView.findViewById(R.id.txtTheLoai);
            imageView=itemView.findViewById(R.id.GameImage);
        }
    }
}
