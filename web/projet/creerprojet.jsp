<%-- 
    Document   : creerprojet
    Created on : Mar 28, 2014, 1:50:20 AM
    Author     : Abouchou
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

        <h1>Creation Projet </h1>

        <html:form action="creerprojet.do" method="post" >

            <table>


                <tr>
                    <td class="bord">  <bean:message key="projet.designation"/> </td>
                    <td class="bord">  <html:textarea property="design_projet" cols="26" rows="4" /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.financement"/> </td>
                    <td class="bord">  <html:text property="source_financement" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.collaborateur"/> </td>
                    <td class="bord">  <html:textarea property="collabor_projet" cols="26" rows="4"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.debut"/> </td>
                    <td class="bord">  <html:text property="debut_projet" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.fin"/> </td>
                    <td class="bord">  <html:text property="fin_projet" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.caracteristique"/> </td>
                    <td class="bord">  <html:textarea property="caract_projet" cols="26" rows="4"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="projet.visible"/>  </td>
                    <td class="bord">
                        <html:select property="visible">    

                            <html:option value="1">Valide</html:option> 
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

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

