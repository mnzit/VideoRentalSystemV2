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
import java.io.PrintWriter;
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
@WebServlet(name = "VideoUpdater", urlPatterns = {"/VideoUpdater"})
public class VideoUpdater extends HttpServlet {

    Video v = new Video();
    VideoDAO vDAO = new VideoDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();
    Catalog c = new Catalog();
    CatalogDAO cDAO = new CatalogDAOImpl();
    CategoryDAO ctDAO = new CategoryDAOImpl();
    VideoCopiesDAO vcDAO = new VideoCopiesDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
            int id = Integer.parseInt(request.getParameter("videono"));
            request.setAttribute("videobyno", vDAO.getVideoById(id));
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("cataloglist",cDAO.allCatalog());
            request.setAttribute("categorylist",ctDAO.allCategory());
            request.setAttribute("videocopylist",vcDAO.getVideoCopiesById(id));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
        RequestDispatcher rd = request.getRequestDispatcher("editvideo.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
