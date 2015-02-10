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
        <script src="lib-jquery/prototype.js"></script>
        <script type="text/javascript">

            function Chiffres(name) {
                var nn = name.value;
                // alert(nn);
                if (nn != "" && !/^[0-9]+(.[0-9])?$/.test(name.value)) {
                    name.style.borderColor = "red";
                    name.focus();
                    return false;
                }
                return true;

            }

            function verif(name) {
                var ok = true;
                ok = ok && Chiffres(document.getElementById(name).value);
                return ok;
            }
            function PerdFocus(name) {
                name.style.borderColor = "lightgrey";
            }

            window.onbeforeunload = function (e) {
                return '';
            }



            function disableBeforeUnload() {
                window.onbeforeunload = null;
            }

            function doAjaxPost() {

                var url = "/Cyano1/datapointprelev.do";
                new Ajax.Request(url, {
                    parameters: {idpoint_prelevement: document.getElementById("pp").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            document.getElementById("pp_pronf").value = json.profondeur;
                            document.getElementById("sp_designation").value = json.design_stprelev;
                            document.getElementById("sp_gps_lat").value = json.gps_lat;
                            document.getElementById("sp_gps_long").value = json.gps_long;
                            document.getElementById("pe_design").value = json.designation;
                            document.getElementById("pe_type").value = json.type_pe;
                            document.getElementById("pe_superf").value = json.superficie;
                            document.getElementById("pe_matfec").value = json.matiere_fecale;
                            document.getElementById("pe_comm").value = json.commune_;
                            document.getElementById("pe_quart").value = json.quartier_;
                            document.getElementById("pe_reg").value = json.region_;
                            document.getElementById("h_prat").value = json.pratique;
                            document.getElementById("pe_comment").value = json.commentaire;
                            document.getElementById("h_design").value = json.habitat_designation;
                            document.getElementById("h_effect").value = json.effectif;
                            document.getElementById("h_dist").value = json.distance;
                            document.getElementById("h_mat_const").value = json.mat_construction;



                        }
                    }
                });
            }

            function doAjaxPost1() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg1").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue1').empty();
                            $('#ta_genre1').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue1').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue1').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost2() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg2").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue2').empty();
                            $('#ta_genre2').empty();
                            // autres listes cachees
                            $('#genre_algue1').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue2').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue2').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost3() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg3").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue3').empty();
                            $('#ta_genre3').empty();
                            // autres listes cachees
                            $('#genre_algue1').hide();
                            $('#genre_algue2').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue3').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue3').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });
            }

            function doAjaxPost4() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg4").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue4').empty();
                            $('#ta_genre4').empty();
                            // autres listes cachees
                            $('#genre_algue1').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue2').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue4').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue4').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });
            }

            function doAjaxPost5() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg5").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue5').empty();
                            $('#ta_genre5').empty();
                            // autres listes cachees
                            $('#genre_algue1').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue2').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue5').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue5').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost6() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg6").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue6').empty();
                            $('#ta_genre6').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue1').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue6').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue6').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost7() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg7").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue7').empty();
                            $('#ta_genre7').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue1').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue7').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue7').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost8() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg8").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue8').empty();
                            $('#ta_genre8').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue1').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue8').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue8').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }


            function doAjaxPost9() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg9").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue9').empty();
                            $('#ta_genre9').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue1').hide();
                            $('#genre_algue10').hide();

                            $('#genre_algue9').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue9').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function doAjaxPost10() {

                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: document.getElementById("famalg10").value},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            $('#genre_algue10').empty();
                            $('#ta_genre10').empty();
                            // autres listes cachees
                            $('#genre_algue2').hide();
                            $('#genre_algue3').hide();
                            $('#genre_algue4').hide();
                            $('#genre_algue5').hide();
                            $('#genre_algue6').hide();
                            $('#genre_algue7').hide();
                            $('#genre_algue8').hide();
                            $('#genre_algue9').hide();
                            $('#genre_algue1').hide();

                            $('#genre_algue10').show();
                            $.each(json, function (index, value) {
                                $('#genre_algue10').append('<option value="' + index + '">' + value + '</option>');
                            });
                        }
                    }
                });

            }

            function dbGenre() {
                var valeur = document.getElementById("genre_algue");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre').append(text + '; ');
            }

            function dbGenre1() {
                var valeur = document.getElementById("genre_algue1");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre1').append(text + '; ');
            }

            function dbGenre2() {
                var valeur = document.getElementById("genre_algue2");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre2').append(text + '; ');
            }

            function dbGenre3() {
                var valeur = document.getElementById("genre_algue3");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre3').append(text + '; ');
            }

            function dbGenre4() {
                var valeur = document.getElementById("genre_algue4");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre4').append(text + '; ');
            }

            function dbGenre5() {
                var valeur = document.getElementById("genre_algue5");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre5').append(text + '; ');
            }

            function dbGenre6() {
                var valeur = document.getElementById("genre_algue6");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre6').append(text + '; ');
            }

            function dbGenre7() {
                var valeur = document.getElementById("genre_algue7");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre7').append(text + '; ');
            }

            function dbGenre8() {
                var valeur = document.getElementById("genre_algue8");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre8').append(text + '; ');
            }

            function dbGenre9() {
                var valeur = document.getElementById("genre_algue9");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre9').append(text + '; ');
            }
            function dbGenre10() {
                var valeur = document.getElementById("genre_algue10");
                var text = valeur.options[valeur.selectedIndex].text;
                $('#ta_genre10').append(text + '; ');
            }

            function checkbox() {

                var tableau = window.document.getElementById('tbaa');
                var ligne = tableau.getElementsByName('aa1');
                var cases = ligne.getElementsByTagName('input');
                if (cases.type === 'checkbox') {
                    if (cases[i].checked === true)
                        alert("yes");
                }
            }

            function selectGenreCyano() {

                var liste_tx = new Array();
                // var valtr = document.getElementById("tbgrc").childNodes.length;                 
                for (i = 1; i <= 10; i++) {
                    var va1 = document.getElementById("sel_genre_cy" + i).value;
                    var va3 = document.getElementById("sel_esp_cy" + i).value;
                    var va2 = document.getElementById("text_genre_cy" + i).value;
                    var list = new Array();
                    list = [va1, va2, va3];
                    liste_tx.push(list);
                }
                //    alert(liste_tx);   
                document.getElementById("listeGenreCya").value = liste_tx;
            }

            function selectGeneCyano() {
                // alert("ok1");
                var liste_tx = new Array();
                for (i = 1; i <= 10; i++) {

                    var va1 = document.getElementById("gene_cyano" + i).value;
                    var va2 = document.getElementById("nb_gene_cyano" + i).value;
                    var list = new Array();
                    list = [va1, va2];
                    liste_tx.push(list);
                }
                // alert(liste_tx);
                document.getElementById("listeGeneCya").value = liste_tx;
            }

            function selectTypeGeneToxicite() {
                //alert("ok1");
                var liste_tx = new Array();
                for (i = 1; i <= 10; i++) {

                    var va1 = document.getElementById("gene_toxicite" + i).value;
                    var va2 = document.getElementById("nb_gene_toxicite" + i).value;
                    var list = new Array();
                    list = [va1, va2];
                    liste_tx.push(list);
                }
                //  alert(liste_tx);
                document.getElementById("listeTypeGeneTox").value = liste_tx;
            }

            function selectTypeToxine() {
                // alert("ok1");
                var liste_tx = new Array();
                for (i = 1; i <= 10; i++) {

                    var va1 = document.getElementById("type_toxine" + i).value;
                    var va2 = document.getElementById("nb_type_toxine" + i).value;
                    var list = new Array();
                    list = [va1, va2];
                    liste_tx.push(list);
                }
                // alert(liste_tx);
                document.getElementById("listeTypeTox").value = liste_tx;
            }

            function selectAutreAlgue() {

                //1
                var va11 = document.getElementById("famalg1").value;
                var va21 = document.getElementById("ta_genre1").value;
                //verifie si textArea est vide, si oui le champ hidden associe n'est pas remplie une propriete vide st alors poste

                var list1 = new Array();
                list1 = [va11, va21];
                document.getElementById("algue_fam_genre1").value = list1;
                //  alert(list1);


                //2
                var va12 = document.getElementById("famalg2").value;
                var va22 = document.getElementById("ta_genre2").value;

                var list2 = new Array();
                list2 = [va12, va22];
                document.getElementById("algue_fam_genre2").value = list2;
                //     alert(list2);

                //3
                var va13 = document.getElementById("famalg3").value;
                var va23 = document.getElementById("ta_genre3").value;

                var list3 = new Array();
                list3 = [va13, va23];
                document.getElementById("algue_fam_genre3").value = list3;
                // alert(list3);

                //4
                var va14 = document.getElementById("famalg4").value;
                var va24 = document.getElementById("ta_genre4").value;

                var list4 = new Array();
                list4 = [va14, va24];
                document.getElementById("algue_fam_genre4").value = list4;
                // alert(list4);

                //5
                var va15 = document.getElementById("famalg5").value;
                var va25 = document.getElementById("ta_genre5").value;

                var list5 = new Array();
                list5 = [va15, va25];
                document.getElementById("algue_fam_genre5").value = list5;
                // alert(list5);

                //6
                var va16 = document.getElementById("famalg6").value;
                var va26 = document.getElementById("ta_genre6").value;

                var list6 = new Array();
                list6 = [va16, va26];
                document.getElementById("algue_fam_genre6").value = list6;
                // alert(list6);

                //7
                var va17 = document.getElementById("famalg7").value;
                var va27 = document.getElementById("ta_genre7").value;

                var list7 = new Array();
                list7 = [va17, va27];
                document.getElementById("algue_fam_genre7").value = list7;
                // alert(list7);

                //8
                var va18 = document.getElementById("famalg8").value;
                var va28 = document.getElementById("ta_genre8").value;

                var list8 = new Array();
                list8 = [va18, va28];
                document.getElementById("algue_fam_genre8").value = list8;
                // alert(list8);



                //9
                var va19 = document.getElementById("famalg9").value;
                var va29 = document.getElementById("ta_genre9").value;

                var list9 = new Array();
                list9 = [va19, va29];
                document.getElementById("algue_fam_genre9").value = list9;
                // alert(list9);

                //10
                var va110 = document.getElementById("famalg10").value;
                var va210 = document.getElementById("ta_genre10").value;

                var list10 = new Array();
                list10 = [va110, va210];
                document.getElementById("algue_fam_genre10").value = list10;
                // alert(list10);


            }

            function dateCache() {
                var valeur = document.getElementById("datecache").value;
                document.getElementById("datecache_").value = valeur;

            }

            function sommeEspCyano() {
                var va1 = document.getElementById("text_genre_cy1").value;
                var va2 = document.getElementById("text_genre_cy2").value;
                var va3 = document.getElementById("text_genre_cy3").value;
                var va4 = document.getElementById("text_genre_cy4").value;
                var va5 = document.getElementById("text_genre_cy5").value;
                var va6 = document.getElementById("text_genre_cy6").value;
                var va7 = document.getElementById("text_genre_cy7").value;
                var va8 = document.getElementById("text_genre_cy8").value;
                var va9 = document.getElementById("text_genre_cy9").value;
                var va10 = document.getElementById("text_genre_cy10").value;
                var som = parseInt(va1) + parseInt(va2) + parseInt(va3) + parseInt(va4) + parseInt(va5) + parseInt(va6) + parseInt(va7) + parseInt(va8) + parseInt(va9) + parseInt(va10);
                document.getElementById("denombCya").value = "";
                document.getElementById("denombCya").value = som;

            }

            function somAutreAlg() {
                var va1 = document.getElementById("ta_genre1").value;
                var va11 = 0;
                if (va1 !== "") {
                    var va11 = (va1.split(";")).length - 1;
                }
                var va2 = document.getElementById("ta_genre2").value;
                var va21 = 0;
                if (va2 !== "") {
                    var va21 = (va2.split(";")).length - 1;
                }
                var va3 = document.getElementById("ta_genre3").value;
                var va31 = 0;
                if (va3 !== "") {
                    var va31 = (va3.split(";")).length - 1;
                }
                var va4 = document.getElementById("ta_genre4").value;
                var va41 = 0;
                if (va4 !== "") {
                    var va41 = (va4.split(";")).length - 1;
                }
                var va5 = document.getElementById("ta_genre5").value;
                var va51 = 0;
                if (va5 !== "") {
                    var va51 = (va5.split(";")).length - 1;
                }
                var va6 = document.getElementById("ta_genre6").value;
                var va61 = 0;
                if (va6 !== "") {
                    var va61 = (va6.split(";")).length - 1;
                }
                var va7 = document.getElementById("ta_genre7").value;
                var va71 = 0;
                if (va7 !== "") {
                    var va71 = (va7.split(";")).length - 1;
                }
                var va8 = document.getElementById("ta_genre8").value;
                var va81 = 0;
                if (va8 !== "") {
                    var va81 = (va8.split(";")).length - 1;
                }
                var va9 = document.getElementById("ta_genre9").value;
                var va91 = 0;
                if (va9 !== "") {
                    var va91 = (va9.split(";")).length - 1;
                }
                var va10 = document.getElementById("ta_genre10").value;
                var va101 = 0;
                if (va10 !== "") {
                    var va101 = (va10.split(";")).length - 1;
                }

                document.getElementById("totalAlg").value = "";

                var total = va11 + va21 + va31 + va41 + va51 + va61 + va71 + va81 + va91 + va101;

                document.getElementById("totalAlg").value = total;

            }
        </script>
    </head>
    <body onload="doAjaxPost();
            dateCache();
            sommeEspCyano();
            somAutreAlg();">
        <%@include file="menuapp.jsp" %>
        <br/>
        <br/>
        <br/>
        <br/>
        <html:form action="updateaction.do" method="post" >

            <input type="button" value="- -"  id="bdivt" />
            <br/> <br/>
            <!-- Projet -->

            <div>
                <fieldset>
                    <br/>
                    <div>     
                        Projet: &nbsp;
                        <html:select property="idprojet"  name="projet_trouvef"  >    
                            <html:options collection="projet_trouve" property="idprojet" labelProperty="design_projet" /> 
                        </html:select>
                    </div>
                    <br/>
                </fieldset>

            </div>
            <br/>
            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv1" />
            <br/> <br/>

            <!-- identification du site -->
            <div>
                <fieldset>
                    <legend>Identidication du site</legend>

                    <div id="div1"  >
                        <div style="float: left; " >
                            <!-- Point de prelevement  -->
                            <div style="width: 425px;float: left" >
                                <fieldset>
                                    <legend>Point de prelevement</legend>
                                    <table>

                                        <tr> 
                                            <td class="bord">  Identifiant </td>
                                            <td class="bord"> 
                                                <html:select property="idpoint_prelevement" styleId="pp" name="ppmt_trouvef"   onchange="doAjaxPost()">    
                                                    <html:options collection="pointprelev_trouve" property="idpoint_prelevement" labelProperty="designation" /> 
                                                </html:select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="bord"> Profondeur </td>
                                            <td class="bord"> <input type="text" size="25" id="pp_pronf" disabled="true"/></td>
                                        </tr>
                                        <tr>
                                            <td class="bord">&nbsp; </td>
                                            <td class="bord">  &nbsp; </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </div>
                            <!-- station de prelevement  -->
                            <div style="width: 425px;float: left"  >
                                <fieldset  >
                                    <legend>Station de prelevement</legend>
                                    <table>

                                        <tr> 
                                            <td class="bord">  Designation </td>
                                            <td class="bord"> 
                                                <input type="text" size="25" id="sp_designation" disabled="true"/>  
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="bord"> Latitude </td>
                                            <td class="bord"> <input type="text" size="25" id="sp_gps_lat1"  disabled="true" />  </td>
                                        </tr>

                                        <tr>
                                            <td class="bord"> Longitude </td>
                                            <td class="bord"> <input type="text" size="25" id="sp_gps_long1" disabled="true"   />  </td>
                                        </tr>
                                    </table>
                                </fieldset>
                            </div>
                            <!-- plan d'eau -->
                            <div>
                                <fieldset style="width: 820px; " >
                                    <legend>Plan d'eau</legend>
                                    <table>
                                        <tr>
                                            <td class="bord"> Designation</td>
                                            <td class="bord"> <input type="text" size="25" id="pe_design" size="25" disabled="true" /> </td>
                                            <td class="milieu">       </td>

                                            <td class="bord">  Type plan d'eau </td>
                                            <td class="bord"><input type="text" size="25" id="pe_type"  disabled="true" />  </td>
                                        </tr>
                                        <tr>
                                            <td class="bord"> Superficie</td>
                                            <td class="bord"> <input type="text" size="25" id="pe_superf" disabled="true"  /> </td>
                                            <td class="milieu">       </td>

                                            <td class="bord">  Presence de matiere fecale</td>
                                            <td class="bord"><input type="text" size="25" id="pe_matfec"  disabled="true" />  </td>
                                        </tr>
                                        <tr>
                                            <td class="bord"> Commune</td>
                                            <td class="bord"> <input type="text" size="25" id="pe_comm" disabled="true"  />   </td>
                                            <td class="milieu">       </td>

                                            <td class="bord">  Quartier </td>
                                            <td class="bord"><input type="text" size="25" id="pe_quart" disabled="true"  />   </td>
                                        </tr>
                                        <tr>
                                            <td class="bord"> Region</td>
                                            <td class="bord"> <input type="text" size="25" id="pe_reg" disabled="true"  />   </td>
                                            <td class="milieu">       </td>

                                            <td class="bord">    </td>
                                            <td class="bord">   </td>
                                        </tr>
                                        <tr>
                                            <td class="bord">  Pratique</td>
                                            <td class="bord">  <textarea  cols="26" rows="3" id="h_prat" disabled="true" > </textarea>  </td>

                                            <td class="milieu">       </td>

                                            <td class="bord"> commentaire</td>
                                            <td class="bord"> <textarea  cols="26" rows="3" id="pe_comment"disabled="true" > </textarea> </td>

                                        </tr>
                                    </table>
                                </fieldset>
                            </div>

                            <!-- Habitat -->

                            <div> 
                                <fieldset style="width: 820px;" >

                                    <legend>Habitat</legend>

                                    <table>
                                        <tr>
                                            <td class="bord"> Designation</td>
                                            <td class="bord"> <input type="text" size="25" id="h_design" disabled="true"  />   </td>
                                            <td class="milieu">       </td>
                                            <td class="bord"> Effectif</td>
                                            <td class="bord"> <input type="text" size="25" id="h_effect" disabled="true"  />  </td> 
                                        </tr>

                                        <tr>
                                            <td class="bord"> Distance bord</td>
                                            <td class="bord"> <input type="text" size="25" id="h_dist"  disabled="true" /> </td>
                                            <td class="milieu">       </td>


                                            <td class="bord">   </td>
                                            <td class="bord">  </td>
                                        </tr>
                                        <tr>

                                            <td class="bord">  Materiaux de construction </td>
                                            <td class="bord"> <textarea  cols="26" rows="3" id="h_mat_const" disabled="true"> </textarea> </td>
                                            <td class="milieu">       </td>

                                        </tr>
                                    </table>
                                </fieldset>
                            </div>
                        </div>
