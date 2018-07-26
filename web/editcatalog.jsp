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
<c:forEach items="${catalogbyno}" var="c">
<form method="post" action="CatalogController" autocomplete="off">
    <div class="form-row">
        <div class="form-group col-md-3">
            <label>Catalog no</label>
            <input readonly="readonly" type="text" value="${c.catalog_no}" name="catalogno" class="form-control" id="catalog_no" placeholder="Catalog no">
        </div>
        <div class="form-group col-md-1">
            <label>Branch no</label>
            <select id="branch_no" class="form-control" name="branchno">
                <c:forEach items="${branchlist}" var="b">
                     <option value="${b.branch_no}" <c:if test="${c.branch_no eq b.branch_no}">selected</c:if>>${b.branch_no}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label>Catalog name</label>
            <input type="text" value="${c.catalog_name}" name="catalogname" class="form-control" id="catalog_name" placeholder="Catalog name">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Update</button>
</form>
    </c:forEach>
<%@include file="footer.jsp"%>