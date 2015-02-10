 

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
                    window.document.GestionModifTypeGeneCyanoForm.modifCyano.disabled = true;

                    window.document.GestionModifTypeGeneCyanoForm.suprimCyano.disabled = true;

                } else if (total == 1) {
                    window.document.GestionModifTypeGeneCyanoForm.modifCyano.disabled = false;
                    window.document.GestionModifTypeGeneCyanoForm.suprimCyano.disabled = false;
                } else {
                    window.document.GestionModifTypeGeneCyanoForm.modifCyano.disabled = true;
                    window.document.GestionModifTypeGeneCyanoForm.suprimCyano.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.GestionModifTypeGeneCyanoForm.modifCyano.disabled = true;
                window.document.GestionModifTypeGeneCyanoForm.suprimCyano.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion Type des Genes Cyano</h1>

        <html:form action="pageModifTypeGeneCyano.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifCyano"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creationPageTypeGeneCyano" styleClass="lienBtn" titleKey="creer.typ_gene_cyan"> Creer un nouvel type gêne cyanobactérie </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead  class="boldtr">
                            <td  class="bord">  <td> désignation </td> &nbsp; 
                          
                            <td> visible </td> 

                        </thead >



                    <logic:iterate name="liste_type_gene"  id="tygene" indexId="ga">
                        <tr class="av"> 
                            <td> 
                                <html:multibox  property="idtyp_gene_cyano" name="tygene" onclick="output()" >
                                    <bean:write name="tygene" property="idtyp_gene_cyano"   /> 
                                </html:multibox> 
                            </td>

                            <td>  <bean:write name="tygene" property="design_typ_gene_cyano" /> </td> 
                         
                            <td>  <bean:write name="tygene" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

