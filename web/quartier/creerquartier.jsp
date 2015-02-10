<%-- 
    Document   : creerquartier
    Created on : Mar 12, 2014, 3:06:58 AM
    Author     : Abouchou
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <%--<script type="text/javascript">
            function Lettres(champ) {
                if (!/^[a-zA-Z]+$/.test(champ.value)) {
                   // alert("Vous avez entré un chiffre");
                   document.getElementById("er").value="Vous avez entré un chiffre";
                    champ.focus();
                    return false;
                }
                return true;
            }
            function Chiffres(champ) {
                if (!/^[0-9]+$/.test(champ.value)) {
                  //  efface();
                     document.getElementById("er").value="Vous avez entré une lettre";
                   // alert("Vous avez entré une lettre ");
                    champ.focus();
                    return false;
                }
                return true;
            }
            function verif() {
                var ok = true;
                ok = ok && Lettres(document.getElementById("designation").value);
                ok = ok && Chiffres(document.getElementById("designation").value);

                return ok;
            }
             function efface() {
                 document.getElementById("designation").style.border='red';
            }
</script>--%>


    </head>
    <body>
        <%@include file="/menuapp_1.jsp" %>

        <h1>Creation Quartier </h1>

        <html:form action="creerquartier.do" method="post" >

            <table>


                <tr>
                    <td class="bord">  <bean:message key="quartier.designation"/> </td>
                    <td class="bord">  <html:text styleId="designation"  property="designation" size="25"  onchange="efface()" onblur="Chiffres(this)" /> </td>
                    <td class="bord">   <input id="er" type="text"/>  </td>
                </tr>


                <tr>
                    <td class="bord">  <bean:message key="quartier.visible"/>  </td>
                    <td class="bord">
                        <html:select property="visible">    

                            <html:option value="1">Valide</html:option> 
                            <html:option  value="0">Non valide</html:option>

                        </html:select>
                    </td>
                </tr>

                <tr>
                    <td class="bord">  &nbsp;  </td>
                    <td class="bord">  &nbsp;  </td>
                </tr>
                <tr>
                    <td colspan="2"  class="bord">  <html:submit value="Enregistrer" /> <html:reset /> &nbsp;
                        <html:link action="gestionquart" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                    </tr>
                </table>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

