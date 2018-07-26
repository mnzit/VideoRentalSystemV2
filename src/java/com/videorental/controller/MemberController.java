/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.dao.BranchDAO;
import com.videorental.dao.MemberDAO;
import com.videorental.dao.daoImpl.BranchDAOImpl;
import com.videorental.dao.daoImpl.MemberDAOImpl;
import com.videorental.misc.miscFunction;
import com.videorental.model.Branch;
import com.videorental.model.Member;
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
@WebServlet(name = "MemberController", urlPatterns = {"/MemberController"})
public class MemberController extends HttpServlet {

    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();
    Member m = new Member();
    MemberDAO mDAO = new MemberDAOImpl();
    miscFunction mis = new miscFunction();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("branchlist", bDAO.allBranch());
            request.setAttribute("memberlist", mDAO.allMember());
            RequestDispatcher rd = request.getRequestDispatcher("member.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            response.sendRedirect("404.jsp");
        }
          String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("memberno"));
                m.setMember_no(id);
                if (mDAO.deleteMember(m) == 1) {
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
        String member_no = request.getParameter("memberno");
        String branch_no = request.getParameter("branchno");
        m.setBranch_no(Integer.parseInt(branch_no));
        m.setFname(request.getParameter("fname"));
        m.setLname(request.getParameter("lname"));
        m.setAddress(request.getParameter("address"));
        m.setRegistration_date(mis.date());
        try {
            if (member_no == null || member_no.isEmpty()) {
                if (mDAO.createMember(m) == 1) {
                    response.sendRedirect("MemberController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            } else {
                m.setMember_no(Integer.parseInt(member_no));
                if (mDAO.updateMember(m) == 1) {
                    response.sendRedirect("MemberController");
                } else {
                    response.sendRedirect("404.jsp");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            response.sendRedirect("404.jsp");
        }
    }

}
