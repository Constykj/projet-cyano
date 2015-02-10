<%-- 
    Document   : modificationprojet
    Created on : Mar 28, 2014, 1:50:52 AM
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
        <h1>Modification Projet </h1>
        <logic:present name="proj_trouve" >
            <html:form action="enregistreModifProjet.do" method="post"> 

                <table>
                    <html:hidden  property="idprojet"  name="proj_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="projet.designation"/> </td>
                        <td class="bord">  <html:textarea property="design_projet" cols="26" rows="4" name="proj_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="projet.financement"/> </td>
                        <td class="bord">  <html:text property="source_financement" size="25" name="proj_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="projet.collaborateur"/> </td>
                        <td class="bord">  <html:textarea  property="collabor_projet" cols="26" rows="4" name="proj_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="projet.debut"/> </td>
                        <td class="bord">  <html:text property="debut_projet" size="25" name="proj_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="projet.fin"/> </td>
                        <td class="bord">  <html:text property="fin_projet" size="25" name="proj_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="projet.caracteristique"/> </td>
                        <td class="bord">  <html:textarea property="caract_projet" cols="26" rows="4" name="proj_trouve"  />   </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="projet.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="proj_trouve">    

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
                            <html:link action="gestionproj" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>
            </html:form>

        </logic:present>
    </body>
</html>
