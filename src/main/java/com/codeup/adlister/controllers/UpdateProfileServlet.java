package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.UpdateProfileServlet", urlPatterns = "/updateProfile")
public class UpdateProfileServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getSession().getAttribute("user");

request.getRequestDispatcher("/WEB-INF/editProfile.jsp").forward(request, response);

}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    String email = request.getParameter("email");
    String username = request.getParameter("username");
    Long id = Long.parseLong(request.getParameter("id"));
    DaoFactory.getUsersDao().editUser(id, email);


//    DaoFactory.getUsersDao().editUser(id, username);
//    User loggedUser = (User) request.getSession().getAttribute("user");
//    request.setAttribute("user", loggedUser);


    response.sendRedirect("/profile");

    }
}