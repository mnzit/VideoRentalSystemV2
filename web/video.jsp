<%-- 
    Document   : Video
    Created on : Jul 25, 2018, 4:20:14 PM
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

<form method="post" action="VideoController" autocomplete="off">
    <div class="form-row">
        <div class="form-group col-md-1">
            <label>Branch no</label>
            <select id="branch_no" class="form-control" name="branchno">
                <c:forEach items="${branchlist}" var="b">
                    <option value="${b.branch_no}">${b.branch_no}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-2">
            <label>Choose Catalog</label>
            <select id="catalog_name" class="form-control" name="catalogno">
                <c:forEach items="${cataloglist}" var="c">
                    <option value="${c.catalog_no}">${c.catalog_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-3">
            <label>Video title (Movie name)</label>
            <input type="text" name="title" class="form-control" id="video-title" placeholder="Eg: Deadpool 2">
        </div>
        <div class="form-group col-md-2">
            <label>Daily rental cost</label>
            <input type="text" name="dailyrentalcost" class="form-control" id="rental-cost" placeholder="Eg: 200">
        </div>
        <div class="form-group col-md-2">
            <label>Cost</label>
            <input type="text" name="cost" class="form-control" id="cost" placeholder="Eg: 500">
        </div>
        <div class="form-group col-md-2">
            <label>No of Copies</label>
            <input type="number" name="noofvideo" class="form-control" id="catalog-title" placeholder="No. of copies Eg: 20">
        </div>
    </div>
    <h5 class="mt-4 mb-2">GENRES</h5>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label>Genres 1</label>
            <select id="category-1" class="form-control" name="category-1">
                <c:forEach items="${categorylist}" var="ct">
                    <option value="${ct.category_no}">${ct.category_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label>Genres 2</label>
            <select id="category-2" class="form-control" name="category-2">
                <c:forEach items="${categorylist}" var="ct">
                    <option value="${ct.category_no}">${ct.category_name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-4">
            <label>Genres 3</label>
            <select id="category-3" class="form-control" name="category-3">
                <c:forEach items="${categorylist}" var="ct">
                    <option value="${ct.category_no}">${ct.category_name}</option>
                </c:forEach>
            </select>
        </div>

    </div>
    <h5 class="mt-4 mb-2">MAIN ACTORS</h5>
    <div class="form-row">
        <div class="form-group col-md-4">
            <label>Main Actor 1</label>
            <input type="text" name="main_actor_1" class="form-control" id="main_actor_1" placeholder="Actor 1">
        </div>
        <div class="form-group col-md-4">
            <label>Main Actor 2</label>
            <input type="text" name="main_actor_2" class="form-control" id="main_actor_2" placeholder="Actor 2">
        </div>
        <div class="form-group col-md-4">
            <label>Main Actor 3</label>
            <input type="text" name="main_actor_3" class="form-control" id="main_actor_3" placeholder="Actor 3">
        </div>
    </div>
    <h5 class="mt-4 mb-2">MAIN DIRECTOR</h5>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label>Main Director 1</label>
            <input type="text" name="main_director_1" class="form-control" id="main_director_1" placeholder="Director 1">
        </div>
        <div class="form-group col-md-6">
            <label>Main Director 2</label>
            <input type="text" name="main_director_2" class="form-control" id="main_director_1" placeholder="Director 2">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Add</button>
</form>

<table class="table mt-4 header-fixed table-hover">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Branch no</th>
            <th scope="col">Video no</th>
            <th scope="col">Catalog name</th>
            <th scope="col">Title</th>
            <th scope="col">Daily Rental cost</th>
            <th scope="col">Cost</th>
            <th scope="col">Genres</th>
            <th scope="col">No of videos</th>
            <th scope="col">Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${videolist}" var="v">
            <tr id="video-${v.video_no}">
                <td><c:out value="${v.branch_no}"/></td>
                <td><c:out value="${v.video_no}"/></td>
                <td><c:out value="${v.catalog_name}"/></td>
                <td><c:out value="${v.title}" /></td>
                <td><c:out value="${v.daily_rental_cost}" /></td>
                <td><c:out value="${v.cost}" /></td>
                <td><span class="badge badge-primary ${v.category_1_name}"><c:out value="${v.category_1_name}"/></span>&nbsp;&nbsp;<span class="badge badge-primary ${v.category_2_name}"><c:out value="${v.category_2_name}"/></span>&nbsp;&nbsp;<span class="badge badge-primary ${v.category_3_name}"><c:out value="${v.category_3_name}"/></span></td>
                <td><c:out value="${v.no_of_videos}" /></td>
                <td>
                    <a href="VideoUpdater?videono=<c:out value="${v.video_no}"/>" class="btn btn-primary mr-4 clicker">Edit</a>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${v.video_no}', 'videoDelete')">Delete</button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<!-- Yes no Modal -->    
<div class="modal fade" id="exampleModalCenter2" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirm to delete video</h5>
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