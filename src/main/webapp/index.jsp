<%-- 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
        <script type="text/javascript" src="lib/jquery/dist/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>       
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">       

        <link rel="stylesheet" href="<c:url value="/resources/css/index.css" />" />
        <title>Login Page</title>
    </head>
    <body>
        <div id="top" >                                   
            <p>Travels</p>  
        </div>
        <div id="main" >
            <div class="login" ng-app="myApp">
                <div class="login-triangle"></div>
                <h2 class="login-header">Log in</h2>
                <form  class="login-container" method="post" ng-controller="validateCtrl" name="myForm" novalidate >
                    <p><input id="emailInput" type="email" name="email" placeholder="Email" ng-model="useremail" required>
                        <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
                            <br><span ng-show="myForm.email.$error.email">Invalid email address.</span>                                                       
                        </span>
                    </p>
                    <p><input id="passwordInput" type="password" name="pass" placeholder="Password" ng-model="userpass" required>
                        <span style="color:red" ng-show="myForm.pass.$dirty && myForm.pass.$invalid">
                            <br><span ng-show="myForm.pass.$error.required">Password is required.</span>
                        </span>
                    </p>
                    <p><input class="test" type="submit" value="Log in" ng-disabled="myForm.$invalid"></p>
                    <p class="return" style="display:none"></p>


                </form>
            </div>
        </div>

        <div id="top" >
            <p>Podróże kształcą</p>
        </div>
        <script src="<c:url value="/resources/js/site.js"/>"></script>
    </body>
    <script>
                        var app = angular.module('myApp', []);
                        app.controller('validateCtrl', function ($scope) {
                        });

    </script>
</html>

