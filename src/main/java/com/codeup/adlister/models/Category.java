package com.codeup.adlister.models;

import com.codeup.adlister.dao.Config;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private long id;
    private long userId;
    private long catId;
    private String category;
    private List<Ad> ads = new ArrayList<>();

// have property that is a list of ads
    // every add that has this cat is goin to be in the list

    public Category(long id, long userId, String category) {
        this.id = id;
        this.userId = userId;
        this.category = category;
    }

    public Category(long userId, String category) {
        this.userId = userId;
        this.category = category;
    }

    public Category(long id,String category,long catId) {
        this.id = id;
        this.category = category;
        this.catId = catId;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
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
