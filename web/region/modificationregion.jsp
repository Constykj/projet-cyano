<%-- 
    Document   : modificationregion
    Created on : Mar 27, 2014, 10:45:57 AM
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
        <h1>Modification Region </h1>
        <logic:present name="reg_trouve" >
            <html:form action="enregistreModifRegion.do" method="post"> 

                <table>
                    <html:hidden  property="idregion"  name="reg_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="region.designation"/> </td>
                        <td class="bord">  <html:text property="designation" size="25" name="reg_trouve"  />   </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="region.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="reg_trouve">    

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
                            <html:link action="gestionreg" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>
            </html:form>

        </logic:present>
    </body>
</html>
