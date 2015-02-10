<%-- 
    Document   : gestionstationprelevement
    Created on : Apr 30, 2014, 10:58:41 PM
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
                    window.document.gestionStatprModifForm.modifStat.disabled = true;
                    window.document.gestionStatprModifForm.suprimStat.disabled = true;

                } else if (total == 1) {
                    window.document.gestionStatprModifForm.modifStat.disabled = false;
                    window.document.gestionStatprModifForm.suprimStat.disabled = false;
                } else {
                    window.document.gestionStatprModifForm.modifStat.disabled = true;
                    window.document.gestionStatprModifForm.suprimStat.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionStatprModifForm.modifStat.disabled = true;
                window.document.gestionStatprModifForm.suprimStat.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Stations de prelevement</h1>

        <html:form action="gestionmodifstatpr.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifStat"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerpagestatpr.do" styleClass="lienBtn" title="creer une station de prelevement"> Creer une nouvelle station de prelevement </html:link>
                        </p>

                        <p>

                        </p>

                        <tr class="boldtr">
                            <td  class="bord">   
                            <td  class="bord">  Identifiant station </td> &nbsp;  
                            <td  class="bord">  Localisation latitude</td> &nbsp; 
                            <td  class="bord">  Localisation longitude </td> &nbsp; 
                            <td  class="bord">  Plan d'eau </td> &nbsp; 
                            <td  class="bord">   Visible </td> &nbsp; 
                        </tr>   

                    <logic:iterate name="liste_statpr"  id="StatPr" indexId="cm">
                        <tr> 
                            <td> 
                                <html:multibox  property="idstat" name="StatPr" onclick="output()" >
                                    <bean:write name="StatPr" property="idstat"   /> 
                                </html:multibox> 
                            </td>
                            <td>  <bean:write name="StatPr" property="idstat_prelevement" /> </td> 
                            <td>  <bean:write name="StatPr" property="gps_lat" /> </td> 
                            <td>  <bean:write name="StatPr" property="gps_long" /> </td> 
                            <td>  <bean:write name="StatPr" property="idplan_eau" /> </td> 
                            <td>  <bean:write name="StatPr" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

