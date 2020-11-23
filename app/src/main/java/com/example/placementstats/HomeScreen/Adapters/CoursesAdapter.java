package com.example.placementstats.HomeScreen.Adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.placementstats.HomeScreen.CourseDetail.CourseList;
import com.example.placementstats.HomeScreen.Models.CourseContentItemModel;
import com.example.placementstats.HomeScreen.Models.CourseModel;
import com.example.placementstats.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>{

    List<CourseModel> list;
    Context context;


    public CoursesAdapter(List<CourseModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_course_list,parent,false);
        return new CourseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.courseName.setText(list.get(position).getId());
        getItemData(holder,position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<CourseModel> list){
        this.list = list;
    }

    public void getItemData(final CourseViewHolder holder, int position){

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(context.getString(R.string.Courses)).child(list.get(position).getId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("ddddd",snapshot.getChildrenCount()+"");

                for (DataSnapshot ds: snapshot.getChildren()){
                    Log.d("ddddd",ds.getValue()+"");
                    CourseContentItemModel model = ds.getValue(CourseContentItemModel.class);
                    holder.courseContentList.add(model);
                }
                holder.adapter.addData(holder.courseContentList);
                holder.recyclerView.setAdapter(holder.adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public class CourseViewHolder extends RecyclerView.ViewHolder{

        private TextView courseName;
        private Button viewAll;
        private RecyclerView recyclerView;
        private CourseContentAdapter adapter;
        private List<CourseContentItemModel> courseContentList;


        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);

            viewAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CourseList.class);
                    intent.putExtra("courseName",courseName.getText().toString());
                    context.startActivity(intent);
                }
            });



        }

        private void init(View itemView) {
            courseName = itemView.findViewById(R.id.course_name);
            viewAll = itemView.findViewById(R.id.viewAll);
            recyclerView = itemView.findViewById(R.id.home_course_recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
            courseContentList = new ArrayList<>();
            adapter = new CourseContentAdapter(courseContentList,context);
        }
    }


}
