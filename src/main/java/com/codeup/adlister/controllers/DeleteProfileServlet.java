package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DeleteProfileServlet", urlPatterns = "/deleteProfile")
public class DeleteProfileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        long userId = Long.parseLong(request.getParameter("userId"));

        System.out.println(userId);

       DaoFactory.getUsersDao().deleteUser(userId);

        response.sendRedirect("/logout");
    }
}
