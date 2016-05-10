<%-- 
    Document   : template_admin
    Created on : 2016-05-10, 15:40:57
    Author     : Tomek
--%>

<%@tag description="template" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>

<%@attribute name="page_title" fragment="true" %>
<%@attribute name="page_h1" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script type="text/javascript" src="lib/jquery/dist/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
        <link href="<c:url value="/resources/css/about.css" />" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 

        <!-- <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
         <link rel="stylesheet" href="<c:url value="/resources/main.css" />" type="text/css"/>
         <script src="<c:url value="/resources/jquery-2.2.3.min.js"/>"></script>
         <script src="<c:url value="/resources/main.js"/>"></script>
         <title><jsp:invoke fragment="page_title"/></title> -->
    </head>
    <body>
        <div id="sidebar">   
            <span id="username"></span>
            <ul>             
                <li> 
                    <form class="siderbarButtons" method="get" action="/Zadanie6_projekt/about">
                        <div><input  type="submit"  value="Strona główna"></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="get" action="/Zadanie6_projekt/map">
                        <div><input  type="submit" value="Mapa" ></div>
                    </form> 
                </li>
                <li>
                    <form class="siderbarButtons"  method="get" action="/Zadanie6_projekt/country">
                        <div><input  type="submit" value="Państwa" ></div>
                    </form> 
                </li>               
            </ul>
        </div>
        <div id="wrapper"> 
            <jsp:doBody/>
        </div>
    </body>
</html>