<!--
                        
                        <div style=" float: left">
                            <div id="mapcrea1" style="width: 440px; height: 450px; border: 1px solid
                                 #777; overflow: hidden; float: left ">

                            </div>

                        </div>
   -->                    

                    </div>

                </fieldset>

            </div>

            <br/>
            <hr/>
            <br/>

            <!-- numero et date echantillon -->
            <div>
                <fieldset>

                    <div>               
                        <table>

                            <tr> 
                                <td class="bord">   </td>
                                <td class="bord"> 

                                </td>
                            </tr>
                            <tr>

                                <td class="bord"> <bean:message key="crea.num_echan"/> </td>
                                <td class="bord"> <html:text property="num_echantillon" size="17"  name="num_trouve"  /> </td>

                            </tr>
                            <tr>
                                <html:hidden property="date_prelevement" name="num_trouve" styleId="datecache"/>
                                <td class="bord"> <bean:message key="crea.date_prev"/>                     </td>
                                <td class="bord"> <input type="date" name="date_creat" width="25" id="datecache_"/>  </td>
                            </tr>
                        </table>
                    </div>

                </fieldset>

            </div>

            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv2" />
            <br/> <br/>
            <!-- Propriete physico chimique -->
            <div >
                <fieldset>
                    <legend> Propriete physico chimique</legend>
                    <div id="div2">   
                        <table >
                            <tr>
                                <td class="bord">  <bean:message key="crea.phosphore"/> </td>
                                <td class="bord"> <html:text property="phosphore" size="25"  name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.nitrate"/> </td>
                                <td class="bord"> <html:text property="nitrate" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.couleur_eau_brute"/> </td>
                                <td class="bord"> <html:text property="couleur_eau_brute"  name="ppchim_trouve" size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.phosphate"/> </td>
                                <td class="bord">  <html:text property="phosphate" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.chlorophyle"/> </td>
                                <td class="bord"> <html:text property="chlorophyle_a" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.potentiel_redox"/> </td>
                                <td class="bord"> <html:text property="potentiel_redox" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.azote"/> </td>
                                <td class="bord"> <html:text property="azote_totale" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">      </td>
                                <td class="bord">  <bean:message key="crea.tubidite"/> </td>
                                <td class="bord"> <html:text property="tubidite" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.amminium"/> </td>
                                <td class="bord"> <html:text property="amminium" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.oxygene"/> </td>
                                <td class="bord"> <html:text property="oxygene_dissout" name="ppchim_trouve" size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">  </td>
                                <td class="bord">  <bean:message key="crea.fer"/> </td>
                                <td class="bord"><html:text property="fer" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.MES"/> </td>
                                <td class="bord"> <html:text property="MES" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.transparence"/> </td>
                                <td class="bord"> <html:text property="transparence" name="ppchim_trouve" size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">      </td>
                                <td class="bord">  <bean:message key="crea.codium"/> </td>
                                <td class="bord"> <html:text property="cadmium" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.hydrogene_sulfure"/> </td>
                                <td class="bord"> <html:text property="hydrogene_sulfure"  name="ppchim_trouve" size="25" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.ph"/> </td>
                                <td class="bord"> <html:text property="ph" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/> </td>
                                <td class="milieu">       </td>
                                <td class="bord">  <bean:message key="crea.plomb"/> </td>
                                <td class="bord"><html:text property="plomb" size="25" name="ppchim_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.COT"/> </td>
                                <td class="bord"> <html:text property="COT" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.temparature"/> </td>
                                <td class="bord"> <html:text property="temperature" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/> </td>
                                <td class="milieu">    </td>
                                <td class="bord">  <bean:message key="crea.selenium"/> </td>
                                <td class="bord"><html:text property="seleniuml" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.DCO"/> </td>
                                <td class="bord"> <html:text property="DCO" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.eclairage"/> </td>
                                <td class="bord">  
                                    <html:select property="ideclairage" name="ppchim_trouve" >    
                                        <html:options collection="eclai_trouve" property="ideclairage" labelProperty="designation" /> 
                                    </html:select>
                                </td>
                                <td class="milieu">    </td> 
                                <td class="bord">  <bean:message key="crea.nickel"/> </td>
                                <td class="bord"> <html:text property="nickel" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.DBO5"/> </td>
                                <td class="bord"> <html:text property="DBO5" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.salinite"/> </td>
                                <td class="bord"> <html:text property="salinite" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.arsenic"/> </td>
                                <td class="bord"> <html:text property="arsenic" size="25"  name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>
                                <td class="milieu">     </td>
                                <td class="bord">  <bean:message key="crea.manganese"/> </td>
                                <td class="bord"> <html:text property="manganese" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.conductivite"/> </td>
                                <td class="bord"><html:text property="conductivite" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                                <td class="milieu">  </td>
                                <td class="bord">  <bean:message key="crea.zinc"/> </td>
                                <td class="bord"><html:text property="zinc" size="25" name="ppchim_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>

                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.cuivre"/> </td>
                                <td class="bord"> <html:text property="cuivre" size="25" name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  />  </td>
                                <td class="milieu">   </td>
                                <td class="bord">  Mercure </td>
                                <td class="bord"><html:text property="mercure" size="25"  name="ppchim_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                            </tr>
                        </table>
                    </div>

                </fieldset>

            </div>

            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv3" />
            <br/> <br/>
            <div>
                <fieldset>
                    <legend>Cyanobacterie</legend>
                    <div id="div3">               
                        <fieldset>
                            <legend>Etude morphologique</legend>
                            <table >
                                <tr>
                                    <td>Denombrement total genre cyanobacetrie</td>
                                    <td><input type="text" size="25" id="denombCya" disabled=""/></td>
                                </tr> 
                                <tr>
                                    <td> &nbsp; </td>
                                    <td> &nbsp; </td>
                                </tr>  
                            </table>
                            <!--   <input type="button" value="Ajouter une nouvelle ligne"  id="bgrc"    />  <input type="button" value="Supprimer"  id="bgrc_s"    />  -->
                            <html:hidden property="listeGenreCyano"  styleId="listeGenreCya"  value ="" />
                            <table id="tbgrc"  >                                
                                <tr id="grc1">
                                    <td id="cpgrc">1</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy1" name="ligneGenreCyano_trouve1" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy1" name="ligneGenreCyano_trouve1"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy1" name="ligneGenreCyano_trouve1" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />     </td>
                                </tr>
                                <tr id="grc2">
                                    <td id="cpgrc">2</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy2" name="ligneGenreCyano_trouve2" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy2" name="ligneGenreCyano_trouve2"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy2" name="ligneGenreCyano_trouve2" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()"  />   </td>
                                </tr>
                                <tr id="grc3">
                                    <td id="cpgrc">3</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy3" name="ligneGenreCyano_trouve3">    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy3" name="ligneGenreCyano_trouve3"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy3" name="ligneGenreCyano_trouve3"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />   </td>
                                </tr>
                                <tr id="grc4">
                                    <td id="cpgrc">4</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy4"  name="ligneGenreCyano_trouve4" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy4"    name="ligneGenreCyano_trouve4"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy4"   name="ligneGenreCyano_trouve4" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  onfocus="sommeEspCyano()" />   </td>
                                </tr>
                                <tr id="grc5">
                                    <td id="cpgrc">5</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy5"   name="ligneGenreCyano_trouve5" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy5"    name="ligneGenreCyano_trouve5"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy5"   name="ligneGenreCyano_trouve5" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />    </td>
                                </tr>
                                <tr id="grc6">
                                    <td id="cpgrc">6</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy6"   name="ligneGenreCyano_trouve6" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy6"   name="ligneGenreCyano_trouve6"   >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy6"   name="ligneGenreCyano_trouve6" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()"  />     </td>
                                </tr>
                                <tr id="grc7">
                                    <td id="cpgrc">7</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy7"   name="ligneGenreCyano_trouve7" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy7"    name="ligneGenreCyano_trouve7"  >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy7"   name="ligneGenreCyano_trouve7" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />     </td>
                                </tr>
                                <tr id="grc8">
                                    <td id="cpgrc">8</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy8"   name="ligneGenreCyano_trouve8" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy8"   name="ligneGenreCyano_trouve8"   >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy8"   name="ligneGenreCyano_trouve8" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />     </td>
                                </tr>
                                <tr id="grc9">
                                    <td id="cpgrc">9</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy9"   name="ligneGenreCyano_trouve9" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy9"     name="ligneGenreCyano_trouve9" >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy9"   name="ligneGenreCyano_trouve9" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" onfocus="sommeEspCyano()" />     </td>
                                </tr>
                                <tr id="grc10">
                                    <td id="cpgrc">10</td>
                                    <td>/ &nbsp;</td>
                                    <td> Genre Cyano</td>
                                    <td> 
                                        <html:select property="idgenre_cyano"  styleId="sel_genre_cy10"   name="ligneGenreCyano_trouve10" >    
                                            <html:options collection="genrecya_trouve" property="idgenre_cyano" labelProperty="design_genre_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td> Espece Cyano</td>
                                    <td>   
                                        <html:select property="idespece_cyano"  styleId="sel_esp_cy10"   name="ligneGenreCyano_trouve10"   >    
                                            <html:options collection="espececya_trouve" property="idespece_cyano" labelProperty="design_espece_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="denombrement_esp_cyano" styleId="text_genre_cy10"   name="ligneGenreCyano_trouve10" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  onfocus="sommeEspCyano()" />     </td>
                                </tr>
                            </table>
                        </fieldset>
                        <fieldset>
                            <legend>Etude moleculaire</legend>
                            <table>

                                <tr>
                                    <td> &nbsp; </td>
                                    <td> &nbsp; </td>
                                </tr>  
                            </table>

                            <!--
                            <input type="button" value="Ajouter une nouvelle ligne"  id="bgnc"    /> 
                            <input type="button" value="Supprimer"  id="bgnc_s"    /> 
                            -->

                            <html:hidden property="listeGeneCyano"  styleId="listeGeneCya"  value ="" />
                            <table id="tbgnc" >
                                <tr id="gnc1">
                                    <td id="cpgnc">1</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano1" name="ligneGeneCyano_trouve1" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano1" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve1"/> 
                                </tr>  
                                <tr id="gnc2">
                                    <td id="cpgnc">2</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano2"  name="ligneGeneCyano_trouve2" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano2" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve2"/> </td>
                                </tr> 
                                <tr id="gnc3">
                                    <td id="cpgnc">3</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano3"  name="ligneGeneCyano_trouve3" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano3" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve3" /> </td>
                                </tr> 
                                <tr id="gnc4">
                                    <td id="cpgnc">4</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano4" name="ligneGeneCyano_trouve4"  >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano4" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve4" /> </td>
                                </tr> 
                                <tr id="gnc5">
                                    <td id="cpgnc">5</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano5"  name="ligneGeneCyano_trouve5" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano5" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  name="ligneGeneCyano_trouve5"/> </td>
                                </tr>
                                <tr id="gnc6">
                                    <td id="cpgnc">6</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano6" name="ligneGeneCyano_trouve6" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano6" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve6"/> 
                                </tr>  
                                <tr id="gnc7">
                                    <td id="cpgnc">7</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano7" name="ligneGeneCyano_trouve7" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano7" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve7"/> 
                                </tr>  
                                <tr id="gnc8">
                                    <td id="cpgnc">8</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano8"  name="ligneGeneCyano_trouve8">    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano8" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve8"/> 
                                </tr>  
                                <tr id="gnc9">
                                    <td id="cpgnc">9</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano9" name="ligneGeneCyano_trouve9" >    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano9" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve9"/> 
                                </tr> 
                                <tr id="gnc10">
                                    <td id="cpgnc">10</td>
                                    <td>/ &nbsp;</td>
                                    <td> Gene Cyano</td>
                                    <td> 
                                        <html:select property="idgene_cyano"  styleId="gene_cyano10"  name="ligneGeneCyano_trouve10">    
                                            <html:options collection="genecya_trouve" property="idgene_cyano" labelProperty="design_gene_cyano" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text  property="concentration_gene_cyano"  styleId="nb_gene_cyano10" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneGeneCyano_trouve10"/> 
                                </tr>  
                            </table>
                            <br/>
                            <hr/>
                            <table>

                                <tr>
                                    <td> &nbsp; </td>
                                    <td> &nbsp; </td>
                                </tr>  
                            </table>
                            <!--
                            <input type="button" value="Ajouter une nouvelle ligne"  id="btgt"    />
                            <input type="button" value="Supprimer"  id="btgt_s"    />                 
                            
                            -->
                            <table id="tbtgt"  >
                                <html:hidden property="listeTypeGeneToxicite"  styleId="listeTypeGeneTox"  value ="" /> 
                                <tr id="tgt1">
                                    <td id="cptgt">1</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite1" name="ligneTypeGeneToxi_trouve1">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite1" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve1"/> </td>
                                </tr>
                                <tr id="tgt2">
                                    <td id="cptgt">2</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite2" name="ligneTypeGeneToxi_trouve2">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite2" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve2"/> </td>
                                </tr>
                                <tr id="tgt3">
                                    <td id="cptgt">3</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite3" name="ligneTypeGeneToxi_trouve3">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite3" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve3"/> </td>
                                </tr>
                                <tr id="tgt4">
                                    <td id="cptgt">4</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite4" name="ligneTypeGeneToxi_trouve4">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite4" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve4"/> </td>
                                </tr>
                                <tr id="tgt5">
                                    <td id="cptgt">5</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite5" name="ligneTypeGeneToxi_trouve5">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite5" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve5"/> </td>
                                </tr>
                                <tr id="tgt6">
                                    <td id="cptgt">6</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite6" name="ligneTypeGeneToxi_trouve6">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite6" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve6"/> </td>
                                </tr>
                                <tr id="tgt7">
                                    <td id="cptgt">7</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite7" name="ligneTypeGeneToxi_trouve7">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite7" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve7"/> </td>
                                </tr>
                                <tr id="tgt8">
                                    <td id="cptgt">8</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite8" name="ligneTypeGeneToxi_trouve8">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite8" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve8"/> </td>
                                </tr>
                                <tr id="tgt9">
                                    <td id="cptgt">9</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite9" name="ligneTypeGeneToxi_trouve9">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite9" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve9"/> </td>
                                </tr>
                                <tr id="tgt10">
                                    <td id="cptgt">10</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de gene de toxicite</td>
                                    <td> 
                                        <html:select property="idtyp_gene_toxicite"  styleId="gene_toxicite10" name="ligneTypeGeneToxi_trouve10">    
                                            <html:options collection="typegenetox_trouve" property="idtyp_gene_toxicite" labelProperty="design_typ_gene_toxicite" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_gene_toxicite" styleId="nb_gene_toxicite10" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeGeneToxi_trouve10"/> </td>
                                </tr>
                            </table>
                        </fieldset>
                        <fieldset>
                            <legend>Etude biochimique</legend>
                            <!--
                            <input type="button" value="Ajouter une nouvelle ligne"  id="btt"    />  
                            <input type="button" value="Supprimer"  id="btt_s"    />
                            -->
                            <table id="tbtt" >
                                <html:hidden property="listeTypeToxicite"  styleId="listeTypeTox"  value ="" /> 
                                <tr id="tt1">
                                    <td id="cptt">1</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine1" name="ligneTypeTox_trouve1" >    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine1" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve1"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt2">
                                    <td id="cptt">2</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine2" name="ligneTypeTox_trouve2">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine2"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve2"/> </td>
                                    <td style="width: 100px">&nbsp; </td>

                                </tr>
                                <tr id="tt3">
                                    <td id="cptt">3</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine3" name="ligneTypeTox_trouve3">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine3" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve3"/> </td>
                                    <td style="width: 100px">&nbsp; </td>

                                </tr>
                                <tr id="tt4">
                                    <td id="cptt">4</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine4" name="ligneTypeTox_trouve4">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine4"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve4"/> </td>
                                    <td style="width: 100px">&nbsp; </td>

                                </tr>
                                <tr id="tt5">
                                    <td id="cptt">5</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine5" name="ligneTypeTox_trouve5" >    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine5" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve5"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt6">
                                    <td id="cptt">6</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine6" name="ligneTypeTox_trouve6">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine6" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve6"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt7">
                                    <td id="cptt">7</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine7" name="ligneTypeTox_trouve7">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine7" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve7"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt8">
                                    <td id="cptt">8</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine8" name="ligneTypeTox_trouve8">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine8" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve8"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt9">
                                    <td id="cptt">9</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine9"  name="ligneTypeTox_trouve9">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine9" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve9"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                                <tr id="tt10">
                                    <td id="cptt">10</td>
                                    <td>/ &nbsp;</td>
                                    <td> Type de toxicite</td>
                                    <td> 
                                        <html:select property="idtype_toxine"  styleId="type_toxine10" name="ligneTypeTox_trouve10">    
                                            <html:options collection="typetoxine_trouve" property="idtype_toxine" labelProperty="design_toxine" /> 
                                        </html:select>
                                    </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td>Denombrement </td>
                                    <td><html:text property="concentration_type_toxicite" styleId="nb_type_toxine10" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" name="ligneTypeTox_trouve10"/> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                </tr>
                            </table>
                        </fieldset>
                    </div>

                </fieldset>

            </div>

            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv4" />
            <br/> <br/>
            <div>
                <fieldset>
                    <legend>Autres bacteries</legend>
                    <div id="div4">               

                        <table>
                            <tr>
                                <td class="bord">  <bean:message key="crea.califormet"/> </td>
                                <td class="bord"> <html:text property="coliforme_tx" size="25" name="ab_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"  /> </td>
                                <td class="milieu" >    </td>

                                <td class="bord"> <bean:message key="crea.echerichiacoli"/>   </td>
                                <td class="bord">  <html:text property="e_coli" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                            </tr>
                            <tr>
                                <td class="bord">  <bean:message key="crea.califormeth"/> </td>
                                <td class="bord"> <html:text property="coliforme_thermo" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td  class="milieu">     </td>

                                <td class="bord">   <bean:message key="crea.streptocoquefecaux"/> </td>
                                <td class="bord">   <html:text property="streptocoques_fecaux" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                            </tr>
                            <tr>
                                <td class="bord"> <bean:message key="crea.anaerobisulforecl"/>  </td>
                                <td class="bord">  <html:text property="anaerobie_sulfo_red" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" /> </td>
                                <td class="milieu">   </td>

                                <td class="bord"> Autre salmonelle  </td>
                                <td class="bord"><html:text property="autre_salm" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                            </tr>
                            <tr>
                                <td class="bord">  Salmonelle </td>
                                <td class="bord"> <html:text property="salmonelle" size="25"  name="ab_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                                <td class="milieu"> </td>

                                <td class="bord"> <bean:message key="crea.srotypesalmonelle"/> </td>
                                <td class="bord"> 
                                    <html:select property="serotype_salm"   name="ab_trouve"  >    
                                        <html:option value="1">Present</html:option> 
                                        <html:option  value="0">Absent</html:option>
                                    </html:select> </td>
                            </tr>
                            <tr>
                                <td class="bord"> <bean:message key="crea.especevibrio"/> </td>
                                <td class="bord">  <html:text property="vibrio" size="25"  name="ab_trouve"   /> </td>
                                <td class="milieu">  </td>
                                <td class="bord"><bean:message key="crea.serotypevibriocholerae"/> </td>
                                <td class="bord">
                                    <html:select property="serotype_vibrio"  name="ab_trouve"   >    
                                        <html:option value="1">Present</html:option> 
                                        <html:option  value="0">Absent</html:option>
                                    </html:select> </td>
                            </tr>
                        </table>
                    </div>

                </fieldset>

            </div>

            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv5" />
            <br/> <br/>
            <div>
                <fieldset>
                    <legend>Autres algues</legend>
                    <table id="aat" >
                        <tr >
                            <td>  Denombrement </td>

                            <td> <input type="text" size="25" id="totalAlg" disabled="true"/> </td>

                        </tr>
                    </table>
                    <br/>
                    <div id="div5">   
                        <!--
                        <input type="button" value="Ajouter une nouvelle ligne"  id="baa"    />
                        <input type="button" value="Supprimer"  id="baa_s"    /> 
                        -->

                        <table>
                            <tr >
                                <td>                                                          </td>

                                <td style="text-align:center;  width: 75px  "  >  Famille     </td>              
                                <td style="text-align:center " >                              </td>
                                <td style="text-align:center ; width:350px " > Genre          </td>                                
                                <td style="text-align:center "  >                             </td>              
                                <td style="text-align:center ;  width: 280px " >              </td>
                            </tr>
                        </table>
                        <table id="tbaa"  name="tbaa" >
                            <tr id="aa1" name="aa1" >
                                <html:hidden property="algue_fam_genre1"  styleId="algue_fam_genre1" value="" />
                                <td id="cpaa">1/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg1" onchange="doAjaxPost1()" name="ligneFamille_trouve1" >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre1" name="ligne_listeGenreAlgue_trouve1"  > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa2" name="aa2" >
                                <html:hidden property="algue_fam_genre2"  styleId="algue_fam_genre2" value="" />
                                <td id="cpaa">2/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg2" onchange="doAjaxPost2()" name="ligneFamille_trouve2"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" disabled="true"  cols="30" rows="3" styleId="ta_genre2"  name="ligne_listeGenreAlgue_trouve2" > </html:textarea>  </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>

                                <tr id="aa3" name="aa3" >
                                <html:hidden property="algue_fam_genre3"  styleId="algue_fam_genre3" value="" />
                                <td id="cpaa">3/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg3" onchange="doAjaxPost3()" name="ligneFamille_trouve3"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" disabled="true" cols="30" rows="3" styleId="ta_genre3"  name="ligne_listeGenreAlgue_trouve3" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>

                                <tr id="aa4" name="aa4" >
                                <html:hidden property="algue_fam_genre4"  styleId="algue_fam_genre4" value="" />
                                <td id="cpaa">4/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg4" onchange="doAjaxPost4()"  name="ligneFamille_trouve4" >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" disabled="true" cols="30" rows="3" styleId="ta_genre4"  name="ligne_listeGenreAlgue_trouve4" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa5" name="aa5" >
                                <html:hidden property="algue_fam_genre5"  styleId="algue_fam_genre5" value="" />
                                <td id="cpaa">5/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg5" onchange="doAjaxPost5()" name="ligneFamille_trouve5"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" disabled="true" cols="30" rows="3" styleId="ta_genre5"   name="ligne_listeGenreAlgue_trouve5"> </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa6" name="aa6" >
                                <html:hidden property="algue_fam_genre6"  styleId="algue_fam_genre6" value="" />
                                <td id="cpaa">6/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg6" onchange="doAjaxPost6()" name="ligneFamille_trouve6"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre6"  name="ligne_listeGenreAlgue_trouve6" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa7" name="aa7" >
                                <html:hidden property="algue_fam_genre7"  styleId="algue_fam_genre7" value="" />
                                <td id="cpaa">7/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg7" onchange="doAjaxPost7()"  name="ligneFamille_trouve7" >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre7"  name="ligne_listeGenreAlgue_trouve7" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa8" name="aa8" >
                                <html:hidden property="algue_fam_genre8"  styleId="algue_fam_genre8" value="" />
                                <td id="cpaa">8/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg8" onchange="doAjaxPost8()" name="ligneFamille_trouve8"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre8"  name="ligne_listeGenreAlgue_trouve8" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa9" name="aa9" >
                                <html:hidden property="algue_fam_genre9"  styleId="algue_fam_genre9" value="" />
                                <td id="cpaa">9/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg9" onchange="doAjaxPost9()"  name="ligneFamille_trouve9" >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre9"  name="ligne_listeGenreAlgue_trouve9" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                                <tr id="aa10" name="aa10" >
                                <html:hidden property="algue_fam_genre10"  styleId="algue_fam_genre10" value="" />
                                <td id="cpaa">10/&nbsp; </td>


                                <td> 
                                    <html:select property="idfamille"  styleId="famalg10" onchange="doAjaxPost10()" name="ligneFamille_trouve10"  >    
                                        <html:options collection="famille_trouve" property="idfamille" labelProperty="design_famille" /> 
                                    </html:select>
                                </td>
                                <td style="width: 100px">&nbsp; </td>
                                <td><html:textarea property="genreAlgue" cols="30" rows="3" disabled="true" styleId="ta_genre10"  name="ligne_listeGenreAlgue_trouve10" > </html:textarea> </td>
                                    <td style="width: 100px">&nbsp; </td>
                                    <td></td>
                                </tr>
                            </table>
                        </div>

                    </fieldset>

                </div>
                <div >
                    <select id="genre_algue1" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre1();
                            somAutreAlg();"></select>
                    <select id="genre_algue2" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre2();
                            somAutreAlg();"></select>
                    <select id="genre_algue3" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre3();
                            somAutreAlg();"></select>
                    <select id="genre_algue4" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre4();
                            somAutreAlg();"></select>
                    <select id="genre_algue5" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre5();
                            somAutreAlg();"></select>
                    <select id="genre_algue6" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre6();
                            somAutreAlg();"></select>
                    <select id="genre_algue7" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre7();
                            somAutreAlg();"></select>
                    <select id="genre_algue8" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre8();
                            somAutreAlg();"></select>
                    <select id="genre_algue9" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre9();
                            somAutreAlg();"></select>
                    <select id="genre_algue10" multiple="true" hidden="" style="margin-left: 300px" ondblclick="dbGenre10();
                            somAutreAlg();"></select>
                </div>
                <br/>
                <hr/>
                <br/>
                <input type="button" value="-"  id="bdiv6" />
                <br/> <br/>
                <div>
                    <fieldset>
                        <legend>Virus</legend>
                        <div id="div6">               
                            <table>
                                <tr>
                                    <td class="bord">   Virus </td>
                                    <td class="bord"> 
                                    <html:select property="enterovirus" name="virus_trouve">    
                                        <html:option value="1">Vrai</html:option> 
                                        <html:option  value="0">Faux</html:option>
                                    </html:select>
                                </td>
                            </tr>

                        </table>
                    </div>

                </fieldset>

            </div>
            <br/>
            <hr/>
            <br/>
            <input type="button" value="-"  id="bdiv7" />
            <br/> <br/>
            <div>
                <fieldset>
                    <legend>Parasites</legend>
                    <div id="div7">               
                        <table>
                            <tr> 
                                <td class="bord">  <bean:message key="crea.cryptosoridium"/> </td>
                                <td class="bord"> <html:text property="cryptosporidium" size="25" name="para_trouve"  onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);"/>  </td>
                            </tr>
                            <tr> 
                                <td class="bord">  <bean:message key="crea.giardia"/> </td>
                                <td class="bord"> <html:text property="giardia" size="25"  name="para_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />   </td>
                            </tr>
                            <tr> 
                                <td class="bord">  <bean:message key="crea.helminthe"/> </td>
                                <td class="bord"> <html:text property="helminthe" size="25"  name="para_trouve" onchange="PerdFocus(this)" onblur="Chiffres(this);verif(this);" />  </td>
                            </tr>

                        </table>
                    </div>

                </fieldset>

            </div>

        </table>
        <table class="pied">
            <tr>
                <td   class="bord">  <html:submit value="Sauvegarder" onclick="disableBeforeUnload()" styleId="buttonVal" onfocus="selectGenreCyano();selectGeneCyano();selectTypeGeneToxicite();selectTypeToxine();selectAutreAlgue();"/> <td/>

                <td   class="bord">    <html:link  action="pagecreation.do" styleClass="lienBtn" title="aller à la page precedante"  > Annuler </html:link></td>
                </tr>
            </table> 
    </html:form>
    <%@include file="piedpage.jsp" %>

</body>

</html>
