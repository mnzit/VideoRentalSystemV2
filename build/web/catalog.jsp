<%-- 
    Document   : category
    Created on : Jul 25, 2018, 4:20:34 PM
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
<form method="post" action="CatalogController" autocomplete="off">
    <div class="form-row">
        <div class="form-group col-md-1">
            <label>Branch no</label>
            <select id="branch_no" class="form-control" name="branchno">
                <c:forEach items="${branchlist}" var="b">
                    <option value="${b.branch_no}">${b.branch_no}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label>Catalog name</label>
            <input type="text" name="catalogname" class="form-control" id="catalog_name" placeholder="Catalog name">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add Catalog</button>
</form>

<table class="table mt-4 header-fixed table-hover">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Catalog no</th>
            <th scope="col">Branch no</th>
            <th scope="col">Catalog name</th>
            <th scope="col">Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${cataloglist}" var="ct">
            <tr id="catalog-${ct.catalog_no}">
                <td><c:out value="${ct.catalog_no}"/></td>
                <td><c:out value="${ct.branch_no}" /></td>
                <td><c:out value="${ct.catalog_name}" /></td>            
                <td>
                    <a href="CatalogUpdater?catalogno=<c:out value="${ct.catalog_no}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${ct.catalog_no}', 'catalogDelete')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm to delete catalog</h5>
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