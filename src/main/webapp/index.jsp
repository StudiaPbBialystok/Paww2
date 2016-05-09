<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>

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
                <form  class="login-container" method="post" action="">
                    <p><input type="email" name="email" placeholder="Email" required></p>
                    <p><input type="password" name="password" placeholder="Password" required></p>
                    <p><input type="submit" value="Log in"></p>
                    <p>${message}</p>                  
                    
                </form>
            </div>
        </div>

        <div id="top" >
            <p>Podróże kształcą</p>
        </div>

    </body>

</html>

