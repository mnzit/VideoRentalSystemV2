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
<c:forEach items="${memberbyno}" var="m">
  <form method="post" action="MemberController" autocomplete="off">
        <div class="form-row">
            <div class="form-group col-md-1">
                <label>Branch no</label>
                <select id="branch_no" class="form-control" name="branchno">
                    <c:forEach items="${branchlist}" var="b">
                        <option value="${b.branch_no}" <c:if test="${m.branch_no eq b.branch_no}">selected</c:if>>${b.branch_no}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">Member no</label>
                <input readonly="readonly" class="form-control" value="${m.member_no}" name="memberno" placeholder="memberno">
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">Firstname</label>
                <input class="form-control" value="${m.fname}" name="fname" placeholder="firstname">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Lastname</label>
                <input class="form-control" value="${m.lname}" name="lname" placeholder="lastname">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Address</label>
                <input class="form-control" value="${m.address}" name="address" placeholder="address">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
    </c:forEach>
<%@include file="footer.jsp"%>