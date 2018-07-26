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
<c:forEach items="${staffbyno}" var="s">
    <form method="post" action="StaffController" autocomplete="off">
        <div class="form-row">
            <div class="form-group col-md-1">
                <label for="inputEmail4">Staff id</label>
                <input readonly="readonly" type="text" value="${s.staff_no}" name="staffno" class="form-control" id="inputEmail4" placeholder="Name">
            </div>
            <div class="form-group col-md-1">
                <label>Branch no</label>
                <select id="branch_no" class="form-control" name="branchno">
                    <c:forEach items="${branchlist}" var="b">
                        <option value="${b.branch_no}" <c:if test="${s.branch_no eq b.branch_no}">selected</c:if>>${b.branch_no}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label for="inputEmail4">Name</label>
                <input type="text" value="${s.name}" name="name" class="form-control" id="inputEmail4" placeholder="Name">
            </div>
            <div class="form-group col-md-3">
                <label for="inputPassword4">Salary</label>
                <input type="text" value="${s.salary}" name="salary" class="form-control" id="inputPassword4" placeholder="Salary">
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">Position</label>
                <select id="inputState" class="form-control" name="position">
                    <option value="${s.position}">${s.position}</option>
                    <option>Manager</option>
                    <option>Staff</option>
                </select>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</c:forEach>
<%@include file="footer.jsp"%>