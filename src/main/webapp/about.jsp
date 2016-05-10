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
        <link href="<c:url value="/resources/css/about.css" />" rel="stylesheet">

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 
        <title>JSP Page</title>
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

            <table>
                <thead>
                    <tr>
                      
                        <th>Name</th>
                        <th>Created</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="test2">
                    <c:forEach items="${trip}" var="trip" >
                        <tr >
                            
                            <td><button class="stopsBtn" value="${trip.id}">${trip.name}</button></td>
                            <td>${trip.created}</td>
                            <td><button class="editBtn" value="${trip.id}">Edit</button></td>
                            <td><button class="deleteTripBtn" value="${trip.id}">Delete</button></td>  
                        </tr>
                    </c:forEach>
                </tbody>
            </table>


            <form class="formularz" role="form" method="post" action="/Zadanie6_projekt/add">               
                <input  name="tripName"  placeholder="Name" pattern="[A-Za-z].{3,30}"   required title="3-30 characters, only letters">               
                <button type="submit" >Add trip</button>
            </form>

            <script src="<c:url value="/resources/js/site.js"/>"></script>
        </div>

    </body>

</html>