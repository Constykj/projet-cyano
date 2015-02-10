<%-- 
    Document   : administration
    Created on : Feb 24, 2014, 11:20:04 PM
    Author     : HP USER
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
                    window.document.gestionUtilisateurModifForm.modifUtil.disabled = true;
                    window.document.gestionUtilisateurModifForm.suprimUtil.disabled = true;

                } else if (total == 1) {
                    window.document.gestionUtilisateurModifForm.modifUtil.disabled = false;
                    window.document.gestionUtilisateurModifForm.suprimUtil.disabled = false;
                } else {
                    window.document.gestionUtilisateurModifForm.modifUtil.disabled = true;
                    window.document.gestionUtilisateurModifForm.suprimUtil.disabled = true;
                }
            }

          

            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionUtilisateurModifForm.modifUtil.disabled = true;
                window.document.gestionUtilisateurModifForm.suprimUtil.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des utilisateurs</h1>

        <html:form action="gestionUtilisateur.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifUtil"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerutilpage" styleClass="lienBtn" titleKey="crrer.utilisateur"> Creer un nouvel Utilisateur </html:link></td> 
                    </p>

                    <p>
                        
                    </p>

                    <thead  class="mheader1">
                        <td  class="tit">  </td> 
                        <td class="tit"> Nom </td>
                        <td class="tit"> Prenoms </td> 
                        <td class="tit"> Identifiant </td>
                        <td class="tit"> Valide </td> 
                        <td class="tit"> Niveau acces </td>  
                    </thead >

                    <logic:iterate name="liste_util"  id="util" indexId="ut">
                        <tr class="av"> 
                            <td  class="mtd1"> 
                                <html:multibox  property="iduser" name="util" onclick="output()" >
                                    <bean:write name="util" property="iduser"   /> 
                                </html:multibox> 
                            </td>
                            <td class="mtd1">  <bean:write name="util" property="nom" /> </td> 
                            <td class="mtd1">  <bean:write name="util" property="prenoms" /> </td> 
                            <td class="mtd1">  <bean:write name="util" property="identifiant" /> </td> 
                            <td class="mtd1">  <bean:write name="util" property="valide" /> </td> 
                            <td class="mtd1">  <bean:write name="util" property="droit" /> </td> 
                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>
