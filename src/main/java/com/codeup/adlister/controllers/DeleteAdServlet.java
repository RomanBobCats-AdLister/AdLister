package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "controller.DeleteAdServlet", urlPatterns = "/deleteAd")
public class DeleteAdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adToDelete = req.getParameter("adToDelete");
        System.out.println("adToDelete = " + adToDelete);
        long adId = Long.parseLong(req.getParameter("adToDelete"));
        System.out.println( adId);
        Ad deleteAd = DaoFactory.getAdsDao().deleteAd(adId);
//        if (deleteAd == null) {
//            resp.sendRedirect("/displayAd");
//            return;
//        }

       resp.sendRedirect("/ads");
    }
}
