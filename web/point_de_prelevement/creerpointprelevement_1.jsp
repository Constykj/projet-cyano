<%-- 
    Document   : creerstationprelevement
    Created on : Apr 30, 2014, 10:57:38 PM
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

        <h1>Creation Point de prelevement</h1>

        <html:form action="creerptpr.do" method="post" >

            <table>
                
                <tr> 
                    <td class="bord">  <bean:message key="pointdeprelevement.profondeur"/> </td>
                    <td class="bord">  <html:text property="profondeur" size="25"  />   </td>
                </tr>
                 

                <tr> 
                    <td class="bord">  <bean:message key="pointdeprelevement.station"/> </td>
                    <td class="bord"> 

                        <html:select property="idstat"   >    
                            <html:options collection="ptpr_trouve" property="idstat" labelProperty="idstat_prelevement" /> 
                        </html:select>
                    </td>
                </tr>
              
                 
                <tr>
                    <td class="bord">  <bean:message key="pointdeprelevement.visible"/>  </td>
                    <td class="bord">
                        <html:select property="visible">    

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
                        <html:link action="gestionptpr" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>

                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
