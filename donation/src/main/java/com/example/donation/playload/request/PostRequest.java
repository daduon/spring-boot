package com.example.donation.playload.request;

public class PostRequest {
    private String title;
    private String subTitle;
    private String image;
    private String description;
    private String video;
    
    public PostRequest(){

    }

    public PostRequest(String title, String subTitle, String image, String description, String video) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.description = description;
        this.video = video;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
}
