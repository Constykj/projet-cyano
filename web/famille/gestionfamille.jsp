<%-- 
    Document   : gestionautre_bacterie
    Created on : Apr 7, 2014, 9:21:40 PM
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
                    window.document.gestionFamilleModifForm.modifFam.disabled = true;
                    window.document.gestionFamilleModifForm.suprimFam = true;

                } else if (total == 1) {
                    window.document.gestionFamilleModifForm.modifFam.disabled = false;
                    window.document.gestionFamilleModifForm.suprimFam = false;
                } else {
                    window.document.gestionFamilleModifForm.modifFam.disabled = true;
                    window.document.gestionFamilleModifForm.suprimFam = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionFamilleModifForm.modifFam.disabled = true;
                window.document.gestionFamilleModifForm.suprimFam = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Familles</h1>

        <html:form action="gestionFamille.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifFam"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerfampage" styleClass="lienBtn" titleKey="creer.famialgu">Creer un nouvel famille </html:link></td> 
                        </p>

                        <thead class="mheader1">
                        <td  class="tit"></td>
                            <td class="tit"> désignation </td> 
                            <td class="tit"> visible </td>  

                        </thead>

                    <logic:iterate name="liste_fam"  id="fam" indexId="fami">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idfamille" name="fam" onclick="output()" >
                                    <bean:write name="fam" property="idfamille"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="fam" property="design_famille" /> </td> 
                            <td class="mtd1">  <bean:write name="fam" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
