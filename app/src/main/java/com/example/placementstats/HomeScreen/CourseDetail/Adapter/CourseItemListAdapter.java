package com.example.placementstats.HomeScreen.CourseDetail.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.placementstats.HomeScreen.CourseContentPackage.CourseContent;
import com.example.placementstats.HomeScreen.Models.CourseContentItemModel;
import com.example.placementstats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CourseItemListAdapter extends RecyclerView.Adapter<CourseItemListAdapter.CourseItemViewHolder> {

    private Context context;
    private List<CourseContentItemModel> list;
    private String courseName;

    public CourseItemListAdapter(Context context, List<CourseContentItemModel> list, String courseName) {
        this.context = context;
        this.list = list;
        this.courseName = courseName;
    }

    public CourseItemListAdapter(Context context, List<CourseContentItemModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CourseItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_course_item_list_adapter,parent,false);
        return new CourseItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseItemViewHolder holder, int position) {
        Picasso.get().load(Uri.parse(list.get(position).getThumbnail())).placeholder(R.mipmap.ic_launcher).into(holder.image);
        holder.courseId = list.get(position).getId();
    }

    public void setData(List<CourseContentItemModel> list){
        this.list = list;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CourseItemViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private String courseId;

        public CourseItemViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.raw_course_item_list_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, CourseContent.class);
                    intent.putExtra(context.getString(R.string.CourseName),courseName);
                    intent.putExtra(context.getString(R.string.CourseId),courseId);
                    context.startActivity(intent);
                }
            });

        }
    }
}
