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
                    window.document.gestionPratiqueModifForm.modifEcl.disabled = true;
                    window.document.gestionPratiqueModifForm.suprimEcl.disabled = true;

                } else if (total == 1) {
                    window.document.gestionPratiqueModifForm.modifEcl.disabled = false;
                    window.document.gestionPratiqueModifForm.suprimEcl.disabled = false;
                } else {
                  window.document.gestionPratiqueModifForm.modifEcl.disabled = true;
                    window.document.gestionPratiqueModifForm.suprimEcl.disabled = true;
                }
            }

          

            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
               window.document.gestionPratiqueModifForm.modifEcl.disabled = true;
                window.document.gestionPratiqueModifForm.suprimEcl.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Pratiques</h1>

        <html:form action="gestionPratique.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifEcl"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerprapage" styleClass="lienBtn" titleKey="creer.pratique"> Creer un nouvelle pratique </html:link></td> 
                    </p>

                    <p>
                        
                    </p>

                    <thead  class="mheader1">
                        <td  class="tit"> 
                        <td class="tit"> désignation </td> 
                        <td class="tit"> visible </td>  
                        
                    </thead >

                    <logic:iterate name="liste_pra"  id="ecl" indexId="eclai">
                        <tr class="av"> 
                            <td class="mtd1" > 
                                <html:multibox  property="idpratique" name="ecl" onclick="output()" >
                                    <bean:write name="ecl" property="idpratique"   /> 
                                </html:multibox> 
                            </td>
                              
                            <td class="mtd1">  <bean:write name="ecl" property="pratique" /> </td> 
                            <td class="mtd1">  <bean:write name="ecl" property="visible" /> </td> 
                            
                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
