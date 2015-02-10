<%-- 
    Document   : menuapp
    Created on : Feb 24, 2014, 10:54:07 PM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" media="screen, print, handheld" type="text/css" href="style/newcss.css">
        <title>Page Accueil</title>
    </head>
    <body> 

        <div class="entete"> 
            <table>
                <tr >
                    <td>
                        <p class="titre"><bean:message key="menu.titre"/></p>
                        <div class="session">
                            <bean:message key="menu.bienvenue" />, 
                            <bean:write name="nomUtil"  /> 
                            <bean:write name="prenomUtil"  />
                            &nbsp; |
                            <html:link action="deconnexion.do" ><bean:message key="menu.deconnect" /></html:link>
                            </div>
                        </td>
                    </tr>
                </table>




                <div  class="menuenete">
                    <ul id="navigation">

                    <li><html:link styleClass="lien1" forward="pageaccueil" title="aller à la page d'accueil"><bean:message key="menu.accueil" /></html:link></li>
                    <li><html:link styleClass="lien2" action="pagecreation" title="aller à la page création"><bean:message key="menu.creation" /></html:link></li>
                    <li><html:link styleClass="lien3" forward="pagemodif"  title="aller à la page modification"><bean:message key="menu.modification" /></html:link></li>
                    <li><html:link styleClass="lien4" action="rapport"  title="aller à la page rapport"><bean:message key="menu.rapport" /></html:link></li>
                    <li><html:link styleClass="lien5" action="pageadmin" title="aller à la page administration"><bean:message key="menu.administration" /></html:link></li>
     
                </ul>
            </div>

        </div>
        <br/><br/>
       
    </body>

