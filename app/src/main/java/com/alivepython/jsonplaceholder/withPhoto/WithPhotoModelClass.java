package com.alivepython.jsonplaceholder.withPhoto;

public class WithPhotoModelClass {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public WithPhotoModelClass() {
    }

    public WithPhotoModelClass(int albumId, int id, String title, String url, String thumbnailUrl) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
