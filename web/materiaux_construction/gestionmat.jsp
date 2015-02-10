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
                    window.document.gestionMateriauxModifForm.modifMat.disabled = true;
                    window.document.gestionMateriauxModifForm.suprimMat = true;

                } else if (total == 1) {
                    window.document.gestionMateriauxModifForm.modifMat.disabled = false;
                    window.document.gestionMateriauxModifForm.suprimMat = false;
                } else {
                    window.document.gestionMateriauxModifForm.modifMat.disabled = true;
                    window.document.gestionMateriauxModifForm.suprimMat = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionMateriauxModifForm.modifMat.disabled = true;
                window.document.gestionMateriauxModifForm.suprimMat = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Materiaux de construction</h1>

        <html:form action="modifiMat.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifMat"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="pagecreerMat" styleClass="lienBtn" titleKey="creer.materiaux">Creer un nouvel materiaux de construction </html:link></td> 
                        </p>

                        <thead  class="mheader1">
                        <td  class="tit"></td>
                        <td class="tit"> Libellé </td> 
                        <td class="tit"> visible </td>  

                        </thead >

                    <logic:iterate name="liste_mat"  id="mat" indexId="qt">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idmateriaux_construction" name="mat" onclick="output()" >
                                    <bean:write name="mat" property="idmateriaux_construction"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="mat" property="lib_materiaux_construction" /> </td> 
                            <td class="mtd1">  <bean:write name="mat" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
