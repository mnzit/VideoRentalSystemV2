<%-- 
    Document   : header
    Created on : Jul 25, 2018, 4:19:17 PM
    Author     : Dell
--%>

<%-- 
    Document   : header
    Created on : Jul 11, 2018, 9:26:06 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>VideoRental</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>

    <nav class="fixed-top navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">Video Rental Company</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse text-center" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link active" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                <% if (session.getAttribute("username") != null) {%> <a class="nav-item nav-link active" href="RentalController">Shop<span class="sr-only">(current)</span></a><%}%>
                <%
                    if (session.getAttribute("username") != null) {
                %>
                <form action="Logout">
                    <button class="btn btn-lg btn-primary btn-block logoutm" type="submit">Log out</button>
                </form>   
                <%
                    }
                %>
            </div>
            <%
                String uri = request.getRequestURI();
                String pageName = uri.substring(uri.lastIndexOf("/") + 1);
                if (pageName.equalsIgnoreCase("EditStaff.jsp")) {
            %>
            <a class="nav-item nav-link active" href="StaffController">Staff <span class="sr-only">(current)</span></a>
            <%}%>
            <%
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setHeader("Expries", "0");
                if (session.getAttribute("username") != null) {

            %>

            <div class="collapse navbar-collapse flex-row-reverse" id="navbarNavAltMarkup">
                <button type="button" title="<%if (session.getAttribute("username") != null) {%>Logged in as ${username}<%} else {%><%}%>" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
                    Log out
                </button>
                <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Do you really want to log out?</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-footer">
                                <form action="LogOutController">
                                    <button class="btn btn-primary" type="submit">Log out</button>
                                </form>
                                <button class="btn btn-primary" data-dismiss="modal">Cancel</button>
                            </div>
                        </div>
                    </div>
                </div>
                <a href="welcome.jsp" class="nav-item nav-link">${username} | </a>
            </div>
            <%}
            %>
        </div>
    </nav>
    <body>
        <div class="container" id="main-con" style="margin-top:100px;margin-bottom:100px;">



