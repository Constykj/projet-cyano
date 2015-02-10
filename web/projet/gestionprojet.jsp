<%-- 
    Document   : gestionprojet
    Created on : Mar 28, 2014, 1:50:33 AM
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
                    window.document.gestionProjetModifForm.modifProj.disabled = true;
                    window.document.gestionProjetModifForm.suprimProj = true;

                } else if (total == 1) {
                    window.document.gestionProjetModifForm.modifProj.disabled = false;
                    window.document.gestionProjetModifForm.suprimProj = false;
                } else {
                    window.document.gestionProjetModifForm.modifProj.disabled = true;
                    window.document.gestionProjetModifForm.suprimProj.disabled = true;
                }
            }
            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionProjetModifForm.modifProj.disabled = true;
                window.document.gestionProjetModifForm.suprimProj = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Projets</h1>

        <html:form action="gestionProjet.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifProj"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerprojetpage" styleClass="lienBtn" titleKey="creer.projet">Creer un nouvel projet </html:link></td> 
                        </p>

                        <thead  class="mheader1">
                        <td  class="tit"> </td>
                            <td class="tit"> Désignation </td> &nbsp;
                            <td class="tit"> Source de financement </td> &nbsp;
                            <td class="tit"> Collaborateur </td> &nbsp;
                            <td class="tit"> Debut </td> &nbsp;
                            <td class="tit"> Fin </td> &nbsp;
                            <td class="tit"> Caractéristique </td> &nbsp;
                            <td class="tit"> visible </td>  

                        </thead >

                    <logic:iterate name="liste_proj"  id="proj" indexId="pr">
                        <tr class="av"> 
                            <td  class="mtd1"> 
                                <html:multibox  property="idprojet" name="proj" onclick="output()" >
                                    <bean:write name="proj" property="idprojet"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="proj" property="design_projet" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="source_financement" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="collabor_projet" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="debut_projet" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="fin_projet" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="caract_projet" /> </td> 
                            <td class="mtd1">  <bean:write name="proj" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
