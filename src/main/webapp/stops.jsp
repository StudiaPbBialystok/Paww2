

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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

            <table>
                <thead>
                    <tr>
                        <th>Nazwa</th>
                        <th>Data</th>
                        <th>Szerokość geograficzna</th>
                        <th>Długość geograficzna</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody class="col-sm-offset-2">
                    <c:forEach items="${stops}" var="stop" >
                        <tr >
                            <td><button class="tripmap" a="${stop.latitude}" b="${stop.longitude}">${stop.name}</button></td>
                            <td><fmt:formatDate pattern="yyyy-MM-dd" 
                                            value="${stop.arrival}" /></td>
                            <td class="szer" > <fmt:formatNumber type="number" 
                                              maxIntegerDigits="3" value="${stop.latitude}" /></td>
                            <td class="dlugosc"><fmt:formatNumber type="number" 
                                              maxIntegerDigits="3" value="${stop.longitude}" /></td>
                            <td><button class="deleteStopBtn" itemid="${stop.tripid}" value="${stop.id}">Delete</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <form class="formularz" role="form" method="post" action="/Zadanie6_projekt/stops/${tripId}">               
                <input  name="location" placeholder="Name"  pattern="[A-Za-z].{2,20}"   required title="2-20 characters, only letters">               
                <input  name="date" placeholder="Data" pattern="(?:19|20)[0-9]{2}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-9])|(?:(?!02)(?:0[1-9]|1[0-2])-(?:30))|(?:(?:0[13578]|1[02])-31))"
                        required title="format YYYY-MM-DD"       >
                <button type="submit" >Add stop</button>
            </form>    
            <div id="outermap">
                <div id="map"></div> 
            </div>
        </div>



        <script src="https://maps.googleapis.com/maps/api/js?callback=initMap"
        async defer></script>
        <script src="<c:url value="/resources/js/site.js"/>"></script>
    </body>

</html>