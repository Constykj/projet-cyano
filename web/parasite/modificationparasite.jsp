<%-- 
    Document   : modificationpratique
    Created on : Mar 30, 2014, 12:56:22 AM
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
        <h1>Modification Parasite</h1>
        <logic:present name="para_trouve" >
            <html:form action="enregistreModifParasite.do" method="post">
             
                <table>
                    <html:hidden  property="idparasite"  name="para_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="parasite.cryptosporidium"/> </td>
                        <td class="bord">  <html:text property="cryptosporidium" size="25" name="para_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="parasite.giardia"/> </td>
                        <td class="bord">  <html:text property="giardia" size="25" name="para_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="parasite.helminthe"/> </td>
                        <td class="bord">  <html:text property="helminthe" size="25" name="para_trouve"  />   </td>
                    </tr>
                
                     <tr>
                        <td class="bord">  <bean:message key="parasite.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="para_trouve">    
                                
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
                            <html:link action="gestionParasite" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>

            </html:form>

        </logic:present>
    </body>
</html>
