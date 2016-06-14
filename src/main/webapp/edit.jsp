<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>JSP Page</title>
    </head>


    <body>

        <div id="sidebar">   
            <%@include file="menu.html" %>
        </div>

        <div id="wrapper">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <button id="sidebarToggle" class="btn btn-primary">
                                <i class="fa fa-angle-left"></i> <-
                            </button>
                        </li>
                    </ul>
                    <a  class="navbar-brand col-sm-offset-5"><h3>Travels</h3></a>                   
                </div>
            </nav>    


            <form class="form-inline col-sm-offset-4 formularz" role="form" method="post"
                  action="/Zadanie6_projekt/edit">
                <div class="form-group">
                    <input id="tripName" name="tripName" placeholder="Name"
                           pattern="[A-Za-z].{3,30}"   required title="3-30 characters">
                </div>
                <button type="submit" class="btn btn-primary">Edytuj</button>
            </form>


        </div>
        <script src="<c:url value="/resources/js/site.js"/>"></script>
    </body>

</html>
