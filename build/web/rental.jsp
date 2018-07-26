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

<form method="post" action="RentalController" autocomplete="off">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Member no</label>
            <input type="text" name="memberno" class="form-control" id="member-no" placeholder="Eg: Ramesh">
        </div>
        <div class="form-group col-md-6">
            <label>Video no</label>
            <input type="text" name="copyno" class="form-control" id="video-no" placeholder="Eg: 12">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Rent</button>
</form>
<table class="table mt-4 header-fixed table-hover">
    <thead class="thead-dark">

        <tr><th scope="col">Branch no</th>
            <th scope="col">Rent no</th>
            <th scope="col">Member no</th>
            <th scope="col">Video no</th>
            <th scope="col">Title</th>
            <th scope="col">Daily Rental cost</th>
            <th scope="col">Date Rented</th>
            <th scope="col">Date Returned</th>
            <th scope="col">Operation</th>
        </tr>

    </thead>
    <tbody>
        <tr><td>1</td>
            <td>1</td>
            <td>22</td>
            <td>11</td>
            <td>Sanam</td>
            <td>100</td>
            <td>2016/12/19</td>
            <td>2016/12/22</td>
            <td><a href="RentUpdater?rentno=<c:out value="${r.RENTAL_NO}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${r.RENTAL_NO}', 'catalogDelete')">Delete</button></td>
        </tr>
        <c:forEach items="${rentlist}" var="r">
            <tr id="rent-${r.RENTAL_NO}">
                <td><c:out value="${r.RENTAL_NO}" /></td>
                <td><c:out value="${r.MEMBER_NO}" /></td>
                <td><c:out value="${r.VIDEO_NO}" /></td>
                <td><c:out value="${r.TITLE}" /></td>
                <td><c:out value="${r.DAILY_RENTAL_COST}" /></td>
                <td><c:out value="${r.DATE_RENTED}" /></td>
                <td><c:out value="${r.DATE_RETURNED}" /></td>
                <td><a href="RentUpdater?rentno=<c:out value="${r.RENTAL_NO}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${r.RENTAL_NO}', 'catalogDelete')">Delete</button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<%@include file="footer.jsp"%>