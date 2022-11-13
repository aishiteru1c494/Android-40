package com.triplek.QuanLyPhongNet.Game;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.triplek.QuanLyPhongNet.Game.adapter.GameApdater;
import com.triplek.QuanLyPhongNet.Game.model.Game;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;

public class GameView extends AppCompatActivity {
    Button btngame,btnXoaGame;
    RecyclerView recyclerView;
    ArrayList<Game> gameArrayList;
    GameApdater gameApdater;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        addControls();
    }

    private void addControls() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();
        recyclerView =findViewById(R.id.gameList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseFirestore.getInstance();
        gameArrayList=new ArrayList<Game>();
        gameApdater=new GameApdater(GameView.this,gameArrayList);
        recyclerView.setAdapter(gameApdater);
        EventChangeListener();
        btngame=findViewById(R.id.btnAddGameLayout);
        btngame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAddGamelayout();

            }
        });
        btnXoaGame=findViewById(R.id.btnXoaGameLayout);
        btnXoaGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXoaGamelayout();
            }
        });
    }

    private void EventChangeListener() {
        db.collection("game").orderBy("TenGame", Query.Direction.ASCENDING)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error !=null){
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for (DocumentChange dc:value.getDocumentChanges()){
                            if(dc.getType()==DocumentChange.Type.ADDED){
                                gameArrayList.add(dc.getDocument().toObject(Game.class));
                            }
                            gameApdater.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

    private void openXoaGamelayout() {
        Intent intent=new Intent(this, deleteGame.class);
        startActivity(intent);
    }

    private void openAddGamelayout() {
        Intent intent=new Intent(this, addGame.class);
        startActivity(intent);
    }
}