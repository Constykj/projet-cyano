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
                    window.document.gestionPlanEauModifForm.modifPln.disabled = true;
                    window.document.gestionPlanEauModifForm.suprimPln.disabled = true;

                } else if (total == 1) {
                    window.document.gestionPlanEauModifForm.modifPln.disabled = false;
                    window.document.gestionPlanEauModifForm.suprimPln.disabled = false;
                } else {
                    window.document.gestionPlanEauModifForm.modifPln.disabled = true;
                    window.document.gestionPlanEauModifForm.suprimPln.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionPlanEauModifForm.modifPln.disabled = true;
                window.document.gestionPlanEauModifForm.suprimPln.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Plan d'eau</h1>

        <html:form action="gestionPlanEau.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifPln"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerplan_eaupage.do" styleClass="lienBtn" titleKey="creer.plan_eau"> Creer un nouvel plan d'eau </html:link>
                        </p>

                        <p>

                        </p>

                        <thead class="mheader1">
                        <td  class="tit">   
                        <td  class="tit">  Désignation </td> &nbsp;  
                        <td  class="tit">  Superficie </td> &nbsp; 
                        <td  class="tit">  Region </td> &nbsp; 
                        <td  class="tit">   Commune </td> &nbsp; 
                        <td  class="tit">  Quartier</td> &nbsp; 
                        <td  class="tit">  Type plan eau </td> &nbsp;
                        <td  class="tit">  Matiere Fecale </td> &nbsp;
                        <td  class="tit">   Commentaire </td> &nbsp;
                        <td  class="tit">   Pratique </td> &nbsp;
                        <td  class="tit">   Visible </td> &nbsp; 


                        </thead>

                    <logic:iterate name="liste_plan_eau"  id="plA" indexId="cm">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idplan_eau" name="plA" onclick="output()" >
                                    <bean:write name="plA" property="idplan_eau"   /> 
                                </html:multibox> 
                            </td>

                            <td class="mtd1">  <bean:write name="plA" property="designation" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="superficie" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="region" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="commune" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="quartier" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="type_plan_eau" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="matiere_fecale" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="commentaire" /> </td>
                            <td class="mtd1">  <bean:write name="plA" property="pratiquer" /></td> 
                            <td class="mtd1">  <bean:write name="plA" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>
        
        <%@include file="/piedpage.jsp" %>

    </body>
</html>

