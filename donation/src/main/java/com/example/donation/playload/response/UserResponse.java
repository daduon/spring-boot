package com.example.donation.playload.response;

public class UserResponse {

    private String token;
    private String type = "Bearer";
    private String username;
    private String password;

    public UserResponse(String token, String username, String password) {
        this.token = token;
        this.username = username;
        this.password = password;
    }

    public String getToken(){
        return token;
    }

    public String getType(){
        return type;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    
}
