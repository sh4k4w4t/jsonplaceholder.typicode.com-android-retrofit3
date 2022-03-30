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

public class Put_Patch extends AppCompatActivity {

    Retrofit_Instance retrofit_instance;
    Model_structure_put_patch_delete model_structure_put_patch_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_put_patch);

        retrofit_instance= Retrofit_client.getServices();
        //for PUT > for put give all value
//        model_structure_put_patch_delete= new Model_structure_put_patch_delete("Lets Study","this body",3);

        //for PATCH  > for patch give needed value, which want to change
        model_structure_put_patch_delete= new Model_structure_put_patch_delete("Lets Study",null,3);


        loadInformation();
    }

    private void loadInformation() {
        Call<Model_structure_put_patch_delete> call= retrofit_instance.put_response_put_patch_delete(2,model_structure_put_patch_delete);
        call.enqueue(new Callback<Model_structure_put_patch_delete>() {
            @Override
            public void onResponse(Call<Model_structure_put_patch_delete> call, Response<Model_structure_put_patch_delete> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Response Success", Toast.LENGTH_SHORT).show();
                    Model_structure_put_patch_delete res= response.body();

                    Log.d("response", "onResponse: ==========================");
                    Log.d("userID", String.valueOf(res.getUserId()));
                    Log.d("title",res.getTitle());
                    Log.d("body",res.getBody());
                }
                else {
                    Toast.makeText(getApplicationContext(), "Response Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Model_structure_put_patch_delete> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failure failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}