package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(name = "controllers.DisplayAdServlet", urlPatterns = "/displayAd/*")
public class DisplayAdServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

<<<<<<< HEAD
        User user = (User) req.getSession().setAttribute("user");
        long adId = Long.parseLong(req.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().findById(adId);
        req.setAttribute("ad", ad);


=======
        User user = (User) req.getSession().getAttribute("user");
        String adId = req.getPathInfo().substring(1);
        Ad ad = DaoFactory.getAdsDao().findById(parseInt((adId)));
>>>>>>> master

        req.setAttribute("user", user);

        req.getRequestDispatcher("/WEB-INF/ads/displayAd.jsp").forward(req, resp);
    }
}
