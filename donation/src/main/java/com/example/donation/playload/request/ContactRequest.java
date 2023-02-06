package com.example.donation.playload.request;

public class ContactRequest {
    private String title;
    private String number;
    private String email;
    private String location;

    public ContactRequest(){

    }
    
    public ContactRequest(String title, String number, String email, String location) {
        this.title = title;
        this.number = number;
        this.email = email;
        this.location = location;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
