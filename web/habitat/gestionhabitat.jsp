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
                    window.document.gestionModifHabitatForm.modifPln.disabled = true;
                    window.document.gestionModifHabitatForm.suprimPln.disabled = true;

                } else if (total == 1) {
                    window.document.gestionModifHabitatForm.modifPln.disabled = false;
                    window.document.gestionPlanEauModifForm.suprimPln.disabled = false;
                } else {
                    window.document.gestionModifHabitatForm.modifPln.disabled = true;
                    window.document.gestionModifHabitatForm.suprimPln.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionModifHabitatForm.modifPln.disabled = true;
                window.document.gestionModifHabitatForm.suprimPln.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Habitats</h1>

        <html:form action="gestionModifHabitat.do"  method="post" >
            <div>
                <table  class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifPln"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerhabitatpage.do" styleClass="lienBtn" titleKey="creer.habitat"> Creer un nouvel habitat </html:link>
                        </p>

                        <p>

                        </p>

                        <thead  class="mheader1">
                                
                            <td  class="tit"> </td>  
                            <td  class="tit">  Distance </td>   
                            <td  class="tit">  Désignation </td>   
                            <td  class="tit">  effectif </td>  
                            <td  class="tit">  Plan d'eau </td>  
                            <td  class="tit">  Matériaux de construction</td>   
                            <td  class="tit">   Visible </td>  




                        </thead >

                    <logic:iterate name="liste_habitat"  id="plA" indexId="cm">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idhabitat" name="plA" onclick="output()" >
                                    <bean:write name="plA" property="idhabitat"   /> 
                                </html:multibox> 
                            </td>


                            <td  class="mtd1">  <bean:write name="plA" property="dist_bord_lagune" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="design_habitat" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="effectif" /> </td> 
                            <td class="mtd1">  <bean:write name="plA" property="plan_eau" /> </td>
                            <td class="mtd1">  <bean:write name="plA" property="mat_const" /></td>  
                            <td class="mtd1">  <bean:write name="plA" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>




                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

