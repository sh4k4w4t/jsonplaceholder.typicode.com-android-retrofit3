package com.alivepython.jsonplaceholder.withPhoto;

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

public class WithPhoto extends AppCompatActivity {
    RecyclerView photoRecycleID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_photo);

        photoRecycleID= findViewById(R.id.photoRecycleID);
        photoRecycleID.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit_Instance instance= retrofit.create(Retrofit_Instance.class);
        Call<List<WithPhotoModelClass>> call= instance.allPhotoWithDetails();

        call.enqueue(new Callback<List<WithPhotoModelClass>>() {
            @Override
            public void onResponse(Call<List<WithPhotoModelClass>> call, Response<List<WithPhotoModelClass>> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "response Success", Toast.LENGTH_SHORT).show();
                    List<WithPhotoModelClass> all= response.body();
                    WithPhotoAdapter adapter= new WithPhotoAdapter(all);
                    photoRecycleID.setAdapter(adapter);
                }
                else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<WithPhotoModelClass>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}