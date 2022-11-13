package com.triplek.QuanLyPhongNet.NhanVien;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.triplek.QuanLyPhongNet.R;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class addNhanVien extends AppCompatActivity {
    EditText ho,ten,tuoi,manv;
    Button btnAdd;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);
        addControls();

    }

    private void addControls() {
        db=FirebaseFirestore.getInstance();
        ho=findViewById(R.id.etxtHo);
        ten=findViewById(R.id.etxtTen);
        tuoi=findViewById(R.id.etxtTuoi);
        manv=findViewById(R.id.etxtMaNV);

        btnAdd=findViewById(R.id.btnAddNV);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ho = ho.getText().toString();
                String Ten = ten.getText().toString();
                String Tuoi = tuoi.getText().toString();
                String MaNV=manv.getText().toString();

                Map<String, Object> nhanvien = new HashMap<>();
                nhanvien.put("Ho",Ho);
                nhanvien.put("Ten",Ten);
                nhanvien.put("Tuoi",Tuoi);
                nhanvien.put("MaNV",MaNV);

                db.collection("nhanvien")
                        .add(nhanvien)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(addNhanVien.this, "Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(addNhanVien.this, "Khong Thanh Cong", Toast.LENGTH_LONG).show();
                            }
                        });


            }
        });
}
}