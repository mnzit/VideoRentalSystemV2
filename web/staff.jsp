<%-- 
    Document   : staff
    Created on : Jul 25, 2018, 4:21:07 PM
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
<div class="jumbotron mt-4">
    <h1 class="display-4 text-center demo"></h1>
    <form method="post" action="StaffController" autocomplete="off">
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
                <label for="inputEmail4">Name</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Name" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Salary</label>
                <input type="text" name="salary" class="form-control" id="salary" placeholder="Salary" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">Position</label>
                <select id="inputState" class="form-control" name="position" required>
                    <option selected>Choose...</option>
                    <option>Manager</option>
                    <option>Staff</option>
                </select>
            </div>

        </div>
        <button type="submit" class="btn btn-primary">Add Staff</button>
    </form>
    <div class="col-sm-12">
        <table class="table mt-4 header-fixed table-hover">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Branch no</th>
                    <th scope="col">Staff id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Position</th>
                    <th scope="col">Operation</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${stafflist}" var="s">
                    <tr id="staff-${s.staff_no}">
                        <td><c:out value="${s.branch_no}" /></td>
                        <td><c:out value="${s.staff_no}" /></td>
                        <td><c:out value="${s.name}" /></td>
                        <td><c:out value="${s.salary}" /></td>
                        <td><c:out value="${s.position}" /></td>
                        <td>
                            <a href="StaffUpdater?staffno=<c:out value="${s.staff_no}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${s.staff_no}', 'staffDelete')">Delete</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- Yes no Modal -->    
    <div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Confirm to delete record</h5>
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

</div>
<%@include file="footer.jsp"%>
