<%-- 
--%>

<%@page import="com.mycompany.zadanie6_test.Country"%>
<%@page import="com.mycompany.zadanie6_test.TripController"%>
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
                    <form class="siderbarButtons"  method="post" action="/Zadanie6_test/About.jsp">
                        <div><input  type="submit" value="Państwa" name="dodaj"></div>
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

            <form class="formularz" role="form" method="post" action="/Zadanie6_projekt/search">               
                <input  name="countryName" placeholder="country">               
                <button type="submit" >Search</button>

            </form>
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


                    <tr >
                        <% Country panstwo = TripController.getCountryList().get(0); %>
                        <td><% out.println(panstwo.getId()); %></td>
                        <td><% out.println(panstwo.getName()); %></td>    
                        <td><% out.println(panstwo.getDescription()); %></td>
                    </tr>

                </tbody>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>City</th>
                        <th>Attractions</th>
                    </tr>
                </thead>
                     <tbody id="test2">


                  <c:forEach items="${city}" var="city" >
                        <tr >
                            <td>${city.id}</td>
                            <td>${city.name}</td>
                            <td>${city.description}</td>
                            <td><button id="attractionButton">Atrakcje</button></td>  
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