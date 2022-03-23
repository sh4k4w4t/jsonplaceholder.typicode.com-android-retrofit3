package com.alivepython.jsonplaceholder.posts_1_comments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Posts_1_comments extends AppCompatActivity {
    RecyclerView three_recycle;
    List<ModelClass3> list3 = new ArrayList<>();
    Post_1_cmt_adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts1_comments);

        three_recycle= findViewById(R.id.three_recycle);
        three_recycle.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit_Instance instance= retrofit.create(Retrofit_Instance.class);
        Call<List<ModelClass3>> call= instance.allModelList(2);
        call.enqueue(new Callback<List<ModelClass3>>() {
            @Override
            public void onResponse(Call<List<ModelClass3>> call, Response<List<ModelClass3>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response success", Toast.LENGTH_SHORT).show();
                    list3= response.body();
                    adapter= new Post_1_cmt_adapter(list3);
                    three_recycle.setAdapter(adapter);


                }
                else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass3>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}