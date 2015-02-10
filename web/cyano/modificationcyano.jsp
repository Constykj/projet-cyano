<%-- 
    Document   : modificationcyano
    Created on : Apr 17, 2014, 12:51:07 PM
    Author     : Abouchou
--%>

<%-- 
    Document   : modificationUtilisateur
    Created on : Mar 2, 2014, 5:23:57 PM
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
        <logic:present name="cyano_trouve" >
            <html:form action="enregistreModifCyano.do" method="post">



                <table>
                    <html:hidden  property="idcyano"  name="cyano_trouve"  /> 
                     

                    <tr>
                        <td class="bord">  <bean:message key="cyano.type_gene_cyano"/> </td>
                        <td class="bord">  <html:text property="type_gene_cyano" size="25" name="cyano_trouve" /> </td>

                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_gene_cyano"/> </td>
                        <td class="bord">  <html:text property="conc_gene_cyano" size="25" name="cyano_trouve" /></td>

                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="cyano.gene_toxicite"/>  </td>
                        <td class="bord">  <html:text property="gene_toxicite" size="25"  name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.gene_cyano"/>  </td>
                        <td class="bord">  <html:text property="gene_cyano" size="25"  name="cyano_trouve" /></td>

                    </tr>

                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_gene_toxicite"/>  </td>
                        <td class="bord">  <html:text property="conc_gene_toxicite" size="25" name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.type_gene_toxicite"/>  </td>
                        <td class="bord">  <html:text property="type_gene_toxicite" size="25" name="cyano_trouve" /></td>

                    </tr>
                    
                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_microcystine"/>  </td>
                        <td class="bord">  <html:text property="conc_microcystine" size="25" name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.type_microcystine"/>  </td>
                        <td class="bord">  <html:text property="type_microcystine" size="25" name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_anatoxine"/>  </td>
                        <td class="bord">  <html:text property="conc_anatoxine" size="25" name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_saxitoxine"  />   </td>
                        <td class="bord">  <html:text property="conc_saxitoxine" size="25"  name="cyano_trouve" /></td>

                    </tr>
                    <tr>
                        <td class="bord">  <bean:message key="cyano.conc_cylindrospermopsine"/>  </td>
                        <td class="bord">  <html:text property="conc_cylindrospermopsine" size="25" name="cyano_trouve"  /></td>

                    </tr>
                    <td class="bord">  <bean:message key="cyano.validite"/>  </td>
                    <td class="bord">
                        <html:select property="visible"  name="cyano_trouve" >                              
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

    </logic:present>
</body>
</html>
