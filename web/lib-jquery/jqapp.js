/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {


//    $("input, textarea, select").on("input change", function () {
//        window.onbeforeunload = window.onbeforeunload || function (e) {
//            return "You have unsaved changes.  Do you want to leave this page and lose your changes?";
//        };
//    });
//    $("form").on("submit", function () {
//        window.onbeforeunload = null;
//    });


    $('#bp').on('click', function () {

        if ($('#bp').val() === "+") {
            $('#tb2').show();
            $('#aj').show();
            $('#bp').val("-");
        }
        else {
            $('#tb2').hide();
            $('#aj').hide();
            $('#bp').val("+");
        }
    });

    $('#bdiv1').on('click', function () {

        if ($('#bdiv1').val() === "+") {
            $('#div1').show();
            $('#bdiv1').val("-");
        }
        else {
            $('#div1').hide();
            $('#bdiv1').val("+");
        }
    });

    $('#bdiv2').on('click', function () {

        if ($('#bdiv2').val() === "+") {
            $('#div2').show();
            $('#bdiv2').val("-");
        }
        else {
            $('#div2').hide();
            $('#bdiv2').val("+");
        }
    });

    $('#bdiv3').on('click', function () {

        if ($('#bdiv3').val() === "+") {
            $('#div3').show();
            $('#bdiv3').val("-");
        }
        else {
            $('#div3').hide();
            $('#bdiv3').val("+");
        }
    });
    $('#bdiv4').on('click', function () {

        if ($('#bdiv4').val() === "+") {
            $('#div4').show();
            $('#bdiv4').val("-");
        }
        else {
            $('#div4').hide();
            $('#bdiv4').val("+");
        }
    });
    $('#bdiv5').on('click', function () {

        if ($('#bdiv5').val() === "+") {
            $('#div5').show();
            $('#bdiv5').val("-");
        }
        else {
            $('#div5').hide();
            $('#bdiv5').val("+");
        }
    });
    $('#bdiv6').on('click', function () {

        if ($('#bdiv6').val() === "+") {
            $('#div6').show();
            $('#bdiv6').val("-");
        }
        else {
            $('#div6').hide();
            $('#bdiv6').val("+");
        }
    });
    $('#bdiv7').on('click', function () {

        if ($('#bdiv7').val() === "+") {
            $('#div7').show();
            $('#bdiv7').val("-");
        }
        else {
            $('#div7').hide();
            $('#bdiv7').val("+");
        }
    });

    $('#bdivt').on('click', function () {

        if ($('#bdivt').val() === "+ +") {
            $('#div1').show();
            $('#div2').show();
            $('#div3').show();
            $('#div4').show();
            $('#div5').show();
            $('#div6').show();
            $('#div7').show();
            $('#bdivt').val("- -");
        }
        else {
            $('#div7').hide();
            $('#div1').hide();
            $('#div2').hide();
            $('#div3').hide();
            $('#div4').hide();
            $('#div5').hide();
            $('#div6').hide();
            $('#bdivt').val("+ +");
        }
    });

//  $('#tr1').clone().insertAfter('#tb2 tr');

//    $('#bgrc').on('click', function () {
//
//        if ($('#tbgrc').is(':hidden')) {
//            $('#tbgrc').show();
//        } else {
//            var $tr = $('tr[id^="grc"]:last');
//            var id = +$tr[0].id.match(/\d+/g) + 1;
//            $tr.after($tr.clone().attr('id', 'grc' + id));
//            $('td[id="cpgrc"]:last').html(id);
//            $('td[id^="sel_genre_cy"]:last').attr('id', 'sel_genre_cy' + id);
//            $('td[id^="sel_esp_cy"]:last').attr('id', 'sel_genre_cy' + id);
//            $('td[id^="text_genre_cy"]:last').attr('id', 'sel_genre_cy' + id);
//        }
//
//    });
//
//    $('#bgrc_s').on('click', function () {
//
//        if ($('#tbgrc').is(':hidden')) {
//        } else if ($('td[id="cpgrc"]:last').html() === '1') {
//            $('#tbgrc').hide()();
//        } else {
//            $('tr[id^="grc"]:last').remove();
//
//        }
//
//    });
//
//    $('#bgnc').on('click', function () {
//        if ($('#tbgnc').is(':hidden')) {
//            $('#tbgnc').show();
//        } else {
//            var $tr = $('tr[id^="gnc"]:last');
//            var id = +$tr[0].id.match(/\d+/g) + 1;
//            $tr.after($tr.clone().attr('id', 'gnc' + id));
//            $('td[id="cpgnc"]:last').html(id);
//        }
//
//    });
//
//    $('#bgnc_s').on('click', function () {
//
//        if ($('#tbgnc').is(':hidden')) {
//
//        } else if ($('td[id="cpgnc"]:last').html() === '1') {
//            $('#tbgnc').hide()();
//        } else {
//            $('tr[id^="gnc"]:last').remove();
//
//        }
//
//    });
//
//
//    $('#btgt').on('click', function () {
//        if ($('#tbtgt').is(':hidden')) {
//            $('#tbtgt').show();
//        } else {
//            var $tr = $('tr[id^="tgt"]:last');
//            var id = +$tr[0].id.match(/\d+/g) + 1;
//            $tr.after($tr.clone().attr('id', 'tgt' + id));
//            $('td[id="cptgt"]:last').html(id);
//        }
//    });
//    $('#btgt_s').on('click', function () {
//
//        if ($('#tbtgt').is(':hidden')) {
//
//        } else if ($('td[id="cptgt"]:last').html() === '1') {
//            $('#tbtgt').hide()();
//        } else {
//            $('tr[id^="tgt"]:last').remove();
//
//        }
//
//    });
//
//    $('#btt').on('click', function () {
//        if ($('#tbtt').is(':hidden')) {
//            $('#tbtt').show();
//        } else {
//            var $tr = $('tr[id^="tt"]:last');
//            var id = +$tr[0].id.match(/\d+/g) + 1;
//            $tr.after($tr.clone().attr('id', 'tt' + id));
//            $('td[id="cptt"]:last').html(id);
//        }
//    });
//
//    $('#btt_s').on('click', function () {
//
//        if ($('#tbtt').is(':hidden')) {
//
//        } else if ($('td[id="cptt"]:last').html() === '1') {
//            $('#tbtt').hide()();
//        } else {
//            $('tr[id^="tt"]:last').remove();
//
//        }
//
//    });

//    $('#map1').gMap({markers: [{
//                latitude: $('#lat1').val(),
//                longitude: $('#long1').val(),
//                html: $("#pe option:selected").text(),
//                popup: true}],
//        maptype: G_SATELLITE_MAP,
//        zoom: 10
//    });
//    $('#stp11').click(function () {
//        $('#mapcreationst').gMap({markers: [{
//                    latitude: $('#gps_lat').val(),
//                    longitude: $('#gps_long').val(),
//                    html: $("#pe option:selected").text(),
//                    popup: true}],
//            maptype: G_SATELLITE_MAP,
//            zoom: 10
//        });
//
//    });
//
//
//    $('#mcb').on('click', function () {
//        $('#map11').gMap({markers: [{
//                    latitude: $('#lat2').text(),
//                    longitude: $('#long2').text(),
//                    html: $('#pleau').text(),
//                    popup: true}],
//            maptype: G_SATELLITE_MAP,
//            zoom: 10
//        });
//    });
//
//
//
//
//    $('#pp').click(function () {
//
//        $('#mapcrea').gMap({markers: [{
//                    latitude: $('#sp_gps_lat').val(),
//                    longitude: $('#sp_gps_long').val(),
//                    html: $('#sp_designation').val(),
//                    popup: true}],
//            maptype: G_SATELLITE_MAP,
//            zoom: 10
//        });
//    });
//
//
//    $('#mapcrea1').gMap({markers: [{
//                latitude: $('#sp_gps_lat1').val(),
//                longitude: $('#sp_gps_long1').val(),
//                html: $('#sp_designation1').val(),
//                popup: true}],
//        maptype: G_SATELLITE_MAP,
//        zoom: 10
//    });
//

    $('tr.av:odd').css('background', '#FFFFAA');
    $('thead').css('background', '#ABC6EC');

    //met le champ denombrement a vide dans etude morphologique
    //$('input[id^="text_genre_cy"]').val("");

    /////
//
//    $('#clonetrigger').click(function () {
//        var yourclass = ".clonable";  //The class you have used in your form
//        var clonecount = $(yourclass).length;	//how many clones do we already have?
//        var newid = Number(clonecount) + 1;		//Id of the new clone   
//
//        $(yourclass + ":first").fieldclone({//Clone the original elelement
//            newid_: newid, //Id of the new clone, (you can pass your own if you want)
//            target_: $("#formbuttons"), //where do we insert the clone? (target element)
//            insert_: "before", //where do we insert the clone? (after/before/append/prepend...)
//            limit_: 4							//Maximum Number of Clones
//        });
//        return false;
//    });
//

    /////




//    $('#baa').on('click', function () {
//        if ($('#tbaa').is(':hidden')) {
//            $('#tbaa').show();
//        } else {
//            var $tr = $('tr[id^="aa"]:last');
//            var id = +$tr[0].id.match(/\d+/g) + 1;
//            $tr.after($tr.clone().attr('id', 'aa' + id));
//            $('td[id="cpaa"]:last').html(id);
//        }
//
//    });
//
//    $('#baa_s').on('click', function () {
//
//        if ($('#tbaa').is(':hidden')) {
//
//        } else if ($('td[id="cpaa"]:last').html() === '1') {
//            $('#tbaa').hide()();
//        } else {
//            $('tr[id^="aa"]:last').remove();
//
//        }
//
//    });



});

