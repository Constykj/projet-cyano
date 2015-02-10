<%-- 
    Document   : gestionquartier
    Created on : Mar 11, 2014, 9:58:21 PM
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
                    window.document.gestionQuartierModifForm.modifQuart.disabled = true;
                    window.document.gestionQuartierModifForm.suprimQuart = true;

                } else if (total == 1) {
                    window.document.gestionQuartierModifForm.modifQuart.disabled = false;
                    window.document.gestionQuartierModifForm.suprimQuart = false;
                } else {
                    window.document.gestionQuartierModifForm.modifQuart.disabled = true;
                    window.document.gestionQuartierModifForm.suprimQuart.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionQuartierModifForm.modifQuart.disabled = true;
                window.document.gestionQuartierModifForm.suprimQuart = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Quartiers</h1>

        <html:form action="gestionQuartier.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifQuart"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerquartpage" styleClass="lienBtn" titleKey="crrer.quartier">Creer un nouvel quartier </html:link></td> 
                        </p>

                        <thead  class="mheader">
                            <td  class="tit"> </td> 
                            <td class="tit"> désignation </td> 
                            <td class="tit"> visible </td>  

                        </thead>

                    <logic:iterate name="liste_quart"  id="quart" indexId="qt">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idquartier" name="quart" onclick="output()" >
                                    <bean:write name="quart" property="idquartier"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="quart" property="designation" /> </td> 
                            <td class="mtd1">  <bean:write name="quart" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
