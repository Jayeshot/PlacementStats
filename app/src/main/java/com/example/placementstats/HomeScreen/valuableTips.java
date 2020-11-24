package com.example.placementstats.HomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.placementstats.HomeScreen.Adapters.ValuableTipAdapter;
import com.example.placementstats.HomeScreen.Models.ValuableTIpModel;
import com.example.placementstats.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class valuableTips extends AppCompatActivity {

    private TextView addTips;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<ValuableTIpModel> list;
    private ValuableTipAdapter adapter;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valuable_tips);

        init();

        addTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(valuableTips.this,addTip.class);
                startActivity(intent);
            }
        });

        getData();

    }

    private void getData() {
        databaseReference.child(getString(R.string.ValuableTip)).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    ValuableTIpModel model = ds.getValue(ValuableTIpModel.class);
                    list.add(model);
                }
                adapter.setData(list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void init() {
        addTips = findViewById(R.id.valuableTips_addTip);
        toolbar = findViewById(R.id.valuableTips_toolbar);
        recyclerView = findViewById(R.id.valuableTips_recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        adapter = new ValuableTipAdapter(this,list);
        databaseReference = FirebaseDatabase.getInstance().getReference();

    }
}