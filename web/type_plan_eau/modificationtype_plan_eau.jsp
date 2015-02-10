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
        <h1>Modification Type plan eau </h1>
        <logic:present name="typpe_trouve" >
            <html:form action="enregistreModifType_plan_eau.do" method="post"> 

                <table>
                    <html:hidden  property="idtype_plan_eau"  name="typpe_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="type_plan_eau.designation"/> </td>
                        <td class="bord">  <html:text property="designation" size="25" name="typpe_trouve"  />   </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="type_plan_eau.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="typpe_trouve">    

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
                            <html:link action="gestiontyppe" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>
            </html:form>

        </logic:present>
    </body>
</html>
