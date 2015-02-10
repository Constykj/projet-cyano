<%-- 
    Document   : login
    Created on : Feb 24, 2014, 2:52:07 PM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d&CloseCurlyQuote;accueil Pro</title>
        <link rel="stylesheet" media="screen" href="style/newcss.css" type="text/css">
        <link rel="icon" type="image/jpg" href="images/icone.jpg" />
    </head>

    <body >  
        <header>  
           
        </header>
        <html:form method="post" action="loginapp.do" focus="userId" >

            <fieldset class="field">
                <legend> <bean:message key="authent.head"/> </legend>
              
                <table>
                     <tr>
                         <td class="bord">  </td>
                        <td colspan="2"  class="bord">  <font class="error"> <html:errors property="errcon" /></font></td>
                         
                    </tr>
                    <tr>
                        <td class="bord"> <bean:message key="authent.login"/> </td>
                        <td class="bord"> <html:text property="userId" size="25" /> </td>
                        <td class="bord"> <font class="error">  <html:errors property="login" /> </font> </td>
                    </tr>
                    <tr>
                        <td class="bord"> <bean:message key="authent.password"/> </td>
                        <td class="bord"> <html:password  property="passWd" size="25"/>  </td>
                        <td class="bord"> <font class="error">  <html:errors property="password"  /> </font> </td>
                    </tr>
                    <tr>
                        <td class="bord">
                            &nbsp;
                        </td>
                    </tr>
                    <tr>                     
                        <td colspan="3" class="bord">
                            <html:submit ><bean:message key="authent.submit"/></html:submit> 
                            <html:reset><bean:message key="authent.reset"/></html:reset>
                        </td>
                    </tr>
                </table>

            </fieldset>   
            
        </html:form>


        <footer>


        </footer> <!-- Fin --> 
    </body>
</html>
