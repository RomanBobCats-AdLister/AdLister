package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        System.out.println(DaoFactory.getAdsDao().all());
//        System.out.println("DaoFactory.getAdsDao().all().get(0).getTitle() = " + DaoFactory.getAdsDao().all().get(0).getTitle());
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }

    // this is to search the ads
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchQuery = request.getParameter("ad");
        request.setAttribute("ads", DaoFactory.getAdsDao().search(searchQuery));
        request.setAttribute("searchQuery", searchQuery);
        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}