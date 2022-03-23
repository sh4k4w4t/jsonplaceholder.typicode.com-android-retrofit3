package com.alivepython.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alivepython.jsonplaceholder.posts.PostsActivity;
import com.alivepython.jsonplaceholder.posts_2.Posts_2_activity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity{

    Button button,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= findViewById(R.id.button);
        button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        button4= findViewById(R.id.button4);


        button.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), PostsActivity.class)));
        button2.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), Posts_2_activity.class)));


    }
}