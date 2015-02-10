<%-- 
    Document   : modificationUtilisateur
    Created on : Mar 2, 2014, 5:23:57 PM
    Author     : HP USER
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
        <h1>Page modification</h1>
        <logic:present name="util_trouve" >
            <html:form action="enregistreModifUtilisateur.do" method="post">

                <table>
                    <html:hidden  property="iduser"  name="util_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="utilisateur.nom"/> </td>
                        <td class="bord">  <html:text property="nom" size="25" name="util_trouve"  />   </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="utilisateur.prenom"/> </td>
                        <td class="bord">  <html:text property="prenoms" size="25" name="util_trouve"/> </td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="utilisateur.identifiant"/> </td>
                        <td class="bord">  <html:text property="identifiant" size="25" name="util_trouve" /></td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="utilisateur.motdepasse"/>  </td>
                        <td class="bord">  <html:password property="mot_de_passe" size="25" name="util_trouve"/></td>
                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="utilisateur.motdepasse.confirme"/>  </td>
                        <td class="bord">  <html:password property="mot_de_passe" size="25" name="util_trouve"/></td>
                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="utilisateur.validite"/>  </td>
                        <td class="bord">
                            <html:select property="valide" name="util_trouve">    
                                
                                <html:option value="false">faux</html:option> 
                                <html:option  value="true">Vrai</html:option>

                            </html:select>
                        </td>
                    </tr>
                    
                     <tr>
                        <td class="bord">  <bean:message key="utilisateur.droit"/>  </td>
                        <td class="bord">
                            <html:select property="droit" name="util_trouve">    
                                
                                <html:option value="1">Utilisateur</html:option> 
                                <html:option  value="2">Super Utilisateur</html:option>

                            </html:select>
                        </td>
                    </tr>
                    <tr>
                        <td class="bord">  &nbsp;  </td>
                        <td class="bord">  &nbsp;  </td>
                    </tr>
                    <tr>
                        <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                            <html:link action="gestionutil" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>

            </html:form>

        </logic:present>
    </body>
</html>
