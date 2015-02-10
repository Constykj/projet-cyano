<%-- 
    Document   : gestioncyano
    Created on : Apr 17, 2014, 12:50:48 PM
    Author     : Abouchou
--%>

<%-- 
    Document   : administration
    Created on : Feb 24, 2014, 11:20:04 PM
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
        <script type="text/javascript">

            function output() {
                var total = 0;
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox') {
                        if (cases[i].checked === true)
                            total++;
                    }
                if (total == 0) {
                    window.document.gestionCyanoModifForm.modifCyano.disabled = true;
                    window.document.gestionCyanoModifForm.suprimCyano.disabled = true;

                } else if (total == 1) {
                    window.document.gestionCyanoModifForm.modifCyano.disabled = false;
                    window.document.gestionCyanoModifForm.suprimCyano.disabled = false;
                } else {
                    window.document.gestionCyanoModifForm.modifCyano.disabled = true;
                    window.document.gestionCyanoModifForm.suprimCyano.disabled = true;
                }
            }

          

            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionCyanoModifForm.modifCyano.disabled = true;
                window.document.gestionCyanoModifForm.suprimCyano.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Cyanobaceries</h1>

        <html:form action="modifiCyano.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifCyano"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creercyanopage" styleClass="lienBtn" title="creer Cyanobacterie"> Creer un nouvel Cyanobacterie </html:link></td> 
                    </p>

                    <p>
                        
                    </p>

                    <thead class="boldtr">
                        <td  class="bord">  </td>&nbsp;
                         
                        <td> Type gène cyanobactérie </td> 
                        <td> Concentration gène cyanobactérie </td>
                        <td> gène toxicité </td>
                        <td> Concentration gène toxicité </td> 
                        <td> Type gène toxicité </td>
                        <td> Concentration microcystine </td>
                        <td> Type microcystine </td>
                        <td> Concentration anatoxine </td> 
                        <td> Concentration saxitoxine </td>
                        <td> Concentration cylindrospermopsine </td>
                        <td> Visible</td>
                    </thead >

                    <logic:iterate name="liste_cyano"  id="cyano" indexId="cy">
                        <tr class="av"> 
                            <td> 
                                <html:multibox  property="idcyano" name="cyano" onclick="output()" >
                                    <bean:write name="cyano" property="idcyano"   /> 
                                </html:multibox> 
                            </td>
                            <td>  <bean:write name="cyano" property="type_gene_cyano" /> </td> 
                            <td>  <bean:write name="cyano" property="conc_gene_cyano" /> </td> 
                            <td>  <bean:write name="cyano" property="gene_toxicite" /> </td>
                            <td>  <bean:write name="cyano" property="conc_gene_toxicite" /> </td> 
                            <td>  <bean:write name="cyano" property="type_gene_toxicite" /> </td> 
                            <td>  <bean:write name="cyano" property="conc_microcystine" /> </td> 
                            <td>  <bean:write name="cyano" property="type_microcystine" /> </td>
                            <td>  <bean:write name="cyano" property="conc_anatoxine" /> </td> 
                            <td>  <bean:write name="cyano" property="conc_saxitoxine" /> </td>
                            <td>  <bean:write name="cyano" property="conc_cylindrospermopsine" /> </td> 
                            <td>  <bean:write name="cyano" property="visible" /> </td>
                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
        
    </body>
</html>
