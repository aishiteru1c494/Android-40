package com.triplek.QuanLyPhongNet.Game;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.triplek.QuanLyPhongNet.NhanVien.addNhanVien;
import com.triplek.QuanLyPhongNet.R;

import java.util.HashMap;
import java.util.Map;

public class addGame extends AppCompatActivity {
    EditText tenGame,theLoai;
    Button btnAdd;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_game);
        addControls();


    }

    private void addControls() {
        db=FirebaseFirestore.getInstance();
        tenGame=findViewById(R.id.etxtTenGame);
        theLoai=findViewById(R.id.etxtTheLoai);


        btnAdd=findViewById(R.id.btnAddGame);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TenGame = tenGame.getText().toString();
                String TheLoai = theLoai.getText().toString();

                Map<String, Object> game = new HashMap<>();
                game.put("TenGame",TenGame);
                game.put("TheLoai",TheLoai);


                db.collection("game")
                        .add(game)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(addGame.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addGame.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        });


            }
        });
    }
}