package com.alivepython.jsonplaceholder.comments_postid_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;
import com.alivepython.jsonplaceholder.posts_1_comments.ModelClass3;
import com.alivepython.jsonplaceholder.posts_1_comments.Post_1_cmt_adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Comment_post_id_1 extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_post_id1);

        recyclerView= findViewById(R.id.comment_postid_2_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit_Instance instance= retrofit.create(Retrofit_Instance.class);
        Call<List<ModelClass3>> all1= instance.allPostIDList(1);

//        https://jsonplaceholder.typicode.com/comments?postId=1
//        https://jsonplaceholder.typicode.com/posts/1/comments

        all1.enqueue(new Callback<List<ModelClass3>>() {
            @Override
            public void onResponse(Call<List<ModelClass3>> call, Response<List<ModelClass3>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response success", Toast.LENGTH_SHORT).show();
                    List<ModelClass3> allList= response.body();
                    Post_1_cmt_adapter adapter= new Post_1_cmt_adapter(allList);
                    recyclerView.setAdapter(adapter);
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