// site.js


(function () {
    
    
    $('.editBtn').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'edit/' + $(this).attr('value'));
    });

    $('.deleteTripBtn').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'delete/' + $(this).attr('value'));
    });

    $('.stopsBtn').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'stops/' + $(this).attr('value'));
    });

    $('.deleteStopBtn').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'stops/delete/' + $(this).attr('itemid') + "/"
                + $(this).attr('value'));
    });
    $('#attractionButton').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'attractions/' + $(this).attr('value'));
    });

    var $sidebarAndWrapper = $("#sidebar,#wrapper");
    var $icon = $("#sidebarToggle i.fa");
    $("#sidebarToggle").on("click", function () {
        $sidebarAndWrapper.toggleClass("hide-sidebar");
        if ($sidebarAndWrapper.hasClass("hide-sidebar")) {
            $icon.removeClass("fa-angle-left");
            $icon.addClass("fa-angle-right");
        } else {
            $icon.addClass("fa-angle-left");
            $icon.removeClass("fa-angle-right");
        }
    });
})();

function initMap() {

    $('.tripmap').click(function () {
        var szr = parseFloat($(this).attr('a'));
        var dl = parseFloat($(this).attr('b'));
        var mapDiv = document.getElementById('map');
        console.log(szr + " " + dl);
        var map = new google.maps.Map(mapDiv, {
            center: {lat: szr, lng: dl},
            zoom: 8
        });
    });

    var mapDiv = document.getElementById('mapa');
    var map = new google.maps.Map(mapDiv, {
        center: {lat: 44.540, lng: -78.546},
        zoom: 8
    });

}
;


