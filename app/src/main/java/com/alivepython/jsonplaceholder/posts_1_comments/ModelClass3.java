package com.alivepython.jsonplaceholder.posts_1_comments;

public class ModelClass3 {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;

    public ModelClass3() {
    }

    public ModelClass3(int postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }
}
