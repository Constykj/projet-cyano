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
                    window.document.gestionPtprModifForm.modifPt.disabled = true;
                    window.document.gestionPtprModifForm.suprimPt.disabled = true;

                } else if (total == 1) {
                    window.document.gestionPtprModifForm.modifPt.disabled = false;
                    window.document.gestionPtprModifForm.suprimPt.disabled = false;
                } else {
                    window.document.gestionPtprModifForm.modifPt.disabled = true;
                    window.document.gestionPtprModifForm.suprimPt.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionPtprModifForm.modifPt.disabled = true;
                window.document.gestionPtprModifForm.suprimPt.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Points de prelevement</h1>

        <html:form action="gestionmodifptpr.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifPt"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerpageptpr.do" styleClass="lienBtn" title="creer une station de prelevement"> Creer un nouveau point de prelevement </html:link>
                        </p>

                        <p>

                        </p>

                        <tr class="boldtr">
                            <td  class="bord">   
                            <td  class="bord">  Station de prelevement station </td> &nbsp;  
                            <td  class="bord">  Profondeur </td> &nbsp; 
                            <td  class="bord">   Visible </td> &nbsp; 
                        </tr>   

                    <logic:iterate name="liste_ptpr"  id="Prpt" indexId="cm">
                        <tr> 
                            <td> 
                                <html:multibox  property="idpoint_prelevement" name="Prpt" onclick="output()" >
                                    <bean:write name="Prpt" property="idpoint_prelevement"   /> 
                                </html:multibox> 
                            </td>
                            <td>  <bean:write name="Prpt" property="idstat" /> </td> 
                            <td>  <bean:write name="Prpt" property="profondeur" /> </td> 
                             
                            <td>  <bean:write name="Prpt" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

