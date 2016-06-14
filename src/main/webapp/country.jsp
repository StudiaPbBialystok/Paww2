<%-- 
--%>

<%@page import="com.mycompany.zadanie6_test.Country"%>
<%@page import="com.mycompany.zadanie6_test.TripController"%>
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

            <form class="formularz" role="form" method="post" action="/Zadanie6_projekt/search">               
                <input  name="countryName" placeholder="country"
                        pattern="[A-Za-z].{2,30}"   required title="2-30 characters, only letters">               
                <button type="submit" >Search</button>

            </form>
            <p>${message}<p>

                <%
                    if ((TripController.getPrawda() == 1) & (TripController.getCountryList() != null)) {
                %>

            <table>
                <thead>
                    <tr>

                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                <tbody id="test2">


                    <tr >
                        <% Country panstwo = TripController.getCountryList().get(0); %>

                        <td><% out.println(panstwo.getName()); %></td>    
                        <td><% out.println(panstwo.getDescription()); %></td>
                    </tr>

                </tbody>
                <thead>
                    <tr>

                        <th>City</th>
                        <th>Attractions</th>
                    </tr>
                </thead>
                <tbody id="test2">


                    <c:if test="${city.size()>0}">

                        <c:forEach items="${city}" var="city" >
                            <tr >
                                <td>${city.name}</td>
                                <td><button class="attractionButton" value="${city.id}">Atrakcje</button></td>  
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>


            <% }
            %>



            <script src="<c:url value="/resources/js/site.js"/>"></script>
        </div>

    </body>

</html>