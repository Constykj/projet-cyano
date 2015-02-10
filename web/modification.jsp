<%-- 
    Document   : modification
    Created on : Feb 27, 2014, 11:26:02 AM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
            
           
          //  window.onbeforeunload = function (e) {
                 
         //           return 'En fermant cette page vous perdrez tout.';


          //  }

             

        </script>
     
    </head>
    <body>
        <%@include file="menuapp.jsp" %>
         
        <br/><br/><br/><br/><br/><br/>
        <html:form action="rechercheEchantillon">
            Numero de l'echantillon : <html:text property="num_echan" /> <html:submit styleId="mclick" title="Rechercher" />
             
        </html:form>
        <br/><br/><br/><br/><br/><br/>
        <%@include file="piedpage.jsp" %>
    </body>
        
</html>
   