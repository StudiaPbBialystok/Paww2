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
    $('.attractionButton').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'attractions/' + $(this).attr('value'));
    });
    
     $('.joinButton').click(function () {
        window.location.href = (/Zadanie6_projekt/ + 'join/');
    });

})();

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

$('#formlogin input[type="submit"]').on("click", function () {

    var email = $('input:first').val();
    var password = $('input#passwordInput').val();
    if ($.trim(email.length) == 0) {
        alert("wpisz email");
        return false;
    }

    if ($.trim(password.length) == 0) {
        alert("wpisz haslo");
        return false;
    }

    $.ajax({
        type: "POST",
        url: "/Zadanie6_projekt/index",
        data: "email=" + email + "&password=" + password,
        success: function () {
            window.location.href = (/Zadanie6_projekt/ + 'about/');

        }, error: function () {
            $(".return").html("Błędny login lub hasło").show();
        }

    });
    return false;

});

//$('#formjoin input[type="submit"]').on("click", function () {
//    var email = $('input#emailInput').val();
//    $.ajax({
//        type: "POST",
//        url: "/Zadanie6_projekt/new",
//        data: "email=" + email,
//        success: function () {
//            window.location.href = (/Zadanie6_projekt/);
//
//        }, error: function () {
//            $(".return").html("Email already exists").show();
//        }
//
//    });
//    return false;
//
//});


$('button').mouseover(function () {
    $(this).css('background-color', '#17c');
}).mouseleave(function () {
    $(this).css('background-color', '#28d');
});

$('table').tablesorter({
    // sort on the first column and third column, order asc 
    sortList: [[0, 0], [2, 0]]
}); 