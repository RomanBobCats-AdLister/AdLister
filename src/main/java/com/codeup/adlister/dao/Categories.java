package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Categories {
    List<Categories> all();
    List<Category> searchCategory(String searchCategory);
    Category findByCategory(String categoryName);
    Long insert(Category category);
    Category findById(long id);


}
