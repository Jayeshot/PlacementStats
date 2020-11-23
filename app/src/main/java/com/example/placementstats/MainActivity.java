package com.example.placementstats;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.placementstats.HomeScreen.HomeActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button proceed_next;
    private TextInputEditText phoneNumber;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        if(auth!=null){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }

        proceed_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendOTP();
            }
        });

    }

    private void sendOTP() {
        String phone = phoneNumber.getText().toString();
        if(phone.equals("") || phone.length()!=10){
            Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_SHORT).show();
        }else{

            Intent intent = new Intent(getApplicationContext(),otpVerification.class);
            intent.putExtra("phone",phone);
            startActivity(intent);
            finish();

        }
    }

    private void init() {
        proceed_next = findViewById(R.id.proceed_next);
        phoneNumber = findViewById(R.id.mainActivity_phoneNumber);
        auth = FirebaseAuth.getInstance();
    }
}