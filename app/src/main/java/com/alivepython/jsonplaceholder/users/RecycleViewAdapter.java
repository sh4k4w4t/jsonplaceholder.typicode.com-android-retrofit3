package com.alivepython.jsonplaceholder.users;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alivepython.jsonplaceholder.R;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.onViewHolder>{
    List<User_model_final_3> allUserInfo;

    public RecycleViewAdapter(List<User_model_final_3> allUserInfo) {
        this.allUserInfo = allUserInfo;
    }

    @NonNull
    @Override
    public onViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_model_final, parent,false);
        return new onViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull onViewHolder holder, int position) {
        User_model_final_3 user_model_final_3= allUserInfo.get(position);

        holder.name.setText(user_model_final_3.getName()+"");
        holder.username.setText(user_model_final_3.getUsername()+"");
        holder.email.setText(user_model_final_3.getEmail()+"");
        holder.street.setText(user_model_final_3.getAddress().getStreet()+"");
        holder.city.setText(user_model_final_3.getAddress().getCity()+"");
        holder.lat.setText(user_model_final_3.getAddress().getGeo().getLat()+"");
        holder.phone.setText(user_model_final_3.getPhone()+"");
        holder.website.setText(user_model_final_3.getWebsite()+"");
        holder.companyName.setText(user_model_final_3.getCompany()+"");
        holder.companyCatch.setText(user_model_final_3.getCompany().getCatchPhrase()+"");
        holder.companyBs.setText(user_model_final_3.getCompany().getBs()+"");
        holder.id.setText(user_model_final_3.getId()+"");
        holder.suite.setText(user_model_final_3.getAddress().getSuite()+"");
        holder.zipcode.setText(user_model_final_3.getAddress().getZipcode()+"");
        holder.lng.setText(user_model_final_3.getAddress().getGeo().getLng()+"");

    }

    @Override
    public int getItemCount() {
        if (allUserInfo==null || allUserInfo.size()==0){
            return 0;
        }else {
            return allUserInfo.size();
        }
    }


    public class onViewHolder extends RecyclerView.ViewHolder{
        TextView name,username,email,street,city,lat,phone,website,companyName,companyCatch,companyBs,id,suite,zipcode, lng;

        public onViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.id_name);
            username=itemView.findViewById(R.id.id_username);
            email=itemView.findViewById(R.id.id_email);
            street=itemView.findViewById(R.id.id_street);
            city=itemView.findViewById(R.id.id_city);
            lat=itemView.findViewById(R.id.id_lat);
            phone=itemView.findViewById(R.id.id_phone);
            website=itemView.findViewById(R.id.id_website);
            companyName=itemView.findViewById(R.id.id_company_name);
            companyCatch=itemView.findViewById(R.id.id_catch_parse);
            companyBs=itemView.findViewById(R.id.id_bs);
            id=itemView.findViewById(R.id.id_id);
            suite=itemView.findViewById(R.id.id_suite);
            zipcode=itemView.findViewById(R.id.id_zipcode);
            lng =itemView.findViewById(R.id.id_lag);
        }
    }
}
