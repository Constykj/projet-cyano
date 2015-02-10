<%-- 
    Document   : accueil.jsp
    Created on : Feb 24, 2014, 10:07:57 PM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen, print, handheld" type="text/css" href="style/newcss.css">
        <title>Page Accueil</title>
    </head>
    <body>
        <%@include file="menuapp.jsp" %>
        
        <script >
            arlet("Rien Pour L'instant");
        </script>    
        <%@include file="piedpage.jsp" %>
    </body>
</html>
