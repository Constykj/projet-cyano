<%-- 
    Document   : creerautre_algue
    Created on : Apr 7, 2014, 9:17:56 PM
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

        <h1>Creation Espèce Cyanobactérie </h1>

        <html:form action="creerespece_cyano.do" method="post" >

            <table>


                <tr>
                    <td class="bord">  <bean:message key="espece_cyano.designation"/> </td>
                    <td class="bord">  <html:text property="design_espece_cyano" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="espece_cyano.genre_cyano"/> </td>
                    <td class="bord"> 

                        <html:select property="idgenre_cyano"   >    
                            <html:options collection="genre_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                        </html:select>
                    </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="espece_cyano.visible"/>  </td>
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
                        <html:link action="gestionespece_cyano" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>
                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
