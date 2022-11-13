package com.triplek.QuanLyPhongNet.NhanVien;

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
import com.triplek.QuanLyPhongNet.NhanVien.adapter.NhanVienApdater;
import com.triplek.QuanLyPhongNet.NhanVien.model.NhanVien;
import com.triplek.QuanLyPhongNet.R;

import java.util.ArrayList;

public class NhanVienview extends AppCompatActivity {
    Button button,button1;
    RecyclerView recyclerView;
    ArrayList<NhanVien>nhanVienArrayList;
    NhanVienApdater nhanVienApdater;
    FirebaseFirestore db;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        addControls();

    }

    private void addControls() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching Data...");
        progressDialog.show();
        recyclerView =findViewById(R.id.nhanvienList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseFirestore.getInstance();
        nhanVienArrayList=new ArrayList<NhanVien>();
        nhanVienApdater=new NhanVienApdater(NhanVienview.this,nhanVienArrayList);
        recyclerView.setAdapter(nhanVienApdater);
        EventChangeListener();
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openAddNhanVienlayout();

            }
        });
        button1=findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openXoaNhanVienlayout();
            }
        });
    }

    private void openXoaNhanVienlayout() {
        Intent intent=new Intent(this, deleteNhanVien.class);
        startActivity(intent);
    }

    private void EventChangeListener() {
        db.collection("nhanvien").orderBy("MaNV", Query.Direction.ASCENDING)
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
                                nhanVienArrayList.add(dc.getDocument().toObject(NhanVien.class));
                            }
                            nhanVienApdater.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

    private void openAddNhanVienlayout() {
        Intent intent=new Intent(this, addNhanVien.class);
        startActivity(intent);
    }


}