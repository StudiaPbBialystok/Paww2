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
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       

        <link rel="stylesheet" href="<c:url value="/resources/css/index.css" />" />
        <title>Login Page</title>
    </head>
    <body>
        <div id="top" >                                   
            <p>Travels</p>  
        </div>
        <div id="main" >
            <div class="login">
                <div class="login-triangle"></div>
                <h2 class="login-header">Log in</h2>
                <form  class="login-container" method="post" >
                    <p><input id="emailInput" type="email" name="email" placeholder="Email" required></p>
                    <p><input id="passwordInput" type="password" name="password" placeholder="Password"
                    
                              pattern=".{5,10}" required title="5 to 10 characters"></p>
                    <p><input class="test" type="submit" value="Log in"></p>
                    <p class="return" style="display:none"></p>
                   
                    
                </form>
            </div>
        </div>

        <div id="top" >
            <p>Podróże kształcą</p>
        </div>
        <script src="<c:url value="/resources/js/site.js"/>"></script>
    </body>

</html>

