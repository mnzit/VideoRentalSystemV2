<%-- 
    Document   : login
    Created on : Jul 25, 2018, 4:21:41 PM
    Author     : Dell
--%>

<%@include file="header.jsp"%>
<form method="post" class="form-signin mt-5 text-center" action="LoginController" autocomplete="off">
    <img class="mb-5" src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/46/Blockbuster_logo.svg/2000px-Blockbuster_logo.svg.png" alt="" width="170" height="100">
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="inputEmail" class="sr-only">Username</label>
    <input name ="uname" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
    <label for="inputPassword" class="sr-only">Password</label>
    <input type="password" name ="upass" id="inputPassword" class="form-control" placeholder="Password" required>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>  
<%@include file="footer.jsp"%>