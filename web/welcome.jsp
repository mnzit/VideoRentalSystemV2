<%-- 
    Document   : welcome
    Created on : Jul 25, 2018, 4:20:02 PM
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

<div class="text-center">
    <h1 class="display-4">Welcome ${username}</h1>
</div>
<div class="mt-4">
    <div class="row text-center">
        <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Staff</h5>
                <div class="card-body">
                    <h5 class="card-title">Manage your employees</h5>
                    <p class="card-text">Manage staff, Add, Update and delete functionality</p>
                    <a href="StaffController" class="btn btn-primary">Begin</a>
                </div>
            </div>                
        </div>
        <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Members</h5>
                <div class="card-body">
                    <h5 class="card-title">Manage your Members</h5>
                    <p class="card-text">Manage members, Add, Update and delete functionality</p>
                    <a href="MemberController" class="btn btn-primary">Begin</a>
                </div>
            </div>    
        </div>
        <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Video</h5>
                <div class="card-body">
                    <h5 class="card-title">Managing your Catalogs</h5>
                    <p class="card-text">Manage movies, Add, Update, delete functionality</p>
                    <a href="VideoController" class="btn btn-primary">Begin</a>
                </div>
            </div>    
        </div>
        <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Catalog</h5>
                <div class="card-body">
                    <h5 class="card-title">Create a catalog for you new videos</h5>
                    <p class="card-text">Create a catalog to list videos in it</p>
                    <a href="CatalogController" class="btn btn-primary">Begin</a>
                </div>
            </div>    
        </div>
        <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Sell & Rent </h5>
                <div class="card-body">
                    <h5 class="card-title">Sell or Rent Movie </h5>
                    <p class="card-text">Sell and rent functionality. Keeping record. </p>
                    <a href="RentalController" class="btn btn-primary">Begin</a>
                </div>
            </div>    
        </div>
          <div class="d-flex align-items-stretch col-md-4 mt-4">
            <div class="card">
                <h5 class="card-header">Branch </h5>
                <div class="card-body">
                    <h5 class="card-title">Add or Remove Branch </h5>
                    <p class="card-text">New branch for your company can be added</p>
                    <a href="BranchController" class="btn btn-primary">Begin</a>
                </div>
            </div>    
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>