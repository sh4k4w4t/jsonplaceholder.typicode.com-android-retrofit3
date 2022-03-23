package com.alivepython.jsonplaceholder.posts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.jsonplaceholder.R;

import org.w3c.dom.Text;

import java.util.List;

public class Posts_recycleView_adapter extends RecyclerView.Adapter<Posts_recycleView_adapter.viewHolder>{
    List<ModelClass> allList;

    public Posts_recycleView_adapter(List<ModelClass> allList) {
        this.allList = allList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.posts_recycle_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelClass tempModelClass= allList.get(position);

        holder.user_id.setText(tempModelClass.getUserId());
        holder.id.setText(tempModelClass.getId());
        holder.title.setText(tempModelClass.getTitle());
        holder.body.setText(tempModelClass.getBody());
    }

    @Override
    public int getItemCount() {
        if (allList==null || allList.size()==0){
            return 0;
        }
        else {
            return allList.size();
        }
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView user_id,id,title,body;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            user_id= itemView.findViewById(R.id.posts_userID);
            id= itemView.findViewById(R.id.posts_id);
            title= itemView.findViewById(R.id.posts_title);
            body= itemView.findViewById(R.id.posts_body);
        }
    }
}
