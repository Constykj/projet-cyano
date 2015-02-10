

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
                    window.document.gestionCommuneModifForm.modifCom.disabled = true;
                    window.document.gestionCommuneModifForm.suprimCom.disabled = true;

                } else if (total == 1) {
                    window.document.gestionCommuneModifForm.modifCom.disabled = false;
                    window.document.gestionCommuneModifForm.suprimCom.disabled = false;
                } else {
                    window.document.gestionCommuneModifForm.modifCom.disabled = true;
                    window.document.gestionCommuneModifForm.suprimCom.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionCommuneModifForm.modifCom.disabled = true;
                window.document.gestionCommuneModifForm.suprimCom.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Communes</h1>

        <html:form action="gestionCommune.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifCom"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creercompage" styleClass="lienBtn" titleKey="creer.commune"> Creer un nouvel commune </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead class="boldtr">
                        <td class="tit" ></td>
                        <td class="tit"> désignation </td> 
                        <td  class="tit"> visible </td>  

                        </thead>

                    <logic:iterate name="liste_com"  id="com" indexId="cm">
                        <tr class="av"> 
                            <td  class="mtd1"> 
                                <html:multibox  property="idcommune" name="com" onclick="output()" >
                                    <bean:write name="com" property="idcommune"   /> 
                                </html:multibox> 
                            </td>

                            <td  class="mtd1">  <bean:write name="com" property="designation" /> </td> 
                            <td  class="mtd1">  <bean:write name="com" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
         
    </body>
</html>
