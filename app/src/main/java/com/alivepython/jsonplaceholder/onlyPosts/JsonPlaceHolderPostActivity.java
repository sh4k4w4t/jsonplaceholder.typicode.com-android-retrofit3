package com.alivepython.jsonplaceholder.onlyPosts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alivepython.jsonplaceholder.R;
import com.alivepython.jsonplaceholder.Retrofit_Instance;
import com.alivepython.jsonplaceholder.Retrofit_client;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonPlaceHolderPostActivity extends AppCompatActivity {
    Retrofit_Instance allInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_place_holder_post);

        allInterface= Retrofit_client.getServices();
        loadInfo();
    }

    private void loadInfo() {
        Call<Model_Response_JsonPlaceHolderApi> call= allInterface.responseModel("title_1", "body_1", 1);
        call.enqueue(new Callback<Model_Response_JsonPlaceHolderApi>() {
            @Override
            public void onResponse(Call<Model_Response_JsonPlaceHolderApi> call, Response<Model_Response_JsonPlaceHolderApi> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Successs", Toast.LENGTH_SHORT).show();
                    Model_Response_JsonPlaceHolderApi res=response.body();
                    Log.d("TAG", "onResponse: ===============================================================");
                    Log.d("getUserId", String.valueOf(res.getUserId()));
                    Log.d("getTitle", res.getTitle());
                    Log.d("getBody", res.getBody());

                }
                else {
                    Toast.makeText(getApplicationContext(), "Response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_Response_JsonPlaceHolderApi> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}