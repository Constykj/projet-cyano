<%-- 
    Document   : popup_genre_algue
    Created on : Nov 10, 2014, 10:38:42 AM
    Author     : HP USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="lib-jquery/prototype.js"></script>

        <script type="text/javascript">

            function doAjaxPost() {
                var val = getParamValue('idfamille')
                var url = "/Cyano1/datafamillealgue.do";
                new Ajax.Request(url, {
                    parameters: {idfamille: val},
                    onSuccess: function (transport, json) {
                        if (json.error) {
                            alert(json.error);
                        }
                        else {

                            var data = Object.keys(json).length;


                            for (int i = 0; i < data; i++) {
                                var selectElmt = document.getElementById("famalg");
                                var valeurselectionnee = selectElmt.options[selectElmt.selectedIndex].value;
                            }







                        }
                    }
                });
            }

            function getParamValue(param, url)
            {
                var u = url == undefined ? document.location.href : url;
                var reg = new RegExp('(\\?|&|^)' + param + '=(.*?)(&|$)');
                matches = u.match(reg);
                return matches[2] != undefined ? decodeURIComponent(matches[2]).replace(/\+/g, ' ') : '';
            }
        </script>
    </head>
    <body onload="doAjaxPost()">
        <p>
            Genre Algue
        </p>
        <div>
            <form name="fom1">
                <select id="select1" name="select1"  >
                    <option> --- </option>

                </select>
            </form>


        </div>


    </body>
</html>
