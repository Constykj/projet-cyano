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
                    window.document.gestionGenreAlgModifForm.modifGenre.disabled = true;
                    window.document.gestionGenreAlgModifForm.suprimGenre.disabled = true;

                } else if (total == 1) {
                    window.document.gestionGenreAlgModifForm.modifGenre.disabled = false;
                    window.document.gestionGenreAlgModifForm.suprimGenre.disabled = false;
                } else {
                    window.document.gestionGenreAlgModifForm.modifGenre.disabled = true;
                    window.document.gestionGenreAlgModifForm.suprimGenre.disabled = true;
                }
            }



            function decocherTout()
            {
                var cases = window.document.getElementsByTagName('input');
                for (var i = 0; i < cases.length; i++)
                    if (cases[i].type === 'checkbox')
                        cases[i].checked = false;
                window.document.gestionGenreAlgModifForm.modifGenre.disabled = true;
                window.document.gestionGenreAlgModifForm.suprimGenre.disabled = true;
            }

            window.onload = decocherTout;
        </script>

    </head>


    <body>

        <%@include file="/menuapp.jsp" %>
        <h1>Gestion des Genres d'Algues</h1>

        <html:form action="gestionGenre_alg.do"  method="post" >
            <div>
                <table class="mtable1">

                    <p>  
                        <html:button value="Modifier" property="modifGenre"  onclick="this.form.submit()"/> &nbsp; ou  &nbsp;
                        <html:link action="creergenre_algpage" styleClass="lienBtn" titleKey="creer.genre_cyano"> Creer un nouvel genre algue </html:link></td> 
                        </p>

                        <p>

                        </p>

                        <thead class="mheader1">
                        <td  class="tit">  </td>
                        <td class="tit"> désignation </td>  
                        <td class="tit"> Famille </td> 
                        <td class="tit"> visible </td>  

                        </thead>

                    <logic:iterate name="liste_genre_algue"  id="genre" indexId="ga">
                        <tr class="av"> 
                            <td class="mtd1"> 
                                <html:multibox  property="idgenre_algue" name="genre" onclick="output()" >
                                    <bean:write name="genre" property="idgenre_algue"   /> 
                                </html:multibox> 
                            </td>
                            <td class="mtd1">  <bean:write name="genre" property="design_genre_algue" /> </td> 
                            <td class="mtd1">  <bean:write name="genre" property="famille" /> </td> 
                            <td class="mtd1">  <bean:write name="genre" property="visible" /> </td> 

                        </tr>
                    </logic:iterate>

                </table>
            </div>
        </html:form>

        <%@include file="/piedpage.jsp" %>
    </body>
</html>

