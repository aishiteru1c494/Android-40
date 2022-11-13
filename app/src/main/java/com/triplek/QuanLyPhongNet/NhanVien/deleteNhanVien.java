package com.triplek.QuanLyPhongNet.NhanVien;

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
import com.triplek.QuanLyPhongNet.R;

public class deleteNhanVien extends AppCompatActivity {
    Button btndelete;
    EditText etxtTen;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_nhan_vien);
        addControls();
    }

    private void addControls() {
        db=FirebaseFirestore.getInstance();
        btndelete=findViewById(R.id.btnDeleteNV);
        etxtTen=findViewById(R.id.etxtXoaTen);
        
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ho=etxtTen.getText().toString();
                etxtTen.setText("");
                DeleteData(Ho);
            }
        });
    }

    private void DeleteData(String ho) {
        db.collection("nhanvien")
                .whereEqualTo("MaNV",ho)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()&&!task.getResult().isEmpty()){
                            DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                            String documentID=documentSnapshot.getId();
                            db.collection("nhanvien")
                                    .document(documentID).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {
                                            Toast.makeText(deleteNhanVien.this,"Xoa Thanh Cong",Toast.LENGTH_SHORT).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(deleteNhanVien.this,"Xoa Khong Thanh Cong",Toast.LENGTH_SHORT).show();
                                        }
                                    });
                        }else{
                            Toast.makeText(deleteNhanVien.this,"Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}