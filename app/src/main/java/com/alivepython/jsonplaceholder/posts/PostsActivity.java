package com.alivepython.jsonplaceholder.posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsActivity extends AppCompatActivity {
    Retrofit_Instance retrofit_instance;

    RecyclerView postRecycleViewId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        postRecycleViewId= findViewById(R.id.postRecycleViewId);
        postRecycleViewId.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit_instance= retrofit.create(Retrofit_Instance.class);

        Call<List<ModelClass>> call= retrofit_instance.getPostsData();
        call.enqueue(new Callback<List<ModelClass>>(){
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "posts response Success", Toast.LENGTH_SHORT).show();

                    List<ModelClass> allList= response.body();
                    Posts_recycleView_adapter adapter= new Posts_recycleView_adapter(allList);
                    postRecycleViewId.setAdapter(adapter);



                    for (ModelClass modelClass : allList){
                        Log.e("User Id", String.valueOf(modelClass.getUserId()));
                        Log.e("Id", String.valueOf(modelClass.getId()));
                        Log.e("Title", modelClass.getTitle());
                        Log.e("Body", modelClass.getBody());
                    }



                }
                else {
                    Toast.makeText(getApplicationContext(), "posts response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "posts failure failed", Toast.LENGTH_SHORT).show();

            }
        });


    }
}