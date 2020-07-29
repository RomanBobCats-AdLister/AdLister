package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    void editUser(Long id, String email, String password);
    void deleteUser(Long id);
    User findByID(Long id);
}
