package com.triplek.QuanLyPhongNet.Food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.triplek.QuanLyPhongNet.Game.addGame;
import com.triplek.QuanLyPhongNet.R;

import java.util.HashMap;
import java.util.Map;

public class addFood extends AppCompatActivity {
    EditText tenMonAn,gia;
    Button btnAdd;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);
        addControls();

    }

    private void addControls() {
        db=FirebaseFirestore.getInstance();
        tenMonAn=findViewById(R.id.etxtTenMonAn);
        gia=findViewById(R.id.etxtGia);


        btnAdd=findViewById(R.id.btnAddFood);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TenMonAn = tenMonAn.getText().toString();
                String Gia = gia.getText().toString();

                Map<String, Object> game = new HashMap<>();
                game.put("TenMon",TenMonAn);
                game.put("Gia",Gia);



                db.collection("food")
                        .add(game)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(addFood.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addFood.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        });


            }
        });
    }
}