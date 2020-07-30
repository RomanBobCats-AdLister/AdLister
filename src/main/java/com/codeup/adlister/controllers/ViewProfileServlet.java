package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        //for user
        User userSession = (User)request.getSession().getAttribute("user");
        User currentUser = DaoFactory.getUsersDao().findByUsername(userSession.getUsername());

        //need currentUser to update email information when redirected back to the profile page
        request.getSession().setAttribute("user", currentUser );


        //for adds
//        User user = (User)request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().adsByUser(userSession.getId()));




        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
