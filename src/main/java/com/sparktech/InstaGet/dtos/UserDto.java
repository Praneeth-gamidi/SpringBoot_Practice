package com.sparktech.InstaGet.dtos;

import com.sparktech.InstaGet.Models.User;

public class UserDto {

    private int id;
    private String name;
    private String email;
    // password intentionally excluded from DTO for security

    public UserDto() {}

    public UserDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    public User toUser(String password) {
        return new User(this.name, this.email, password);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
