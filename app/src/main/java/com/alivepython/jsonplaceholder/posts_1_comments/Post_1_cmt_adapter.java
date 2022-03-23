package com.alivepython.jsonplaceholder.posts_1_comments;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.jsonplaceholder.R;

import java.util.List;

public class Post_1_cmt_adapter extends RecyclerView.Adapter<Post_1_cmt_adapter.viewHolder>{
    List<ModelClass3> all3;

    public Post_1_cmt_adapter(List<ModelClass3> all3) {
        this.all3 = all3;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_1_comment_recycleview,parent,false);
        return new viewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelClass3 temp= all3.get(position);

        holder.postId3.setText(Integer.toString(temp.getPostId()));
        holder.id3.setText(Integer.toString(temp.getId()));
        holder.name3.setText(temp.getName());
        holder.email3.setText(temp.getEmail());
        holder.body3.setText(temp.getBody());

    }

    @Override
    public int getItemCount() {
        if (all3==null||all3.size()==0){return 0;}
        else {return all3.size();}
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView postId3, id3, name3, email3, body3;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            postId3 = itemView.findViewById(R.id.three_postid);
            id3 = itemView.findViewById(R.id.three_id);
            name3 = itemView.findViewById(R.id.three_name);
            email3 = itemView.findViewById(R.id.three_email);
            body3 = itemView.findViewById(R.id.three_body);
        }
    }
}
