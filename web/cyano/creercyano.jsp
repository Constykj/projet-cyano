<%-- 
    Document   : creercyano
    Created on : Apr 17, 2014, 12:50:29 PM
    Author     : Abouchou
--%>

<%-- 
    Document   : creerutilisateur
    Created on : Feb 28, 2014, 12:50:12 AM
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

        <h1>Cyanobacterie </h1>

        <html:form action="creercyano.do" method="post" >

            <table>

                <tr>
                    <td class="bord">  <bean:message key="cyano.type_gene_cyano"/> </td>
                    <td class="bord">  <html:text property="type_gene_cyano" size="25"  /> </td>
                    <td class="bord"> <font class="error">   <html:errors property="typegenrecyano" /></font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_gene_cyano"/> </td>
                    <td class="bord">  <html:text property="conc_gene_cyano" size="25" /></td>
                    <td class="bord"> <font class="error">  <font class="error">   <html:errors property="concgenecyano" /> </font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="cyano.gene_toxicite"/>  </td>
                    <td class="bord">  <html:text property="gene_toxicite" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="genetoxicite" /> </font>  </td>
                </tr>
                 <tr>
                    <td class="bord">  <bean:message key="cyano.gene_cyano"/>  </td>
                    <td class="bord">  <html:text property="gene_cyano" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="genecyano" /> </font>  </td>
                </tr>

                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_gene_toxicite"/>  </td>
                    <td class="bord">  <html:text property="conc_gene_toxicite" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="concgenetoxicite" /> </font> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="cyano.type_gene_toxicite"/>  </td>
                    <td class="bord">  <html:text property="type_gene_toxicite" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="typegenetoxicite" /> </font> </td>
                </tr>
                 
                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_microcystine"/>  </td>
                    <td class="bord">  <html:text property="conc_microcystine" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="concmicrocystine" /> </font> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="cyano.type_microcystine"/>  </td>
                    <td class="bord">  <html:text property="type_microcystine" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="typemicrocystine" /> </font> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_anatoxine"/>  </td>
                    <td class="bord">  <html:text property="conc_anatoxine" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="concanatoxine" /> </font> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_saxitoxine"/>  </td>
                    <td class="bord">  <html:text property="conc_saxitoxine" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="concsaxitoxine" /> </font> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="cyano.conc_cylindrospermopsine"/>  </td>
                    <td class="bord">  <html:text property="conc_cylindrospermopsine" size="25" /></td>
                    <td class="bord"> <font class="error">   <html:errors property="conccylindrospermopsine" /> </font> </td>
                </tr>
                <td class="bord">  <bean:message key="cyano.validite"/>  </td>
                <td class="bord">
                    <html:select property="visible"  >                              
                        <html:option value="1">Valide</html:option> 
                        <html:option  value="0">Non valide</html:option>
                    </html:select>
                </td>
                <td class="bord">  </td>
            </tr>
            <tr>
                <td class="bord">  &nbsp;  </td>
                <td class="bord">  &nbsp;  </td>
            </tr>
            <tr>
                <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                    <html:link action="gestioncyano" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                </tr>
            </table>
    </html:form>

    <%@include file="/piedpage.jsp" %>
</body>
</html>

