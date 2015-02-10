 

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
                    window.document.GestionModifTypeGeneToxiciteForm.modifCyano.disabled = true;

                    window.document.GestionModifTypeGeneToxiciteForm.suprimCyano.disabled = true;

                } else if (total == 1) {
                    window.document.GestionModifTypeGeneToxiciteForm.modifCyano.disabled = false;
                    window.document.GestionModifTypeGeneToxiciteForm.suprimCyano.disabled = false;
                } else {
                    window.document.GestionModifTypeGeneToxiciteForm.modifCyano.disabled = true;
                    window.document.GestionModifTypeGeneToxiciteForm.suprimCyano.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.GestionModifTypeGeneToxiciteForm.modifCyano.disabled = true;
                window.document.GestionModifTypeGeneToxiciteForm.suprimCyano.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion Type des Genes Toxicite</h1>

        <html:form action="pageModifTypeGeneToxicite.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifCyano"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creationPageTypeGeneToxicite" styleClass="lienBtn" titleKey="creer.typgentoxicite"> Creer un nouvel type gene toxicite </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead  class="mheader1">
                            
                        <td  class="tit"> </td>
                        <td class="tit"> désignation </td>
                        <td class="tit"> visible </td> 

                        </thead >



                    <logic:iterate name="liste_type_toxicite"  id="tygene" indexId="ga">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idtyp_gene_toxicite" name="tygene" onclick="output()" >
                                    <bean:write name="tygene" property="idtyp_gene_toxicite"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="tygene" property="design_typ_gene_toxicite" /> </td> 

                            <td class="mtd1">  <bean:write name="tygene" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

