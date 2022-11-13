package com.triplek.QuanLyPhongNet.Food;

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
import com.triplek.QuanLyPhongNet.Food.adapter.FoodAdapter;
import com.triplek.QuanLyPhongNet.Food.model.Food;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;

public class FoodView extends AppCompatActivity {
    Button btnFood,btnXoaFood;
    RecyclerView recyclerView;
    ArrayList<Food> foodArrayList;
    FoodAdapter foodApdater;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        addControls();

    }

    private void addControls() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();
        recyclerView =findViewById(R.id.foodList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseFirestore.getInstance();
        foodArrayList=new ArrayList<Food>();
        foodApdater=new FoodAdapter(FoodView.this,foodArrayList);
        recyclerView.setAdapter(foodApdater);
        EventChangeListener();
        btnFood=findViewById(R.id.btnAddFoodLayout);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAddFoodlayout();

            }
        });
        btnXoaFood=findViewById(R.id.btnXoaFoodLayout);
        btnXoaFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXoaFoodlayout();
            }
        });
    }

    private void EventChangeListener() {
        db.collection("food").orderBy("TenMon", Query.Direction.ASCENDING)
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
                                foodArrayList.add(dc.getDocument().toObject(Food.class));
                            }
                            foodApdater.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

    private void openXoaFoodlayout() {
        Intent intent=new Intent(this, deleteFood.class);
        startActivity(intent);
    }

    private void openAddFoodlayout() {
        Intent intent=new Intent(this, addFood.class);
        startActivity(intent);
    }
}