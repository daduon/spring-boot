package com.example.donation.playload.request;

public class CategoryRequest {
    private String title;
    private String image;
    private String subTitle;

    public CategoryRequest(){
        
    }
    
    public CategoryRequest(String title, String image, String subTitle) {
        this.title = title;
        this.image = image;
        this.subTitle = subTitle;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}
