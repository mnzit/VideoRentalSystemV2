<%-- 
    Document   : member
    Created on : Jul 25, 2018, 4:21:15 PM
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

<div class="jumbotron ">
    <h1 class="display-4 text-center">Add Members</h1>
    <form method="post" action="MemberController" autocomplete="off">
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
                <label for="inputEmail4">Firstname</label>
                <input class="form-control" name="fname" placeholder="firstname">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Lastname</label>
                <input class="form-control" name="lname" placeholder="lastname">
            </div>
            <div class="form-group col-md-4">
                <label for="inputPassword4">Address</label>
                <input class="form-control" name="address" placeholder="address">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add Member</button>
    </form>
        <table class="table mt-4">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Branch no</th>
                    <th scope="col">Member id</th>
                    <th scope="col">Firstname</th>
                    <th scope="col">Lastname</th>
                    <th scope="col">Address</th>
                    <th scope="col">Registration date</th>
                    <th scope="col">Operations</th>
                </tr>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${memberlist}" var="m">
                    <tr id="member-${m.member_no}">
                        <td><c:out value="${m.branch_no}" /></td>
                        <td><c:out value="${m.member_no}" /></td>
                        <td><c:out value="${m.fname}" /></td>
                        <td><c:out value="${m.lname}" /></td>
                        <td><c:out value="${m.address}" /></td>
                        <td><c:out value="${m.registration_date}" /></td>
                        <td>
                            <a href="MemberUpdater?memberno=<c:out value="${m.member_no}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${m.member_no}', 'memberDelete')">Delete</button>
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
<%@include file="footer.jsp"%>