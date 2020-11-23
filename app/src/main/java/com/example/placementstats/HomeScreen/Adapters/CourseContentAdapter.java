package com.example.placementstats.HomeScreen.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.placementstats.HomeScreen.Models.CourseContentItemModel;
import com.example.placementstats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CourseContentAdapter extends RecyclerView.Adapter<CourseContentAdapter.CourseContentViewHolder>{

    private List<CourseContentItemModel> list;
    private Context context;

    public CourseContentAdapter(List<CourseContentItemModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CourseContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_course_content_list,parent,false);
        return new CourseContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseContentViewHolder holder, int position) {
        Picasso.get().load(Uri.parse(list.get(position).getThumbnail())).into(holder.courseContentItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addData(List<CourseContentItemModel> list){
        this.list = list;
    }



    public class CourseContentViewHolder extends RecyclerView.ViewHolder{

        private ImageView courseContentItem;

        public CourseContentViewHolder(@NonNull View itemView) {
            super(itemView);
            courseContentItem = itemView.findViewById(R.id.course_content_item);
        }
    }

}
