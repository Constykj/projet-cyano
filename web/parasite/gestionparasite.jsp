<%-- 
    Document   : gestionpratique
    Created on : Mar 30, 2014, 12:48:55 AM
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
                    window.document.gestionParasiteModifForm.modifPra.disabled = true;
                    window.document.gestionPratiqueModifForm.suprimPra.disabled = true;

                } else if (total == 1) {
                    window.document.gestionParasiteModifForm.modifPra.disabled = false;
                    window.document.gestionParasiteModifForm.suprimPra.disabled = false;
                } else {
                    window.document.gestionParasiteModifForm.modifPra.disabled = true;
                    window.document.gestionParasiteModifForm.suprimPra.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionParasiteModifForm.modifPra.disabled = true;
                window.document.gestionParasiteModifForm.suprimPra.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Pratiques</h1>

        <html:form action="gestionModifParasite.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifPra"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerParasitePage" styleClass="lienBtn" title="creer.parasite"> Creer un nouvel parasite </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <tr class="boldtr">
                            <td  class="bord">  
                            <td> Cryptosporidium </td> &nbsp;
                             <td> Giardia </td> &nbsp;
                             <td> helminthe </td> &nbsp;
                            <td> visible </td>   &nbsp;

                        </tr>

                    <logic:iterate name="liste_para"  id="pra" indexId="pa">
                        <tr> 
                            <td> 
                                <html:multibox  property="idparasite" name="pra" onclick="output()" >
                                    <bean:write name="pra" property="idparasite"   /> 
                                </html:multibox> 
                            </td>

                            <td>  <bean:write name="pra" property="cryptosporidium" /> </td> 
                             <td>  <bean:write name="pra" property="giardia" /> </td> 
                            <td>  <bean:write name="pra" property="helminthe" /> </td> 
                            <td>  <bean:write name="pra" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
