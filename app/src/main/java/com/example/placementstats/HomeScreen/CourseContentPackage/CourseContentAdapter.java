package com.example.placementstats.HomeScreen.CourseContentPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.placementstats.HomeScreen.ProgrammingSolutionWebView;
import com.example.placementstats.R;

import java.util.List;

public class CourseContentAdapter extends RecyclerView.Adapter<CourseContentAdapter.CourseProgramminQuestionViewHolder> {

    private Context context;
    private List<ProgrammingQuestionModel> list;

    public CourseContentAdapter(Context context, List<ProgrammingQuestionModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CourseProgramminQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_programming_question,parent,false);
        return new CourseProgramminQuestionViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull CourseProgramminQuestionViewHolder holder, int position) {
        holder.question.setText(list.get(position).getQuestion());
        holder.topicTag.setText(list.get(position).getTopicTag());
        holder.image.setImageDrawable(context.getDrawable(R.drawable.que1));
        holder.url = list.get(position).getUrl();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<ProgrammingQuestionModel> list){
        this.list = list;
    }

    public class CourseProgramminQuestionViewHolder extends RecyclerView.ViewHolder{

        public TextView question,topicTag,seeMore,solution;
        public ImageView image;
        public String url;
        int flag=0;

        public CourseProgramminQuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.programming_question_question_title);
            topicTag = itemView.findViewById(R.id.programming_question_topic_tag);
            seeMore = itemView.findViewById(R.id.programming_question_SeeMore);
            solution = itemView.findViewById(R.id.programming_question_solution);
            image = itemView.findViewById(R.id.programming_question_image);

            seeMore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(flag==0){
                        flag=1;
                        image.setVisibility(View.VISIBLE);
                    }else{
                        flag=0;
                        image.setVisibility(View.GONE);
                    }

                }
            });

            solution.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ProgrammingSolutionWebView.class);
                    intent.putExtra("url",url);
                    context.startActivity(intent);
                }
            });

        }
    }

}
