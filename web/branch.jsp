<%-- 
    Document   : branch
    Created on : Jul 25, 2018, 6:27:51 PM
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
<form method="post" action="BranchController" autocomplete="off">
    <div class="form-row">

        <div class="form-group col-md-3">
            <label for="inputEmail4">Street</label>
            <input class="form-control" name="street" placeholder="Street" required="required">
        </div>
        <div class="form-group col-md-3">
            <label for="inputEmail4">City</label>
            <input class="form-control" name="city" placeholder="City" required="required">
        </div>
        <div class="form-group col-md-3">
            <label for="inputEmail4">State</label>
            <input class="form-control" name="state" placeholder="State" required="required">
        </div>
        <div class="form-group col-md-3">
            <label for="inputEmail4">Zip code</label>
            <input class="form-control" name="zip_code" placeholder="Zip Code" required="required">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add Branch</button>
</form>
<table class="table mt-4 table-hover">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Branch no</th>
            <th scope="col">Street</th>            
            <th scope="col">City</th>
            <th scope="col">State</th>
            <th scope="col">Zip Code</th>
            <th scope="col">Operations</th>
        </tr>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${branchlist}" var="b">
            <tr id="branch-${b.branch_no}">
                <td><c:out value="${b.branch_no}" /></td>
                <td><c:out value="${b.street}" /></td>
                <td><c:out value="${b.city}" /></td>
                <td><c:out value="${b.state}" /></td>
                <td><c:out value="${b.zip_code}" /></td>

                <td>
                    <a href="BranchUpdater?branchno=<c:out value="${b.branch_no}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${b.branch_no}', 'branchDelete')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</div>
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm to delete Branch</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" onclick ="deleteData()" data-dismiss="modal">Yes</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal">No</button>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>