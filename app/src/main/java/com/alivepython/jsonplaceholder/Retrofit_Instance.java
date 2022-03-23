package com.alivepython.jsonplaceholder;

import com.alivepython.jsonplaceholder.posts.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Retrofit_Instance {

    @GET("posts")
    Call<List<ModelClass>> getPostsData();


}
