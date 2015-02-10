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

        <h1>Creation Echantillon </h1>

        <html:form action="creerechan.do" method="post" >

            <table>
                
                <tr> 
                    <td class="bord">  <bean:message key="echantillon.numero"  />   </td>
                    <td class="bord">  <html:text property="num_echantillon" size="25"   />   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="echantillon.date"/> </td>
                    <td class="bord">  <html:text property="date_prelevement" size="25"   />   </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="echantillon.virus"/> </td>
                    <td class="bord"> 

                        <html:select property="idvirus"   >    
                            <html:options collection="vir_trouve" property="idvirus" labelProperty="enterovirus" /> 
                        </html:select>
                    </td>
                </tr>
                 
                <tr> 
                    <td class="bord">  <bean:message key="echantillon.cyano"/> </td>
                    <td class="bord"> 
                        <html:select property="idcyano"    >    
                            <html:options collection="cyano_trouve" property="idcyano" labelProperty="gene_cyano" /> 
                        </html:select>
                    </td> 
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="echantillon.autrealgue"/> </td>
                    <td class="bord">  
                        <html:select property="idautre_algue"   >    
                            <html:options collection="alg_trouve" property="idautre_algue" labelProperty="design_algue" /> 
                        </html:select>   </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="echantillon.autrebacterie"/> </td>
                    <td class="bord">  
                        <html:select property="idautre_bacterie"   >    
                            <html:options collection="bact_trouve" property="idautre_bacterie" labelProperty="coliforme_tx" /> 
                        </html:select>   </td>
                </tr>
                 
                <tr>
                    <td class="bord">  <bean:message key="echantillon.visible"/>  </td>
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
                        <html:link action="gestionechan" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>

                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

