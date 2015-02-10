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
                    window.document.gestionEspeceCyanoModifForm.modifCyano.disabled = true;

                    window.document.gestionEspeceCyanoModifForm.suprimCyano.disabled  = true;

                } else if (total == 1) {
                   window.document.gestionEspeceCyanoModifForm.modifCyano.disabled = false;
                    window.document.gestionEspeceCyanoModifForm.suprimCyano.disabled  = false;
                } else {
                   window.document.gestionEspeceCyanoModifForm.modifCyano.disabled = true;
                    window.document.gestionEspeceCyanoModifForm.suprimCyano.disabled  = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
               window.document.gestionEspeceCyanoModifForm.modifCyano.disabled = true;
                window.document.gestionEspeceCyanoModifForm.suprimCyano.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Especes Cyanobactérie</h1>

        <html:form action="gestionModifEsepce_cyano.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifCyano"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerespece_cyanopage" styleClass="lienBtn" titleKey="creer.espece_cyano"> Creer un nouvel espèce cyanobactérie </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead  class="mheader1">
                        <td  class="tit"> </td>
                            <td class="tit"> désignation </td> &nbsp;
                            <td class="tit"> genre cyanobactérie </td> &nbsp;
                            <td class="tit"> visible </td>  

                        </thead >

                    <logic:iterate name="liste_espece_cyano"  id="genre" indexId="ga">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idespece_cyano" name="genre" onclick="output()" >
                                    <bean:write name="genre" property="idespece_cyano"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="genre" property="design_espece_cyano" /> </td> 
                            <td class="mtd1">  <bean:write name="genre" property="genre_cyano" /> </td> 
                            <td class="mtd1">  <bean:write name="genre" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

