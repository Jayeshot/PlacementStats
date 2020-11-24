package com.example.placementstats.HomeScreen.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.placementstats.HomeScreen.Models.ValuableTIpModel;
import com.example.placementstats.R;

import java.util.List;

public class ValuableTipAdapter extends RecyclerView.Adapter<ValuableTipAdapter.ValuableTipViewHolder> {

    private Context context;
    private List<ValuableTIpModel> list;

    public ValuableTipAdapter(Context context, List<ValuableTIpModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ValuableTipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_valuable_tip,parent,false);
        return new ValuableTipViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ValuableTipViewHolder holder, int position) {
        holder.userName.setText(list.get(position).getUserName());
        holder.collegeName.setText(list.get(position).getUserProfile());
        holder.userTip.setText(list.get(position).getUserTip());
        holder.upVote.setText(list.get(position).getUpVote()+"");
        holder.downVote.setText(list.get(position).getDownVote()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<ValuableTIpModel> list){
        this.list = list;
    }

    public class ValuableTipViewHolder extends RecyclerView.ViewHolder{

        public TextView userName,collegeName,userTip,upVote,downVote;
        public ImageView upVote_icon,downVote_icon;

        public ValuableTipViewHolder(@NonNull View itemView) {
            super(itemView);
            init(itemView);

            upVote_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            downVote_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

        }

        private void init(View itemView) {
            userName = itemView.findViewById(R.id.raw_valuableTip_userName);
            collegeName = itemView.findViewById(R.id.raw_valuableTip_userProfile);
            userTip = itemView.findViewById(R.id.raw_valuableTip_userTip);
            upVote = itemView.findViewById(R.id.raw_valuableTip_upVote);
            downVote = itemView.findViewById(R.id.raw_valuableTip_downVote);
            upVote_icon = itemView.findViewById(R.id.raw_valuableTip_upVote_icon);
            downVote_icon = itemView.findViewById(R.id.raw_valuableTip_downVote_icon);
        }
    }

}
