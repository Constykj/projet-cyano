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
        <h1>Modification Plan d'eau</h1>
        <logic:present name="planeau_trouve" >
            <html:form action="enregistreModifPlanEau.do" method="post"> 

            <table>
                <html:hidden  property="idplan_eau"  name="planeau_trouve"  /> 
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.designation"/> </td>
                    <td class="bord">  <html:text property="designation" size="25" name="planeau_trouve"  />   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.superficie"/> </td>
                    <td class="bord">  <html:text property="superficie" size="25" name="planeau_trouve"  />   </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.region"/> </td>
                    <td class="bord"> 

                        <html:select property="idregion" name="planeau_trouve"  >    
                            <html:options collection="region_trouve" property="idregion" labelProperty="designation" /> 
                        </html:select>
                    </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.matfecal"/> </td>
                    <td class="bord"> 
                        <html:select property="visible" name="planeau_trouve">    

                            <html:option value="1">Vrai</html:option> 
                            <html:option  value="0">Faux</html:option>

                        </html:select> </td>

                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.quartier"/> </td>
                    <td class="bord"> 
                        <html:select property="idquartier" name="planeau_trouve"  >    
                            <html:options collection="quartier_trouve" property="idquartier" labelProperty="designation" /> 
                        </html:select>
                    </td> 
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.commune"/> </td>
                    <td class="bord">  
                        <html:select property="idcommune" name="planeau_trouve"  >    
                            <html:options collection="commune_trouve" property="idcommune" labelProperty="designation" /> 
                        </html:select>   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.type_plan_eau"/> </td>
                    <td class="bord">  
                        <html:select property="idtype_plan_eau" name="planeau_trouve"  >    
                            <html:options collection="type_plan_eau_trouve" property="idtype_plan_eau" labelProperty="designation" /> 
                        </html:select>   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.commentaire"/> </td>
                    <td class="bord">  <html:text property="commentaire" size="25" name="planeau_trouve"  />   </td>
                </tr>
                
                <tr> 
                        <td class="bord">  <bean:message key="plan_eau.pratique"/> </td>
                        <td class="bord"> 

                            <html:select   property="idpratique"  name="planeau_trouve"    multiple="true">    
                                <html:options  collection="pratique_trouve" property="idpratique" labelProperty="pratique" /> 
                            </html:select>
                        </td> 
                    </tr>
                
                <tr>
                    <td class="bord">  <bean:message key="plan_eau.visible"/>  </td>
                    <td class="bord">
                        <html:select property="visible" name="planeau_trouve">    

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
                        <html:link action="gestionplaneau" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>

                </table>

          </html:form>

        </logic:present> 
    </body>
</html>
