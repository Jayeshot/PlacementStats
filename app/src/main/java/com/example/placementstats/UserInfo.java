package com.example.placementstats;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.placementstats.HomeScreen.HomeActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInfo extends AppCompatActivity {

    private Button submitUserInfo;
    private TextInputEditText userName,collegeName,cgpa;
    private int flagGender=0;
    private TextView skip;
    private FirebaseUser user;
    private DatabaseReference databaseReference;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        init();

        submitUserInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUserInfo();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel model = new UserModel(user.getUid(),phone);
                databaseReference.child(String.valueOf(R.string.UserInfo)).child(user.getUid()).setValue(model);

                Intent intent = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intent);

            }
        });

    }

    private void saveUserInfo() {
        final String userName_str = userName.getText().toString();
        final String collge_str = collegeName.getText().toString();
        final String cgpa_str = cgpa.getText().toString();
        //TODO: check conditions

        UserModel model = new UserModel(user.getUid(),userName_str,phone,collge_str,cgpa_str,flagGender);
        databaseReference.child(String.valueOf(R.string.UserInfo)).child(user.getUid()).setValue(model);

        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(intent);
    }

    private void init() {

        Intent intent = getIntent();
        phone = intent.getStringExtra("phone");
        submitUserInfo = findViewById(R.id.submit_user_info);
        skip = findViewById(R.id.userInfo_skip);
        userName = findViewById(R.id.userInfo_userName);
        collegeName = findViewById(R.id.userInfo_userCollege);
        cgpa = findViewById(R.id.userInfo_userCGPA);
        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}