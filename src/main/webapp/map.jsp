<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <title>Mapa</title>
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
                                <i class="fa fa-angle-left"></i> Menu
                            </button>
                        </li>
                    </ul>
                    <a  class="navbar-brand col-sm-offset-5"><h3>Travels</h3></a>                   
                </div>
            </nav>    

            <div id="mapa"></div>            


            <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
            async defer></script>
            <script src="<c:url value="/resources/js/site.js"/>"></script>
        </div>

    </body>

</html>