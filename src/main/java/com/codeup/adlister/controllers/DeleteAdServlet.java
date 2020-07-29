package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "controller.DeleteAdServlet", urlPatterns = "/ads/deleteAd")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        GET THE VALUE FROM THE FORM:
        String adToDelete = req.getParameter("adToDelete");
//        System.out.println("adToDelete = " + adToDelete);

//        PARSE THE ID FROM STRING FORMAT:
        long adId = Long.parseLong(req.getParameter("adToDelete"));
//        System.out.println( adId);

//        CREATE AN OBJECT WITH DAOFACTORY AND RUN DELETE METHOD
        Ad deleteAd = DaoFactory.getAdsDao().deleteAd(adId);

       resp.sendRedirect("/ads");
    }
}
