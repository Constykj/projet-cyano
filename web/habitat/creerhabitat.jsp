<%-- 
    Document   : creerPleanEau
    Created on : Mar 31, 2014, 11:05:43 PM
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
        <script src="control.js"></script>
        <h1>Creation Habitat </h1>

        <html:form action="creerhabitat.do" method="post" >

            <table>

                <tr> 
                    <td class="bord">  <bean:message key="habitat.distance"/> </td>
                    <td class="bord">  <html:text property="dist_bord_lagune" size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="habitat.design_habitat"/> </td>
                    <td class="bord">  <html:text property="design_habitat" size="25"  />   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="habitat.effectif"/> </td>
                    <td class="bord">  <html:text property="effectif"    size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  />   </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="habitat.planEau"/> </td>
                    <td class="bord"> 

                        <html:select property="idplan_eau"   >    
                            <html:options collection="planE_trouve" property="idplan_eau" labelProperty="designation" /> 
                        </html:select>
                    </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="habitat.materiaux"/> </td>
                    <td class="bord"> 

                        <html:select   property="idmat_const"  multiple="true">    
                            <html:options  collection="mat_trouve" property="idmateriaux_construction" labelProperty="lib_materiaux_construction" /> 
                        </html:select>
                    </td> 
                </tr>



                <tr>
                    <td class="bord">  <bean:message key="habitat.visible"/>  </td>
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

                <tr>
                    <td colspan="2"  class="bord">  <html:submit value="Enregistrer"   /> <html:reset /> &nbsp;
                        <html:link action="gestionhabitat" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>

                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

