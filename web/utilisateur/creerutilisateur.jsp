<%-- 
    Document   : creerutilisateur
    Created on : Feb 28, 2014, 12:50:12 AM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/menuapp_1.jsp" %>

        <h1>Page creation Utilisateur </h1>

        <html:form action="creerutil.do" method="post" >

            <table>
                <tr> 
                    <td class="bord">  <bean:message key="utilisateur.nom"/> </td>
                    <td class="bord">  <html:text property="nom" size="25"   />  </td>
                    <td class="bord"> <font class="error">   <html:errors property="nom" /> </font> </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="utilisateur.prenom"/> </td>
                    <td class="bord">  <html:text property="prenoms" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="prenoms" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="utilisateur.identifiant"/> </td>
                    <td class="bord">  <html:text property="identifiant" size="25" /></td>
                    <td class="bord"> <font class="error">  <font class="error">   <html:errors property="login" /> </font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="utilisateur.motdepasse"/>  </td>
                    <td class="bord">  <html:password property="mot_de_passe" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="passwd" /> </font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="utilisateur.motdepasse.confirme"/>  </td>
                    <td class="bord">  <html:password property="mot_de_passeb" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="passwdb" /> </font> </td>
                </tr>
                
                <tr>
                    <td class="bord">  <bean:message key="utilisateur.validite"/>  </td>
                    <td class="bord">
                        <html:select property="valide"  >                              
                            <html:option value="false">faux</html:option> 
                            <html:option  value="true">Vrai</html:option>
                        </html:select>
                    </td>
                    <td class="bord">  </td>
                </tr>
               
                <tr>
                        <td class="bord">  <bean:message key="utilisateur.droit"/>  </td>
                        <td class="bord">
                            <html:select property="droit">    
                                
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

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
