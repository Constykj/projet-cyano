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
        
  <%--       <h1><bean:message key="page.accueil" /> </h1> --%>
  
  <img class="img" src="image/bio4.jpg"/>
        
        <h2>  <font class="error"> <html:errors property="errright" /></font>  </h2> 
        <br/><br/><br/>
        <%@include file="piedpage.jsp" %>
    </body>
</html>
