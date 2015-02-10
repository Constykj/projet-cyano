<%-- 
    Document   : gestionregion
    Created on : Mar 27, 2014, 10:45:29 AM
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
                    window.document.gestionRegionModifForm.modifReg.disabled = true;
                    window.document.gestionRegionModifForm.suprimReg = true;

                } else if (total == 1) {
                    window.document.gestionRegionModifForm.modifReg.disabled = false;
                    window.document.gestionRegionModifForm.suprimReg = false;
                } else {
                    window.document.gestionRegionModifForm.modifReg.disabled = true;
                   window.document.gestionRegionModifForm.suprimReg = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionRegionModifForm.modifReg.disabled = true;
                window.document.gestionRegionModifForm.suprimReg = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Regions</h1>

        <html:form action="gestionRegion.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifReg"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerregpage" styleClass="lienBtn" titleKey="creer.region">Creer une nouvelle Region </html:link></td> 
                        </p>

                        <thead  class="mheader1">
                            <td  class="tit"> </td>
                            <td  class="tit"> désignation </td>
                            <td  class="tit"> visible </td>  

                        </thead >

                    <logic:iterate name="liste_reg"  id="reg" indexId="rg">
                        <tr class="av"> 
                            <td   class="mtd1"> 
                                <html:multibox  property="idregion" name="reg" onclick="output()" >
                                    <bean:write name="reg" property="idregion"   /> 
                                </html:multibox> 
                            </td>

                            <td  class="mtd1">  <bean:write name="reg" property="designation" /> </td> 
                            <td  class="mtd1">  <bean:write name="reg" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

