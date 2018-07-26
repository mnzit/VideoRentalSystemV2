/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.CatalogDAO;
import com.videorental.dao.daoImpl.BranchDAOImpl;
import com.videorental.dao.daoImpl.CatalogDAOImpl;
import com.videorental.model.Branch;
import com.videorental.model.Catalog;
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
@WebServlet(name = "CatalogUpdater", urlPatterns = {"/CatalogUpdater"})
public class CatalogUpdater extends HttpServlet {

    Catalog c = new Catalog();
    CatalogDAO cDAO = new CatalogDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("catalogno"));
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("catalogbyno", cDAO.getCatalogById(id));
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
        RequestDispatcher rd = request.getRequestDispatcher("editcatalog.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
