package com.alivepython.jsonplaceholder.put_patch_delete;

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

public class Delete_activity extends AppCompatActivity {
    Retrofit_Instance instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        instance= Retrofit_client.getServices();
        requestForDeleteId();
    }

    private void requestForDeleteId() {
        Call<Void> request= instance.requestForDeleteID(3);
        request.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Success and deleted", Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "onResponse: ====================================");
                    Log.d("TAG", "onResponse: Response Success and deleted");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}