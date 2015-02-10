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
                    window.document.gestionEchantillonModifForm.modifEchan.disabled = true;
                    window.document.gestionEchantillonModifForm.suprimEchan.disabled = true;

                } else if (total == 1) {
                    window.document.gestionEchantillonModifForm.modifEchan.disabled = false;
                    window.document.gestionEchantillonModifForm.suprimEchan.disabled = false;
                } else {
                    window.document.gestionEchantillonModifForm.modifEchan.disabled = true;
                    window.document.gestionEchantillonModifForm.suprimEchan.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionEchantillonModifForm.modifEchan.disabled = true;
                window.document.gestionEchantillonModifForm.suprimEchan.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Plan d'eau</h1>

        <html:form action="modifiEchan.do"  method="post" >
            <div>
                <table class="decoche">

                    <p>  
                        <html:button value="Modifier" property="modifEchan"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creerechanpage.do" styleClass="lienBtn" title="creer un plan d'eau"> Creer un nouvel echantillon</html:link>
                        </p>

                        <p>

                        </p>

                        <tr class="boldtr">
                            <td  class="bord">   
                            <td  class="bord">  Numero echantillon </td> &nbsp;  
                            <td  class="bord">  Date  prelevement </td> &nbsp; 
                            <td  class="bord">  Virus </td> &nbsp; 
                            <td  class="bord">   Autre Algue </td> &nbsp; 
                            <td  class="bord">  Autre Bacterie</td> &nbsp; 
                            <td  class="bord">  Cyanobacterie </td> &nbsp;
                            <td  class="bord">   Visible </td> &nbsp; 


                        </tr>

                    <logic:iterate name="liste_echantillon"  id="ech" indexId="ch">
                        <tr> 
                            <td> 
                                <html:multibox  property="idechantillon" name="ech" onclick="output()" >
                                    <bean:write name="ech" property="idechantillon"   /> 
                                </html:multibox> 
                            </td>

                            <td>  <bean:write name="ech" property="Numeroechantillon" /> </td> 
                            <td>  <bean:write name="ech" property="Date echantillon" /> </td> 
                            <td>  <bean:write name="ech" property="Virus" /> </td> 
                            <td>  <bean:write name="ech" property="Autre Algue" /> </td> 
                            <td>  <bean:write name="ech" property="Autre Bacterie" /> </td> 
                            <td>  <bean:write name="ech" property="Cyanobacterie" /> </td> 
                            <td>  <bean:write name="ech" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

