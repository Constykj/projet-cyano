 

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
                    window.document.GestionModifGeneForm.modifCyano.disabled = true;

                    window.document.GestionModifGeneForm.suprimCyano.disabled = true;

                } else if (total == 1) {
                    window.document.GestionModifGeneForm.modifCyano.disabled = false;
                    window.document.GestionModifGeneForm.suprimCyano.disabled = false;
                } else {
                    window.document.GestionModifGeneForm.modifCyano.disabled = true;
                    window.document.GestionModifGeneForm.suprimCyano.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.GestionModifGeneForm.modifCyano.disabled = true;
                window.document.GestionModifGeneForm.suprimCyano.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Genes Cyano</h1>

        <html:form action="pageModifGeneCyano.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifCyano"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creationPageGeneCyano" styleClass="lienBtn" titleKey="creer.gene_cyano"> Creer un nouvel gene cyano </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead class="mheader1">
                        <td  class="tit"> </td>
                        <td class="tit"> désignation </td>  
                        <td class="tit"> visible </td>  

                        </thead>

                    <logic:iterate name="liste_gene"  id="gene" indexId="ga">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idgene_cyano" name="gene" onclick="output()" >
                                    <bean:write name="gene" property="idgene_cyano"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="gene" property="design_gene_cyano" /> </td> 
                            <td class="mtd1">  <bean:write name="gene" property="visib" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

