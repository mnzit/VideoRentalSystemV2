<%-- 
    Document   : 404
    Created on : Jul 25, 2018, 4:21:52 PM
    Author     : Dell
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expries", "0");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@include file="header.jsp"%>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">404 Error</h1>
        <p class="lead">An Error occured</p>
    </div>
</div>
<%@include file="footer.jsp"%>