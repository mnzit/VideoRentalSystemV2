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
@WebServlet(name = "MemberUpdater", urlPatterns = {"/MemberUpdater"})
public class MemberUpdater extends HttpServlet {

    Member m = new Member();
    MemberDAO mDAO = new MemberDAOImpl();
    Branch b = new Branch();
    BranchDAO bDAO = new BranchDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("memberno"));
            request.setAttribute("memberbyno", mDAO.getMemberById(id));
            request.setAttribute("branchlist", bDAO.allBranch());

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
        RequestDispatcher rd = request.getRequestDispatcher("editmember.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