//The Plugin Script
////(function ($) {
////
////    $.fn.fieldclone = function (options) {
////
////        //==> Options <==//
////        var settings = {
////            newid_: 0,
////            target_: $(this),
////            insert_: "before",
////            limit_: 0
////        };
////        if (options)
////            $.extend(settings, options);
////
////        if ((settings.newid_ <= (settings.limit_ + 1)) || (settings.limit_ == 0)) {	//Check the limit to see if we can clone
////
////            //==> Clone <==//
////            var fieldclone = $(this).clone();
////            var node = $(this)[0].nodeNames;
////            var classes = $(this).attr("class");
////
////            //==> Increment every input id <==//
////            var srcid = 1;
////            $(fieldclone).find(':input').each(function () {
////                var s = $(this).attr("id");
////                $(this).attr("id", s.replace(eval('/_' + srcid + '/ig'), '_' + settings.newid_));
////            });
////
////            var srcid1 = 1;
////            $(fieldclone).find(':select').each(function () {
////                var s = $(this).attr("id");
////                $(this).attr("id", s.replace(eval('/_' + srcid1 + '/ig'), '_' + settings.newid_));
////            });
////
////            //==> Locate Target Id <==//
////            var targetid = $(settings.target_).attr("id");
////            if (targetid.length <= 0) {
////                targetid = "clonetarget";
////                $(settings.target_).attr("id", targetid);
////            }
////
////            //==> Insert Clone <==//
////            var newhtml = $(fieldclone).html().replace(/\n/gi, "");
////            newhtml = '<' + node + ' id="' + classes + '">' + newhtml + '</' + node + '>';
////
////            eval("var insertCall = $('#" + targetid + "')." + settings.insert_ + "(newhtml)");
////        }
////    };
//
//})(jQuery);    