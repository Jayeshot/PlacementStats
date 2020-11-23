package com.example.placementstats.HomeScreen.CourseContentPackage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.placementstats.R;

import java.util.ArrayList;
import java.util.List;

public class CourseContent extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CourseContentAdapter adapter;
    private LinearLayoutManager layoutManager;
    private List<ProgrammingQuestionModel> list;
    private Button btn;

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
                startActivity(intent);

            }
        });

    }

    private void getData() {
        for(int i=0;i<10;i++){
            ProgrammingQuestionModel model = new ProgrammingQuestionModel("1.Given an array of size N containing 0s, 1s, and 2s; sort the array in ascending order.","Array","https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/","https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/");
            list.add(model);
        }
        Toast.makeText(getApplicationContext(),list.size()+"",Toast.LENGTH_SHORT).show();
        adapter.setData(list);
        recyclerView.setAdapter(adapter);

    }

    private void init() {
        recyclerView = findViewById(R.id.course_content_recyclerView);
        list = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new CourseContentAdapter(this,list);
        btn = findViewById(R.id.course_content_btn);
    }
}