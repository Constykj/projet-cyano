<%-- 
    Document   : exemple
    Created on : Oct 8, 2014, 9:42:41 PM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <script type="text/javascript">
            function app() {
                var liste_tx = new Array();
                
               
                for (i = 1; i <= 2; i++) {
                    var va1 = document.getElementById("sel"+i).value;
                    var va2 = document.getElementById("txt"+i).value;
                    var va3 = document.getElementById("sal"+i).value;

                    var list = new Array();
                    list = [va1, va2, va3];

                    liste_tx.push(list);

                }
                alert(liste_tx);
                document.getElementById("listeGenreCya").value = liste_tx;


            }

        </script>
    </head>
    <body>

        <input type="b"
        <html:form action="exemple.do" method="post" >


            <html:hidden  property="listeGenreCyano" styleId="listeGenreCya" value="" ></html:hidden>
                <table id="tbcyano" >
                    <tr id="r1">

                        <td>
                            <select id="sel1" >
                                <option value="1">bonjour</option>
                                <option value="2">bonsoir</option>
                                <option value="3">salut</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" id="txt1" /> 
                        </td>
                        <td>
                            <select id="sal1">
                                <option value="1">hi</option>
                                <option value="2">hooo</option>
                                <option value="3">waohhhhh</option>
                            </select>
                        </td>
                    </tr>
                    <tr id="r2">

                        <td>
                            <select id="sel2">
                                <option value="1">bonjour</option>
                                <option value="2">bonsoir</option>
                                <option value="3">salut</option>
                            </select>
                        </td>
                        <td>
                            <input type="text" id="txt2" /> 
                        </td>
                        <td>
                            <select id="sal2" >
                                <option value="1">hi</option>
                                <option value="2">hooo</option>
                                <option value="3">waohhhhh</option>
                            </select>
                        </td>
                    </tr>

                </table>
            <html:submit  value="Sauvegarder" onfocus="app()" />
               
        </html:form>
        <script src="lib-jquery/jquery-1.10.2.js"></script>
        <script src="lib-jquery/jqapp.js"></script>
        

    </body>
</html>
