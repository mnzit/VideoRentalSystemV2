/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.StaffDAO;
import com.videorental.dao.daoImpl.BranchDAOImpl;
import com.videorental.dao.daoImpl.StaffDAOImpl;
import com.videorental.model.Branch;
import com.videorental.model.Staff;
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
@WebServlet(name = "StaffController", urlPatterns = {"/StaffController"})
public class StaffController extends HttpServlet {

    Staff s = new Staff();
    StaffDAO sDAO = new StaffDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("stafflist", sDAO.allStaffs());
            RequestDispatcher rd = request.getRequestDispatcher("staff.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            response.sendRedirect("404.jsp");
        }
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("staffno"));
                s.setStaff_no(id);
                if (sDAO.deleteStaff(s) == 1) {
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
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String position = request.getParameter("position");
        String staff_no = request.getParameter("staffno");
        String branch_no = request.getParameter("branchno");
        s.setBranch_no(Integer.parseInt(branch_no));
        s.setName(name);
        s.setSalary(Integer.parseInt(salary));
        s.setPosition(position);
        try {
            if (staff_no == null || staff_no.isEmpty()) {
                if (sDAO.createStaff(s) == 1) {
                    response.sendRedirect("StaffController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                s.setStaff_no(Integer.parseInt(staff_no));
                if (sDAO.updateStaff(s) == 1) {
                    response.sendRedirect("StaffController");
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
