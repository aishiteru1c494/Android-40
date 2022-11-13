package com.triplek.QuanLyPhongNet.Food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.triplek.QuanLyPhongNet.Game.deleteGame;
import com.triplek.QuanLyPhongNet.R;

public class deleteFood extends AppCompatActivity {
    Button btndelete;
    EditText etxtTenMonAn;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_food);
        addControl();
    }

    private void addControl() {
        db=FirebaseFirestore.getInstance();
        btndelete=findViewById(R.id.btnDeleteFood);
        etxtTenMonAn=findViewById(R.id.etxtXoaTenMonAn);

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String TenMonAn=etxtTenMonAn.getText().toString();
                etxtTenMonAn.setText("");
                DeleteData(TenMonAn);
            }
        });
    }

    private void DeleteData(String tenMonAn) {
        db.collection("food")
                .whereEqualTo("TenMon",tenMonAn)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()&&!task.getResult().isEmpty()){
                            DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                            String documentID=documentSnapshot.getId();
                            db.collection("food")
                                    .document(documentID).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(deleteFood.this,"Xoa Thanh Cong",Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(deleteFood.this,"Xoa Khong Thanh Cong",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }else{
                            Toast.makeText(deleteFood.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}