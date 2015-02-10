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
        <h1>Modification de station dze prelevement</h1>
        <logic:present name="statpr_trouve" >
            <html:form action="enregistrestatpr.do" method="post"> 

                <table>
                    <html:hidden  property="idstat"  name="statpr_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.idstation_prelevement"/> </td>
                        <td class="bord">  <html:text property="idstat_prelevement" size="25" name="statpr_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.localisationlg"/> </td>
                        <td class="bord">  <html:text property="gps_long" size="25" name="statpr_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.localisationlt"/> </td>
                        <td class="bord">  <html:text property="gps_lat" size="25" name="statpr_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.plan_eau"/> </td>
                        <td class="bord"> 

                            <html:select property="idplan_eau"  name="statpr_trouve" >    
                                <html:options collection="planEau_trouve" property="idplan_eau" labelProperty="designation" /> 
                            </html:select>
                        </td>
                    </tr>


                    <tr>
                        <td class="bord">  <bean:message key="stationdeprelevement.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible"  name="statpr_trouve"  >    

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
                            <html:link action="gestionstatpr" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>

            </html:form>

        </logic:present> 
    </body>
</html>
