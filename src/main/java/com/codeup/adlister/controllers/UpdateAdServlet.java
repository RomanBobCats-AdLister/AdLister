package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controller.UpdateAdServlet", urlPatterns = "/ads/updateAd")
public class UpdateAdServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long adId = Long.parseLong(req.getParameter("adToUpdate"));
        Ad ad = DaoFactory.getAdsDao().findById(adId);

        req.setAttribute("ad", ad);
        req.getRequestDispatcher("/WEB-INF/ads/editAd.jsp").forward(req, resp);

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().getAttribute("adToUpdate");
            long adId = Long.parseLong(req.getParameter("adToUpdate"));
            req.setAttribute("title", DaoFactory.getAdsDao().editAdTitle(adId, "title"));
            req.setAttribute("description", DaoFactory.getAdsDao().editAdDescription(adId, "description"));
//            req.setAttribute("category", DaoFactory.getAdsDao().findById(adId));

            String updateAd = req.getParameter("adToUpdate");
            String adTitle = req.getParameter("title");
            String adDescription = req.getParameter("description");
            System.out.println("updateAd = " + updateAd);
            System.out.println( adId);


                Ad updateTitle = DaoFactory.getAdsDao().editAdTitle(adId, adTitle);
                resp.sendRedirect("/ads");

                Ad updateDescription = DaoFactory.getAdsDao().editAdDescription(adId, adDescription);
                resp.sendRedirect("/ads");
            }
        }


