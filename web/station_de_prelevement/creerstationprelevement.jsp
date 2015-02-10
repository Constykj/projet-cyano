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

        <h1>Creation Station de prelevement</h1>
         
            <html:form action="creerstatpr.do" method="post" >

                <table>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.habitat"/> </td>
                        <td class="bord"> 

                            <html:select property="idhabitat" styleId="hb"  >    
                                <html:options collection="hab_trouve" property="idhabitat" labelProperty="design_habitat"     /> 
                            </html:select>
                        </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.localisationLG"/> </td>
                        <td class="bord">  <html:text property="gps_long" size="25"   />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.localisationLT"/> </td>
                        <td class="bord">  <html:text property="gps_lat" size="25"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.idstation_prelevement"/> </td>
                        <td class="bord">  <html:text property="idstat_prelevement" size="25" styleId="stp11"/>   </td>
                    </tr>

                    <tr> 
                        <td class="bord">  <bean:message key="stationdeprelevement.plan_eau"/> </td>
                        <td class="bord"> 

                            <html:select property="idplan_eau" styleId="pe"  >    
                                <html:options collection="stat_trouve" property="idplan_eau" labelProperty="designation"     /> 
                            </html:select>
                        </td>
                    </tr>


                    <tr>
                        <td class="bord">  <bean:message key="stationdeprelevement.visible"/>  </td>
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
                            <html:link action="gestionstatpr" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>
            </html:form>
            
             <%@include file="/piedpage.jsp" %>
         
        <!--
        

        
        <div id="map2" >
            <div id="mapcreationst" style="width: 500px; height: 400px; border: 1px solid
             #777; overflow: hidden;"></div>
        </div>
 -->
     
    </body>
     
</html>
