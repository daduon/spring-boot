package com.example.donation.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends AuditModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String image;
    private String description;
    private String video;

    public Post(){

    }

    public Post(String title, String subTitle, String image, String description, String video,
            Date createdAt, Date updatedAt) {
        this.title = title;
        this.subTitle = subTitle;
        this.image = image;
        this.description = description;
        this.video = video;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVideo() {
        return this.video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
