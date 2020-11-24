package com.example.placementstats.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.placementstats.HomeScreen.Models.ValuableTIpModel;
import com.example.placementstats.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

public class addTip extends AppCompatActivity {

    private EditText tip,profile;
    private Button add;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tip);

        init();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addValuableTip();
            }
        });


    }

    private void addValuableTip() {
        final String tip_text = tip.getText().toString();
        final String profile_text = profile.getText().toString();
        final String tipId = System.currentTimeMillis()+"";
        ValuableTIpModel model = new ValuableTIpModel(tipId,"userName",profile_text,tip_text,0,0);
        databaseReference.child(getString(R.string.ValuableTip)).child(tipId).setValue(model);
    }

    private void init() {
        tip = findViewById(R.id.addTip_tip);
        profile = findViewById(R.id.addTip_college);
        add = findViewById(R.id.addTip_add);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}