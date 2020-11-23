package com.example.placementstats.HomeScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.placementstats.HomeScreen.Adapters.CoursesAdapter;
import com.example.placementstats.HomeScreen.Models.CourseModel;
import com.example.placementstats.R;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CoursesAdapter adapter;
    private List<CourseModel> list;
    private Toolbar toolbar;
    private TextView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();
    //    setSupportActionBar(toolbar);
    //    getActionBar().show();
        toolbar.setTitle("Course List");

        getCourses();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,tempAddCourse.class);
                startActivity(intent);
            }
        });

    }

    private void getCourses() {

        CourseModel model1 = new CourseModel("Ds and Algo");
        CourseModel model2 = new CourseModel("Java");
        CourseModel model3 = new CourseModel("Operating System");
        CourseModel model4 = new CourseModel("Networking");
        CourseModel model5 = new CourseModel("HR interview questions");
        CourseModel model6 = new CourseModel("Placement Experience");
        CourseModel model7 = new CourseModel("Stats");
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        list.add(model5);
        list.add(model6);
        list.add(model7);

        adapter.addData(list);
        recyclerView.setAdapter(adapter);
    }

    private void init() {
        toolbar = findViewById(R.id.home_toolbar);
        recyclerView = findViewById(R.id.home_recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        list = new ArrayList<>();
        adapter = new CoursesAdapter(list,this);
        recyclerView.setHasFixedSize(true);

        add = findViewById(R.id.home_addCourse);


    }
}