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
        <script >

        </script>
    </head>

    <body >
        <%@include file="menuapp.jsp" %>
        
        <h2>  <font class="error"> <html:errors property="errright" /></font>  </h2> 

        <br/>
        <br/>
        <br/>
        <br/>
        <div>



            <fieldset class="fld1" style=" float: left; ">  
                <ul>

                    <li> <html:link action="gestionplaneau"  title="aller à la page  plan d'eau "><bean:message key="sous.menu.admin.plan_eau" /></html:link></li>
                    <li> <html:link action="gestionhabitat"  title="aller à la page habitat "><bean:message key="sous.menu.admin.habitat" /></html:link></li>
                    <li> <html:link action="gestiontyppe"  title="aller à la page type plan d'eau"><bean:message key="sous.menu.admin.type_plan_eau" /></html:link></li>
                    <li> <html:link action="gestionpra"  title="aller à la page pratique"><bean:message key="sous.menu.admin.pratique" /></html:link></li>
                    <li> <html:link action="gestionquart"  title="aller à la page quartier"><bean:message key="sous.menu.admin.quartier" /></html:link></li>
                    <li> <html:link action="gestioncom"  title="aller à la page commune"><bean:message key="sous.menu.admin.commune" /></html:link></li>
                    <li> <html:link action="gestionreg"  title="aller à la page region"><bean:message key="sous.menu.admin.region" /></html:link></li>
                    <li> <html:link action="gestionmat"  title="aller à la page materiaux de construction"><bean:message key="sous.menu.admin.materiaux" /></html:link></li>
                    <li> <html:link action="gestionstatpr"  title="aller à la page station de prelevement"><bean:message key="sous.menu.admin.Station" /></html:link></li>
                    <li> <html:link action="gestionptpr"  title="aller à la page point de prelevement"><bean:message key="sous.menu.admin.Point" /></html:link></li>
                        <%--
                            <li><html:link action="prochain" styleClass="lienBtn" title="aller à la page precedante"> Aller a la prochaine page</html:link> </li>
                        --%>
                </ul> 
            </fieldset>


            <fieldset  class="fld1" style=" float: left; "> 
                <ul>
                    <li> <html:link  action="gestionproj" title="aller à la page projet"><bean:message key="sous.menu.admin.projet" /></html:link></li>
                        <%-- <li> <html:link  action="gestionech" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.echantillon" /></html:link></li> --%>
                </ul>

            </fieldset > 

            <fieldset  style=" float: left; " class="fld1"> 

                <ul>
                    <li> <html:link  action="gestiongenre_cyano" title="aller à la page genre cyanobacterie "><bean:message key="sous.menu.admin.genre_cyano" /></html:link></li>
                    <li> <html:link  action="gestionespece_cyano" title="aller à la page espèce cyanobactérie "><bean:message key="sous.menu.admin.espece_cyano" /></html:link></li>
                    <li> <html:link  action="pageGestionCyano" title="aller à la page gêne cyanobactérie "><bean:message key="sous.menu.admin.gene_cyano" /></html:link></li>

                   <!--     <li> <html:link  action="pageGestionTypeGeneCyano" title="aller à la page type gêne cyanobactérie "><bean:message key="sous.menu.admin.TypCyano" /></html:link></li> -->
                    <li> <html:link  action="pageGestionTypeGeneToxicite" title="aller à la page type gêne toxicité "><bean:message key="sous.menu.admin.TypToxicite" /></html:link></li>  
                    <li> <html:link  action="pageGestionTypeToxine" title="aller à la page type toxine"><bean:message key="sous.menu.admin.TypToxine" /></html:link></li>     

                    <%--  <li> <html:link  action="pageGestionSerotypeSal" title="aller à la page sérotype salmonelle "><bean:message key="sous.menu.admin.serotype_sal" /></html:link></li>
                    <li> <html:link  action="pageGestionSerotypeVb" title="aller à la page sérotype vibrionaceae "><bean:message key="sous.menu.admin.serotype_vb" /></html:link></li> --%>
                    <li> <html:link  action="gestioneclaire" title="aller à la page éclairage "><bean:message key="sous.menu.admin.eclairage" /></html:link></li>
                    <li> <html:link  action="gestionfamy" title="aller à la page famille "><bean:message key="sous.menu.admin.famille" /></html:link></li> 


                    <%--     <li> <html:link  action="gestionespece_alg" title="aller à la page espèce algue "><bean:message key="sous.menu.admin.espece_algue" /></html:link></li>--%>
                    <li> <html:link  action="gestiongenre_alg" title="aller à la page genre algue "><bean:message key="sous.menu.admin.genre_algue" /></html:link></li>
                        <%--
                        <li><s> <html:link  action="gestioncyano" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.cyanobacterie" /></s></html:link></li>  
                        <li> <s><html:link  action="gestionautre_alg" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.autre_algue" /></html:link></s></li>
                        <li> <s><html:link  action="pageGestionEspeceVb" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.espece_vb" /></html:link></s></li>
                        <li> <s><html:link  action="gestionvirus" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.virus" /></html:link></s></li>
                        <li> <s><html:link  action="gestionParasite" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.parasite" /></html:link></s></li>
                        <li> <s><html:link  action="gestionAction" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.salmonelle" /></html:link></s></li>
                        <li> <s><html:link  action="gestionVibrio" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.vibrionaces" /></html:link></s></li>
                        <li> <s><html:link  action="gestionautre_bact" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.autre_bacterie" /></html:link></s></li>
                      
                    <li> <html:link  action="gestiontoxine" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.toxine" /></html:link>?</li>
                    <li> <html:link  action="gestionfamy" title="aller à la page d'accueil"><bean:message key="sous.menu.admin.famille" /></html:link>?</li>  --%>
                </ul>

            </fieldset > 

            <fieldset class="fld1" style=" float: left; "> 

                <ul>
                    <li> <html:link  action="gestionutil" title="aller à la page utilisateur "><bean:message key="sous.menu.admin.utilisateur" /></html:link></li>
                    </ul>

                </fieldset > 


                <br/>



            </div>
            <div class="fld2">
            <%@include file="/piedpage.jsp" %>
        </div>
    </body>

</html>
