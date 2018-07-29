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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "RentalController", urlPatterns = {"/RentalController"})
public class RentalController extends HttpServlet {

    miscFunction mf = new miscFunction();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("rentallist", mf.resultSetToArrayList());
            RequestDispatcher rd = request.getRequestDispatcher("rental.jsp");
            rd.forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            response.sendRedirect("404.jsp");
        }
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {
            int copyno = Integer.parseInt(request.getParameter("copyno"));
            int rentalno = Integer.parseInt(request.getParameter("rentalno"));
            try {
                mf.updateRental(copyno, rentalno);
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println(ex);
                response.sendRedirect("404.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (mf.sellRent(Integer.parseInt(request.getParameter("memberno")), Integer.parseInt(request.getParameter("copyno"))) == 1) {
                response.sendRedirect("RentalController");
            } else {
                response.sendRedirect("404.jsp");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex);
            response.sendRedirect("404.jsp");
        }
    }

}
