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
@WebServlet(name = "CatalogController", urlPatterns = {"/CatalogController"})
public class CatalogController extends HttpServlet {

    Catalog c = new Catalog();
    CatalogDAO cDAO = new CatalogDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("cataloglist", cDAO.allCatalog());
            RequestDispatcher rd = request.getRequestDispatcher("catalog.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            response.sendRedirect("404.jsp");
        }
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("catalogno"));
                c.setCatalog_no(id);
                if (cDAO.deleteCatalog(c) == 1) {
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
            String catalog_no = request.getParameter("catalogno");
            String branch_no = request.getParameter("branchno");
            String catalog_name = request.getParameter("catalogname");
            c.setBranch_no(Integer.parseInt(branch_no));
            c.setCatalog_name(catalog_name);
            if (catalog_no == null || catalog_no.isEmpty()) {
                if (cDAO.createCatalog(c) == 1) {
                    response.sendRedirect("CatalogController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                int id = Integer.parseInt(catalog_no);
                c.setCatalog_no(id);
                if (cDAO.updateCatalog(c) == 1) {
                    response.sendRedirect("CatalogController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            response.sendRedirect("404.jsp");
            System.out.println(ex);
        }
    }
}
