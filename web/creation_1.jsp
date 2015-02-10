<%-- 
    Document   : creation
    Created on : Feb 27, 2014, 11:25:35 AM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menuapp.jsp" %>
        <h1>Page Creation</h1>


        <html:form action="creaaction.do" method="post" >
            <hr/><br/>

            <table>
                <tr>
                    <td class="bord">  <h3>Fréquentation plan d'eau</h3> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.typ_frequent"/> </td>
                    <td class="bord"> 
                        <html:select property="idpratique"   >    
                            <html:options collection="pratique_trouve" property="idpratique" labelProperty="pratique" /> 
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td class="bord">  <h3>Habitat</h3> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.distance"/> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.effectif"/> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.materiau"/> </td>
                </tr>

            </table><br/>   <br/>   
            <hr/><br/>
            <table>
                <tr>
                    <td class="bord">  <h3>Echantilon</h3> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.num_echan"/> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.date_prev"/> </td>
                </tr>


                <tr>
                    <td class="bord">  &nbsp;  </td>
                    <td class="bord">  &nbsp;  </td>
                </tr>


            </table>
            <hr/><br/>
            <table>
                <tr>

                    <td class="bord" ><h3>Proprietes Phsico-chimique</h3></td>

                </tr>
            </table>
            <table>
                <tr>
                    <td class="bord">  <bean:message key="crea.phosphore"/> </td>
                    <td class="bord"> <html:text property="phosphore" size="25"  /> </td>
                    <td class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.nitrate"/> </td>
                    <td class="bord"> <html:text property="nitrate" size="25"  /> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.phosphate"/> </td>
                    <td class="bord">  <html:text property="phosphate" size="25"  />  </td>
                    <td class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.chlorophyle"/> </td>
                    <td class="bord"> <html:text property="chlorophyle_a" size="25"  /> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.azote"/> </td>
                    <td class="bord"> <html:text property="azote_totale" size="25"  /> </td>
                    <td class="milieu">      </td>

                    <td class="bord">  <bean:message key="crea.tubidite"/> </td>
                    <td class="bord"> <html:text property="tubidite" size="25"  /> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.oxygene"/> </td>
                    <td class="bord"> <html:text property="oxygene_dissout" size="25"  /> </td>
                    <td class="milieu">  </td>

                    <td class="bord">  <bean:message key="crea.fer"/> </td>
                    <td class="bord"><html:text property="fer" size="25"  />  </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.transparence"/> </td>
                    <td class="bord"> <html:text property="transparence" size="25"  /> </td>
                    <td class="milieu">      </td>

                    <td class="bord">  <bean:message key="crea.codium"/> </td>
                    <td class="bord"> <html:text property="cadmium" size="25"  /> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.ph"/> </td>
                    <td class="bord"> <html:text property="ph" size="25"  /> </td>
                    <td class="milieu">       </td>

                    <td class="bord">  <bean:message key="crea.plomb"/> </td>
                    <td class="bord"><html:text property="plomb" size="25"  />  </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.temparature"/> </td>
                    <td class="bord"> <html:text property="temperature" size="25"  /> </td>
                    <td class="milieu">    </td>

                    <td class="bord">  <bean:message key="crea.selenium"/> </td>
                    <td class="bord"><html:text property="seleniuml" size="25"  />  </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.eclairage"/> </td>
                    <td class="bord">  
                        <html:select property="ideclairage"   >    
                            <html:options collection="eclai_trouve" property="ideclairage" labelProperty="designation" /> 
                        </html:select>
                    </td>
                    <td class="milieu">    </td> 

                    <td class="bord">  <bean:message key="crea.nickel"/> </td>
                    <td class="bord"> <html:text property="nickel" size="25"  /> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.salinite"/> </td>
                    <td class="bord"> <html:text property="salinite" size="25"  /> </td>
                    <td class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.arsenic"/> </td>
                    <td class="bord"> <html:text property="arsenic" size="25"  />  </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.conductivite"/> </td>
                    <td class="bord"><html:text property="conductivite" size="25"  />  </td>
                    <td class="milieu">  </td>

                    <td class="bord">  <bean:message key="crea.zinc"/> </td>
                    <td class="bord"><html:text property="zinc" size="25"  />  </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.cuivre"/> </td>
                    <td class="bord"> <html:text property="cuivre" size="25"  /> 
                    <td class="milieu">   </td>
                    <td class="bord"> <bean:message key="crea.visible"/> </td>

                    <td class="bord">   <html:select property="visible">    

                            <html:option value="1">Valide</html:option> 
                            <html:option  value="0">Non valide</html:option>

                        </html:select></td> 
                    <td class="bord">  

                    </td>



                </tr>
            </table><br/>   <br/>   
            <hr/><br/>     
            <table>
                <tr>
                    <td class="bord" ><h3>Cyanobacterie</h3></td>

                </tr>
            </table>
            <table>
                <tr>
                    <td class="bord">  <bean:message key="crea.nombre_de_genrecyano"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.nombre_espece_cyano"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.espece"/> </td>
                    <td class="bord"> </td>
                    <td  class="milieu">      </td>

                    <td class="bord">  <bean:message key="crea.genrecyano"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.concgenrcyano"/> </td>
                    <td class="bord"> </td>
                    <td  class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.genetoxicite"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.concgenetoxicite"/> </td>
                    <td class="bord"> </td>
                    <td  class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.concmicrocystite"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.typgenetoxicite"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu" >     </td>

                    <td class="bord">  <bean:message key="crea.conctoxinemicrocystite"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.typtoxinemicrocystite"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu">      </td>

                    <td class="bord">  <bean:message key="crea.concanatoxine"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.nombre_de_genre"/> </td>
                    <td class="bord"> </td>

                </tr>

            </table><br/>   <br/> 
            <hr/><br/>
            <table>
                <tr>
                    <td class="bord">  <h3>Parasite</h3> </td>
                </tr>
            </table>
            <table>
                <tr> 
                    <td class="bord">  <bean:message key="crea.cryptosoridium"/> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.giardia"/> </td>
                </tr>
                <tr> 
                    <td class="bord">  <bean:message key="crea.helminthe"/> </td>
                </tr>

            </table><br/>   <br/> 
            <hr/><br/>
            <table>
                <tr>
                    <td class="bord">  <h3>Virus</h3> </td>
                </tr>

                <tr> 
                    <td class="bord">  <bean:message key="crea.enterovirus"/> </td>
                </tr>
            </table><br/>   <br/>   
            <hr/><br/>     
            <table>
                <tr>
                    <td class="bord"> <h3>Autres bacteries</h3> </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td class="bord">  <bean:message key="crea.califormet"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu" >    </td>

                    <td class="bord">  <bean:message key="crea.especevibrio"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.califormeth"/> </td>
                    <td class="bord"> </td>
                    <td  class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.serotypevibriocholerae"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.streptocoquefecaux"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu">   </td>

                    <td class="bord">  <bean:message key="crea.srotypesalmonelle"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.anaerobisulforecl"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu"> </td>

                    <td class="bord">  <bean:message key="crea.autresalmonelle"/> </td>
                    <td class="bord"> </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.echerichiacoli"/> </td>
                    <td class="bord"> </td>
                    <td class="milieu">  </td>
                    <td class="bord">  <bean:message key="crea.echerichiacoli"/> </td>
                    <td class="bord"> </td>
                </tr>
            </table>
            <table><br/>   <br/>   
                <hr/><br/>     
                  <table>
                <tr>
                    <td class="bord"> <h3>Autres bacteries</h3> </td>
                </tr>
            </table>
            <table>
                <tr>
                    <td class="bord">  <bean:message key="crea.espece"/> </td>
                    <td class="bord">
                         <html:select property="idespece_algue"   >    
                            <html:options collection="espece_trouve" property="idespece_algue" labelProperty="design_espece_algue" /> 
                        </html:select>
                    </td>
                    <td class="milieu" >    </td>

                    <td class="bord">  <bean:message key="crea.genre"/> </td>
                    <td class="bord">
                         <html:select property="idgenre_algue"   >    
                            <html:options collection="genre_trouve" property="idgenre_algue" labelProperty="design_genre_algue" /> 
                        </html:select>
                    </td>
                </tr>
                <tr>
                    <td class="bord">  <bean:message key="crea.famille"/> </td>
                    <td class="bord">
                         <html:select property="idfamille"   >    
                            <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                        </html:select>
                    </td>
                    <td  class="milieu">     </td>

                    <td class="bord">  <bean:message key="crea.nombre"/> </td>
                    <td class="bord"> 
                         <html:select property="idautre_algue"   >    
                            <html:options collection="algue_trouve" property="idautre_algue" labelProperty="design_algue" /> 
                        </html:select>
                    </td>
                </tr>
                
            </table>
                <table class="pied">
                    <tr>
                        <td colspan="2"  class="bord">  <html:submit value="Sauvegarder" /> <html:reset /> &nbsp;
                            <html:link  action="pagecreation.do" styleClass="lienBtn" title="aller à la page precedante"> Annuler </html:link></td>
                        </tr>
                    </table> 
            </html:form>
            <%@include file="piedpage.jsp" %>
    </body>
</html>