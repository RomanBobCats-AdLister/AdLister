package com.codeup.adlister.models;

import com.codeup.adlister.dao.Config;

public class Category {
    private long id;
    private long userId;
    private String category;



    public Category(long id, long userId, String category) {
        this.id = id;
        this.userId = userId;
        this.category = category;
    }

    public Category(long userId, String category) {
        this.userId = userId;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


}
