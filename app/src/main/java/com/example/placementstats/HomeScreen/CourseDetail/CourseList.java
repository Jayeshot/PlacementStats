package com.example.placementstats.HomeScreen.CourseDetail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.placementstats.HomeScreen.CourseDetail.Adapter.CourseItemListAdapter;
import com.example.placementstats.HomeScreen.Models.CourseContentItemModel;
import com.example.placementstats.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CourseList extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private List<CourseContentItemModel> list;
    private LinearLayoutManager layoutManager;
    private CourseItemListAdapter adapter;
    private String courseName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        init();

        getData();

    }

    private void getData() {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(getString(R.string.Courses)).child(courseName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds: snapshot.getChildren()){
                    CourseContentItemModel model = ds.getValue(CourseContentItemModel.class);
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

        toolbar = findViewById(R.id.courseList_toolbar);
        recyclerView = findViewById(R.id.courseList_recyclerView);
        list = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CourseItemListAdapter(this,list,courseName);
    }
}