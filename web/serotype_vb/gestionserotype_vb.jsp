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
                    window.document.GestionModifSerotypeVb.modifEspece.disabled = true;
                    window.document.GestionModifSerotypeVb.suprimEspece.disabled= true;

                } else if (total == 1) {
                   window.document.GestionModifSerotypeVb.modifEspece.disabled= false;
                    window.document.GestionModifSerotypeVb.suprimEspece.disabled  = false;
                } else {
                   window.document.GestionModifSerotypeVb.modifEspece.disabled= true;
                     window.document.GestionModifSerotypeVb.suprimEspece.disabled  = true;
                }
            }

          

            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
               window.document.GestionModifSerotypeVb.modifEspece.disabled = true;
                window.document.GestionModifSerotypeVb.suprimEspece.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Serotypes Vibrionaces</h1>

        <html:form action="pageModiSerotypeVb.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifEspece"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="pageCreationSerotypeVb" styleClass="lienBtn" titleKey="creer.serotypvib"> Creer un  nouvel Serotype Vibrionaces </html:link></td> 
                    </p>

                    <p>
                        
                    </p>

                    <thead  class="boldtr">
                        <td  class="bord">  <td> désignation </td> &nbsp; <td> visible </td>  
                        
                    </thead >

                    <logic:iterate name="liste_seroVb"  id="espece" indexId="ga">
                        <tr class="av"> 
                            <td> 
                                <html:multibox  property="idserotype_vb" name="espece" onclick="output()" >
                                    <bean:write name="espece" property="idserotype_vb"   /> 
                                </html:multibox> 
                            </td>
                              
                            <td>  <bean:write name="espece" property="design_serotype" /> </td> 
                            <td>  <bean:write name="espece" property="visible" /> </td> 
                            
                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

