<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script type="text/javascript" src="lib/jquery/dist/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
        <script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
        <link href="<c:url value="/resources/css/about.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/site.js"/>" type="text/javascript"></script>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 
        <title>Mapa</title>
    </head>


    <body>

        <div id="sidebar">   
            <span id="username"></span>
            <ul>             
                <li> 
                    <form class="siderbarButtons" method="get" action="/Zadanie6_projekt/about">
                        <div><input  type="submit"  value="Strona główna" name="return"></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="post" action="/Zadanie6_test/About.jsp">
                        <div><input  type="submit" value="!" name="dodaj"></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="post" action="/Zadanie6_test/About.jsp">
                        <div><input  type="submit" value="!" name="dodaj"></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="post" action="/Zadanie6_test/About.jsp">
                        <div><input  type="submit" value="" name="dodaj"></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="post" action="/Zadanie6_test/About.jsp">
                        <div><input type="submit" value="" name="dodaj"></div>
                    </form> 
                </li>
            </ul>
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

            <div id="mapa"></div>            
            

            <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
            async defer></script>
            <script src="<c:url value="/resources/js/site.js"/>"></script>
        </div>

    </body>

</html>