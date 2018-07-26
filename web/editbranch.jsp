<%-- 
    Document   : editbranch
    Created on : Jul 25, 2018, 7:19:38 PM
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

<h1 class="display-4 text-center">Branch</h1>
<c:forEach items="${branchbyno}" var="b">
    <form method="post" action="BranchController" autocomplete="off">
        <div class="form-row">
            <div class="form-group col-md-3">
                <label for="inputEmail4">Branch no</label>
                <input readonly="readonly" class="form-control" value="${b.branch_no}" name="branchno" placeholder="Branchno">
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">Street</label>
                <input class="form-control" value="${b.street}" name="street" placeholder="Street">
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">City</label>
                <input class="form-control" name="city" value="${b.city}" placeholder="City">
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">State</label>
                <input class="form-control" value="${b.state}" name="state" placeholder="State">
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">Zip code</label>
                <input class="form-control" value="${b.zip_code}" name="zip_code" placeholder="Zip Code">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</c:forEach>

<%@include file="footer.jsp"%>