/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videorental.controller;

import com.videorental.misc.miscFunction;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RentalController", urlPatterns = {"/RentalController"})
public class RentalController extends HttpServlet {

    miscFunction mf = new miscFunction();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("rental.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (mf.sellRent(Integer.parseInt(request.getParameter("memberno")), Integer.parseInt(request.getParameter("copyno"))) == 1) {
                response.sendRedirect("rental.jsp");
            } else {
                response.sendRedirect("404.jsp");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
    }

}
