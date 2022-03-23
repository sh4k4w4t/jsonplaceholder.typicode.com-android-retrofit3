package com.alivepython.jsonplaceholder;

import com.alivepython.jsonplaceholder.posts.ModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_Instance {

    @GET("posts")
    Call<List<ModelClass>> getPostsData();

    @GET("posts/{id}")
    Call<ModelClass> getPosts2List(@Path("id") int id);


}
