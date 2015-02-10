<%-- 
    Document   : modificationAutre_algue
    Created on : Apr 7, 2014, 9:22:41 PM
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
        <h1>Modification serotype salmonelle</h1>
        <logic:present name="seroSal" >
            <html:form action="enregistreModifSerotypeSal.do" method="post">
             
                <table>
                    <html:hidden  property="idserotype_sal"  name="seroSal"  /> 
                    <tr> 
                        <td class="bord">  <bean:message key="serotype_sal.designation"/> </td>
                        <td class="bord">  <html:text property="design_serotype" size="25" name="seroSal"  />   </td>
                    </tr>
                
                     <tr>
                        <td class="bord">  <bean:message key="serotype_sal.visible"/>  </td>
                        <td class="bord">
                            <html:select property="visible" name="seroSal">    
                                
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
                            <html:link action="pageGestionSerotypeSal" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>

                    </table>

            </html:form>

        </logic:present>
    </body>
</html>
