package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.DisplayAdServlet", urlPatterns = "/displayAd")
public class DisplayAdServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       long adId = req.getParameter(id);

        Ad ad = DaoFactory.getAdsDao().findById(1);

        req.setAttribute("ad", ad);
        req.getRequestDispatcher("/WEB-INF/ads/displayAd.jsp").forward(req, resp);

    }
}
