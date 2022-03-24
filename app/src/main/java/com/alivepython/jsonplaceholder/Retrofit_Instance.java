package com.alivepython.jsonplaceholder;

import com.alivepython.jsonplaceholder.posts.ModelClass;
import com.alivepython.jsonplaceholder.posts_1_comments.ModelClass3;
import com.alivepython.jsonplaceholder.users.User_model_final_3;
import com.alivepython.jsonplaceholder.withPhoto.WithPhotoModelClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Retrofit_Instance {

    @GET("posts")
    Call<List<ModelClass>> getPostsData();

    @GET("posts/{id}")
    Call<ModelClass> getPosts2List(@Path("id") int id);


//    https://jsonplaceholder.typicode.com/posts/2/comments
    @GET("posts/{id}/comments")
    Call<List<ModelClass3>> allModelList(@Path("id") int id);

//    https://jsonplaceholder.typicode.com/comments?postId=1
    @GET("comments")
    Call<List<ModelClass3>> allPostIDList(@Query("postId") int postId);

//    https://jsonplaceholder.typicode.com/photos
    @GET("photos")
    Call<List<WithPhotoModelClass>> allPhotoWithDetails();

//    https://jsonplaceholder.typicode.com/users
    @GET("users")
    Call<List<User_model_final_3>> getFullDetails();


}
