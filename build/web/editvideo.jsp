<%-- 
    Document   : editvideo
    Created on : Jul 25, 2018, 7:31:57 PM
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
<c:forEach items="${videobyno}" var="v">
    <form method="post" action="VideoController" autocomplete="off">
        <div class="form-row">
            <div class="form-group col-md-1">
                <label>Video no</label>
                <input readonly="readonly" type="text" value="${v.video_no}" name="title" class="form-control" id="video-title" placeholder="Eg: Deadpool 2">
            </div>
            <div class="form-group col-md-1">
                <label>Branch no</label>
                <select id="branch_no" class="form-control" name="branchno">
                    <c:forEach items="${branchlist}" var="b">
                        <option value="${b.branch_no}" <c:if test="${v.branch_no eq b.branch_no}">selected</c:if>>${b.branch_no}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label>Choose Catalog</label>
                <select id="catalog_name" class="form-control" name="catalogno">
                    <c:forEach items="${cataloglist}" var="c">
                        <option value="${c.catalog_no}" <c:if test="${v.catalog_no eq c.catalog_no}">selected</c:if>>${c.catalog_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-3">
                <label>Video title (Movie name)</label>
                <input type="text" value="${v.title}" name="title" class="form-control" id="video-title" placeholder="Eg: Deadpool 2">
            </div>
            <div class="form-group col-md-2">
                <label>Daily rental cost</label>
                <input type="text"  value="${v.daily_rental_cost}" name="dailyrentalcost" class="form-control" id="rental-cost" placeholder="Eg: 200">
            </div>
            <div class="form-group col-md-1">
                <label>Cost</label>
                <input type="text" value="${v.cost}" name="cost" class="form-control" id="cost" placeholder="Eg: 500">
            </div>
            <div class="form-group col-md-2">
                <label>No of Copies</label>
                <input type="number" value="${v.no_of_videos}" name="noofvideo" class="form-control" id="catalog-title" placeholder="No. of copies Eg: 20">
            </div>
        </div>
        <h5 class="mt-4 mb-2">GENRES</h5>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Genres 1</label>
                <select id="category-1" class="form-control" name="category-1">
                    <c:forEach items="${categorylist}" var="ct">
                        <option value="${ct.category_no}" <c:if test="${v.category_no_1 eq ct.category_no}">selected</c:if>>${ct.category_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label>Genres 2</label>
                <select id="category-2" class="form-control" name="category-2">
                    <c:forEach items="${categorylist}" var="ct">
                         <option value="${ct.category_no}" <c:if test="${v.category_no_2 eq ct.category_no}">selected</c:if>>${ct.category_name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-4">
                <label>Genres 3</label>
                <select id="category-3" class="form-control" name="category-3">
                    <c:forEach items="${categorylist}" var="ct">
                        <option value="${ct.category_no}" <c:if test="${v.category_no_3 eq ct.category_no}">selected</c:if>>${ct.category_name}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <h5 class="mt-4 mb-2">MAIN ACTORS</h5>
        <div class="form-row">
            <div class="form-group col-md-4">
                <label>Main Actor 1</label>
                <input type="text" name="main_actor_1" value="${v.main_actor_1}" class="form-control" id="main_actor_1" placeholder="Actor 1">
            </div>
            <div class="form-group col-md-4">
                <label>Main Actor 2</label>
                <input type="text" name="main_actor_2" value="${v.main_actor_2}" class="form-control" id="main_actor_2" placeholder="Actor 2">
            </div>
            <div class="form-group col-md-4">
                <label>Main Actor 3</label>
                <input type="text" name="main_actor_3" value="${v.main_actor_3}" class="form-control" id="main_actor_3" placeholder="Actor 3">
            </div>
        </div>
        <h5 class="mt-4 mb-2">MAIN DIRECTOR</h5>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Main Director 1</label>
                <input type="text" name="main_director_1" value="${v.main_director_1}" class="form-control" id="main_director_1" placeholder="Director 1">
            </div>
            <div class="form-group col-md-6">
                <label>Main Director 2</label>
                <input type="text" name="main_director_2" value="${v.main_director_2}" class="form-control" id="main_director_1" placeholder="Director 2">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</c:forEach>

<table class="table mt-4 header-fixed table-hover">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Video no</th>
            <th scope="col">Copy no</th>
            <th scope="col">Status</th>
            <th scope="col">Operation</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${videocopylist}" var="vc">
            <tr id="videocopy-${vc.copy_no}">
                <td><c:out value="${vc.video_no}"/></td>
                <td><c:out value="${vc.copy_no}"/></td>
                <td><c:out value="${vc.status}"/></td>            
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter2" onclick ="dataSender('${vc.copy_no}', 'videoCopyDelete')">Delete</button>
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
                <h5 class="modal-title" id="exampleModalLabel">Confirm to delete copy</h5>
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
