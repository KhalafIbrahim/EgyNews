package com.example.egynews;

public class OneNew {


    String title, content,type,photoPath;
    long time;

    public OneNew() {
    }

    public OneNew(String title, String content, String type, String photoPath, long time) {
        this.title = title;
        this.content = content;
        this.type = type;
        this.photoPath = photoPath;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

}
