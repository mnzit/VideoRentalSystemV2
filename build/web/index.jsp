<%-- 
    Document   : index
    Created on : Jul 25, 2018, 4:19:01 PM
    Author     : Dell
--%>

<%@include file="header.jsp"%>

<div class="text-center">
    <h1 class="display-4">Welcome to Video Rental!</h1>
    <p class="lead">The Magic of Blockbuster Video ! Get it all in our shop</p>
    <hr class="my-4">
    <p>We started Video Rental Service in 2017 and while 1080p movies may be a thing of the past, you can still Make it a Blockbuster by using our services renting and buying of new releases and watch with comfort in your home with a life like experience of 4K movies.</p>
    <p class="lead">
        <%if (session.getAttribute("username") != null) {%>
        <a class="btn btn-primary btn-lg" href="welcome.jsp" role="button">Proceed to system</a>
        <%} else {%>
        <a class="btn btn-primary btn-lg" href="login.jsp" role="button">Login</a>
        <%}%>
    </p>
</div>
<%@include file="footer.jsp"%>