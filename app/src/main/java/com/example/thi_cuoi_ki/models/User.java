package com.example.thi_cuoi_ki.models;

import org.bson.types.ObjectId;
import org.bson.codecs.pojo.annotations.*;

public class User {
    @BsonId
    private ObjectId id;
    private String username;
    private String password;

    public User() {
        // Constructor mặc định
    }

    public User(ObjectId id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
