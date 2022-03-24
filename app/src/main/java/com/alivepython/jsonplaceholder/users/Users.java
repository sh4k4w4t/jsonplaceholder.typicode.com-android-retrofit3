package com.alivepython.jsonplaceholder.users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Users extends AppCompatActivity {
    RecyclerView recycleviewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        recycleviewID = findViewById(R.id.recycleviewID);
        recycleviewID.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit_Instance instance= retrofit.create(Retrofit_Instance.class);
        Call<List<User_model_final_3>> call= instance.getFullDetails();

        call.enqueue(new Callback<List<User_model_final_3>>() {
            @Override
            public void onResponse(Call<List<User_model_final_3>> call, Response<List<User_model_final_3>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Success", Toast.LENGTH_SHORT).show();
                    List<User_model_final_3> allUser= response.body();
                    RecycleViewAdapter adapter= new RecycleViewAdapter(allUser);
                    recycleviewID.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User_model_final_3>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}