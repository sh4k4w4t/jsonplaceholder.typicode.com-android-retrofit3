package com.alivepython.jsonplaceholder;

import com.alivepython.jsonplaceholder.posts.ModelClass;
import com.alivepython.jsonplaceholder.posts_1_comments.ModelClass3;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Retrofit_Instance {

    @GET("posts")
    Call<List<ModelClass>> getPostsData();

    @GET("posts/{id}")
    Call<ModelClass> getPosts2List(@Path("id") int id);


//    https://jsonplaceholder.typicode.com/posts/2/comments
    @GET("posts/{id}/comments")
    Call<List<ModelClass3>> allModelList(@Path("id") int id);


}
