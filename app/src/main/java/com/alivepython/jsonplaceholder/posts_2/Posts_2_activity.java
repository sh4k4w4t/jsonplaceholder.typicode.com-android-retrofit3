package com.alivepython.jsonplaceholder.posts_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;
import com.alivepython.jsonplaceholder.posts.ModelClass;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Posts_2_activity extends AppCompatActivity {
    TextView userID, id,title,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts2);

        userID= findViewById(R.id.posts_userID);
        id = findViewById(R.id.posts_id);
        title= findViewById(R.id.posts_title);
        body= findViewById(R.id.posts_body);

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit_Instance instance= retrofit.create(Retrofit_Instance.class);
        Call<ModelClass> call= instance.getPosts2List(3);
        call.enqueue(new Callback<ModelClass>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response success", Toast.LENGTH_SHORT).show();
                    ModelClass modelClass= response.body();

                    userID.setText(Integer.toString(modelClass.getUserId()));
                    id.setText(Integer.toString(modelClass.getId()));
                    title.setText(modelClass.getTitle());
                    body.setText(modelClass.getBody());
                }
                else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}