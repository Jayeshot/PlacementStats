package com.example.placementstats.HomeScreen.CourseContentPackage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.placementstats.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CourseContent extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseContentAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<ProgrammingQuestionModel> list;
    private Button btn;
    private String courseName,courseId;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_content);

        init();
        getData();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseContent.this,AddQuestion.class);
                intent.putExtra(getString(R.string.CourseName),courseName);
                intent.putExtra(getString(R.string.CourseId),courseId);
                startActivity(intent);

            }
        });

    }

    private void getData() {
        databaseReference.child(courseName).child(courseId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds:snapshot.getChildren()){
                    ProgrammingQuestionModel model = ds.getValue(ProgrammingQuestionModel.class);
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
        Intent intent = getIntent();
        courseName = intent.getStringExtra(getString(R.string.CourseName));
        courseId = intent.getStringExtra(getString(R.string.CourseId));
        recyclerView = findViewById(R.id.course_content_recyclerView);
        list = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CourseContentAdapter(this,list);
        btn = findViewById(R.id.course_content_btn);
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }
}