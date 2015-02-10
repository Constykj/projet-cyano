<%-- 
    Document   : modificationQuartier
    Created on : Mar 12, 2014, 1:13:32 AM
    Author     : Abouchou
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/menuapp_1.jsp" %>
        <h1>Modification Quartier </h1>
        <logic:present name="quart_trouve" >
            <html:form action="enregistreModifQuartier.do" method="post"> 

                <table>
                    <html:hidden  property="idquartier"  name="quart_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="quartier.designation"/> </td>
                        <td class="bord">  <html:text property="designation" size="25" name="quart_trouve"  />   </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="quartier.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="quart_trouve">    

                                <html:option value="1">valide</html:option> 
                                <html:option  value="0">Non valide</html:option>

                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td class="bord">  &nbsp;  </td>
                        <td class="bord">  &nbsp;  </td>
                    </tr>
                    <tr>
                        <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                            <html:link action="gestionquart" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>
            </html:form>

        </logic:present>
    </body>
</html>
