<%-- 
    Document   : modificationPlanEau
    Created on : Mar 31, 2014, 11:06:55 PM
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
        <%@include file="/menuapp_1.jsp" %>
        <script src="control.js"></script>
        <h1>Modification des Habitats</h1>
        <logic:present name="habitat_trouve" >
            <html:form action="enregistreModifHabitatAction.do" method="post"> 

                <table>
                    <html:hidden  property="idhabitat"  name="habitat_trouve"  /> 
                    <html:hidden  property="idligne_habitat"  name="habitat_trouve"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="habitat.distance"/> </td>
                        <td class="bord">  <html:text property="dist_bord_lagune" size="25" name="habitat_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="habitat.design_habitat"/> </td>
                        <td class="bord">  <html:text property="design_habitat" size="25" name="habitat_trouve"  />   </td>
                    </tr>
                    <tr> 
                        <td class="bord">  <bean:message key="habitat.effectif"/> </td>
                        <td class="bord">  <html:text property="effectif" size="25" name="habitat_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>   </td>
                    </tr>

                    <tr> 
                        <td class="bord">  <bean:message key="habitat.planEau"/> </td>
                        <td class="bord"> 

                            <html:select property="idplan_eau" name="habitat_trouve"  >    
                                <html:options collection="planeau_trouve" property="idplan_eau" labelProperty="designation" /> 
                            </html:select>
                        </td>
                    </tr>

                    <tr> 
                        <td class="bord">  <bean:message key="habitat.materiaux"/> </td>
                        <td class="bord"> 

                            <html:select   property="idmateriaux_construction"  name="habitat_trouve"    multiple="true">    
                                <html:options  collection="mat_trouve" property="idmateriaux_construction" labelProperty="lib_materiaux_construction" /> 
                            </html:select>
                        </td> 
                    </tr>



                    <tr>
                        <td class="bord">  <bean:message key="habitat.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="habitat_trouve">    

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
                        <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                            <html:link action="gestionhabitat" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>

            </html:form>

        </logic:present> 
    </body>
</html>
