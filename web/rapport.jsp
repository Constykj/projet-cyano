<%-- 
    Document   : rapport
    Created on : Feb 27, 2014, 11:25:48 AM
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
        
        <%@include file="menuapp.jsp" %>

        <br/><br/><br/><br/><br/><br/><br/>

        <div class="bloc_1">

            <fieldset  class="bloc_2">
                <p>Nombre d'échantillon</p> 
                <p class="ssblock">
                   
                    
                    <bean:write name="liste_nombre" property="nbEchantillons" />
                </p> 
            </fieldset>



            <fieldset class="bloc_3">
                
                
                <p>Nombre point de prelevemnt</p>
                <p class="ssblock">
                    <bean:write name="liste_nombre" property="nbPointP" />
                </p> 
            </fieldset>



            <fieldset class="bloc_3" >

                <p>Nombre de station de prelevement</p>
                <p class="ssblock">
                    <bean:write name="liste_nombre" property="nbStationP" />
                </p> 
            </fieldset>


            <fieldset  class="bloc_2" >

                <p> Nombre de plan d'eau:</p>
                <p class="ssblock">
                    <bean:write name="liste_nombre" property="nbPlanE" />
                </p> 
            </fieldset>



        </div>

        <div id="bloc_t">


            <table class="mtable">

                <thead  class="mheader">
             
                <td  class="tit">  Identifiant chantillon </td>                                   
                <td  class="tit" >  Point de prelevement</td>  
                <td   class="tit">  Station de prelevement </td>                                   
                <td   class="tit">  Plan d'eau </td> 

                </thead> 
                <logic:iterate name="liste_echant"  id="ech" indexId="cnt">
                    <tr class="av" > 

                        
                        <td  class="mtd" >  <bean:write name="ech" property="idEchantillon" /> </td> 
                        <td class="mtd" >  <bean:write name="ech" property="pointPrelev" /> </td>
                        <td  class="mtd">  <bean:write name="ech" property="stationPrelev" /> </td> 
                        <td  class="mtd">  <bean:write name="ech" property="planEau" /> </td> 


                    </tr>
                </logic:iterate>

            </table>

        </div>
        <div>
            <%@include file="piedpage.jsp" %>
        </div>
    </body>
</html>
