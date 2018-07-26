/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.daoImpl.BranchDAOImpl;
import com.videorental.model.Branch;
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
@WebServlet(name = "BranchController", urlPatterns = {"/BranchController"})
public class BranchController extends HttpServlet {

    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setAttribute("branchlist", bDAO.allBranch());
            RequestDispatcher rd = request.getRequestDispatcher("branch.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }

        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("branchno"));
                b.setBranch_no(id);
                if (bDAO.deleteBranch(b) == 1) {
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
            String branch_no = request.getParameter("branchno");
            String street = request.getParameter("street");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            int zip_code = Integer.parseInt(request.getParameter("zip_code"));
            b.setStreet(street);
            b.setCity(city);
            b.setState(state);
            b.setZip_code(zip_code);

            //Insert branch
            if (branch_no == null || branch_no.isEmpty()) {
                if (bDAO.createBranch(b) == 1) {
                    response.sendRedirect("BranchController");
                } else {
                    response.sendRedirect("404.jsp");
                }
                //Update branch
            } else {
                b.setBranch_no(Integer.parseInt(branch_no));
                if (bDAO.updateBranch(b) == 1) {
                    response.sendRedirect("BranchController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
    }

}
