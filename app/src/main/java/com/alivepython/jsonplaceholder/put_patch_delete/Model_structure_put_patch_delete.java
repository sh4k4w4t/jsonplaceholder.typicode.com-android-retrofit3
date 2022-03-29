package com.alivepython.jsonplaceholder.put_patch_delete;

public class Model_structure_put_patch_delete {
    private String title;
    private String body;
    private int userId;

    public Model_structure_put_patch_delete() {
    }

    public Model_structure_put_patch_delete(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

