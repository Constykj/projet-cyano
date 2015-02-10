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

        <h1>Creation Plan d'eau  </h1>

        <html:form action="creerplan_eau.do" method="post" >

            <table>
                
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.designation"/> </td>
                    <td class="bord">  <html:text property="designation" size="25"  />   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.superficie"/> </td>
                    <td class="bord">  <html:text property="superficie" size="25"   />   </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.region"/> </td>
                    <td class="bord"> 

                        <html:select property="idregion"   >    
                            <html:options collection="reg_trouve" property="idregion" labelProperty="designation" /> 
                        </html:select>
                    </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.matfecal"/> </td>
                    <td class="bord"> 
                        <html:select property="visible"  >    

                            <html:option value="1">Vrai</html:option> 
                            <html:option  value="0">Faux</html:option>

                        </html:select> </td>

                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.quartier"/> </td>
                    <td class="bord"> 
                        <html:select property="idquartier"    >    
                            <html:options collection="quart_trouve" property="idquartier" labelProperty="designation" /> 
                        </html:select>
                    </td> 
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.commune"/> </td>
                    <td class="bord">  
                        <html:select property="idcommune"   >    
                            <html:options collection="com_trouve" property="idcommune" labelProperty="designation" /> 
                        </html:select>   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.type_plan_eau"/> </td>
                    <td class="bord">  
                        <html:select property="idtype_plan_eau"   >    
                            <html:options collection="typl_trouve" property="idtype_plan_eau" labelProperty="designation" /> 
                        </html:select>   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.commentaire"/> </td>
                    <td class="bord">  <html:text property="commentaire" size="25"  />   </td>
                </tr>
                
                <tr> 
                    <td class="bord">  <bean:message key="plan_eau.pratique"/> </td>
                    <td class="bord"> 

                        <html:select   property="idpratiquer"  multiple="true">    
                            <html:options  collection="pratique_trouve" property="idpratique" labelProperty="pratique" /> 
                        </html:select>
                    </td> 
                </tr>
                
                <tr>
                    <td class="bord">  <bean:message key="plan_eau.visible"/>  </td>
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
                    <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                        <html:link action="gestionplaneau" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>

                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

