package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Categories {
    List<Categories> all();
    User findByUsername(String username);
    Long insert(Category category);



}
