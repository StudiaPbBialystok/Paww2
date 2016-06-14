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

            <p>${message}<p>
          
                <%
                    if ((TripController.getPrawda() == 1) & (TripController.getCountryList() != null)) {
                %>

            <table>
               
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                    </tr>
                </thead>
                     <tbody id="test2">


                  <c:forEach items="${attraction}" var="attraction" >
                        <tr >
                            <td>${attraction.id}</td>
                            <td>${attraction.name}</td>
                            <td>${attraction.description}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>


            <% }

            %>



            <script src="<c:url value="/resources/js/site.js"/>"></script>
        </div>

    </body>

</html>