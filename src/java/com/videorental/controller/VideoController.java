/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.CatalogDAO;
import com.videorental.dao.CategoryDAO;
import com.videorental.dao.VideoCopiesDAO;
import com.videorental.dao.VideoDAO;
import com.videorental.dao.daoImpl.BranchDAOImpl;
import com.videorental.dao.daoImpl.CatalogDAOImpl;
import com.videorental.dao.daoImpl.CategoryDAOImpl;
import com.videorental.dao.daoImpl.VideoCopiesDAOImpl;
import com.videorental.dao.daoImpl.VideoDAOImpl;
import com.videorental.model.Branch;
import com.videorental.model.Catalog;
import com.videorental.model.Video;
import com.videorental.model.VideoCopies;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "VideoController", urlPatterns = {"/VideoController"})
public class VideoController extends HttpServlet {

    Video v = new Video();
    VideoCopies vc = new VideoCopies();
    VideoDAO vDAO = new VideoDAOImpl();
    VideoCopiesDAO vcDAO = new VideoCopiesDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();
    Catalog c = new Catalog();
    CatalogDAO cDAO = new CatalogDAOImpl();
    CategoryDAO ctDAO = new CategoryDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("cataloglist", cDAO.allCatalog());
            request.setAttribute("categorylist",ctDAO.allCategory());
            request.setAttribute("videolist",vDAO.allVideo());
            RequestDispatcher rd = request.getRequestDispatcher("video.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("videono"));
                v.setVideo_no(id);
                if (vDAO.deleteVideo(v) == 1) {
                } else {
                    response.sendRedirect("404.jsp");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
                response.sendRedirect("404.jsp");
            }
        }else if (action.equalsIgnoreCase("deletecopy")) {
            try {
                int id = Integer.parseInt(request.getParameter("copyno"));
                vc.setCopy_no(id);
                if (vcDAO.deleteVideoCopies(vc) == 1) {
                } else {
                    response.sendRedirect("404.jsp");
                }

            } catch (ClassNotFoundException | SQLException ex) {
                System.out.println(ex);
                response.sendRedirect("404.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String videono = request.getParameter("videono");
            String branchno = request.getParameter("branchno");
            String catalogno = request.getParameter("catalogno");
            v.setBranch_no(Integer.parseInt(branchno));
            v.setCatalog_no(Integer.parseInt(catalogno));
            v.setTitle(request.getParameter("title"));
            v.setDaily_rental_cost(Integer.parseInt(request.getParameter("dailyrentalcost")));
            v.setCost(Integer.parseInt(request.getParameter("cost")));
            v.setNo_of_videos(Integer.parseInt(request.getParameter("noofvideo")));
            v.setCategory_no_1(Integer.parseInt(request.getParameter("category-1")));
            v.setCategory_no_2(Integer.parseInt(request.getParameter("category-2")));
            v.setCategory_no_3(Integer.parseInt(request.getParameter("category-3")));
            v.setMain_actor_1(request.getParameter("main_actor_1"));
            v.setMain_actor_2(request.getParameter("main_actor_2"));
            v.setMain_actor_3(request.getParameter("main_actor_3"));
            v.setMain_director_1(request.getParameter("main_director_1"));
            v.setMain_director_2(request.getParameter("main_director_2"));
            if (videono == null || videono.isEmpty()) {
                if (vDAO.createVideo(v) == 1) {
                    response.sendRedirect("VideoController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                int id = Integer.parseInt(videono);
                v.setVideo_no(id);
                if (vDAO.updateVideo(v) == 1) {
                    response.sendRedirect("VideoController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }

    }

}
