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

        <h1>Genre Algue </h1>

        <html:form action="creergenre_alg.do" method="post" >

            <table>
                

                <tr>
                    <td class="bord">  <bean:message key="genre_algue.designation"/> </td>
                    <td class="bord">  <html:text property="design_genre_algue" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="desigerror" /></font>  </td>
                </tr>

                </tr>

                   <tr> 
                    <td class="bord">  <bean:message key="genre_algue.famille"/> </td>
                    <td class="bord"> 

                        <html:select property="idfamille"   >    
                            <html:options collection="fanie_trouve" property="idfamille" labelProperty="design_famille" /> 
                        </html:select>
                    </td>
                </tr>
                <tr>
                        <td class="bord">  <bean:message key="genre_algue.visible"/>  </td>
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
                        <html:link action="gestiongenre_alg" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>
                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
