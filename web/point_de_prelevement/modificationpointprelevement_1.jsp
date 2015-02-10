<%-- 
    Document   : modificationstationprelevement
    Created on : Apr 30, 2014, 10:59:45 PM
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
        <h1>Modification de point de prelevement</h1>
        <logic:present name="ptpr_trouve" >
            <html:form action="enregistreptpr.do" method="post"> 
                <table>
                    <html:hidden  property="idpoint_prelevement"  name="ptpr_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="pointdeprelevement.profondeur"/> </td>
                        <td class="bord">  <html:text property="profondeur" size="25" name="ptpr_trouve"  />   </td>
                    </tr>
                    
                    <tr> 
                        <td class="bord">  <bean:message key="pointdeprelevement.station"/> </td>
                        <td class="bord"> 

                            <html:select property="idstat"  name="ptpr_trouve" >    
                                <html:options collection="statp_trouve" property="idstat" labelProperty="idstat_prelevement" /> 
                            </html:select>
                        </td>
                    </tr>


                    <tr>
                        <td class="bord">  <bean:message key="pointdeprelevement.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible"  name="ptpr_trouve"  >    

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

        </logic:present> 
    </body>
</html>
