/**
 * Created by jefferysmith on 2/16/17.
 */
(function() {
    'use strict';

    // Closes right sidebar menu
    $('#menu-close').click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Closes left sidebar menu
    $('#left-menu-close').click(function(e) {
        e.preventDefault();
        $("#left-sidebar-wrapper").toggleClass("active");
        $('#menu-toggle').show();
    });

    // Opens the right sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Opens left sidebar menu
    $(".left-menu-toggle").click(function(e) {
        e.preventDefault();
        $("#left-sidebar-wrapper").toggleClass("active");
        $('#menu-toggle').hide();
    });

    // Scrolls to the selected menu item on the page
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });

// ============================================
// #to-top button appears after scrolling

var fixed = false;
$(document).scroll(function() {
    if ($(this).scrollTop() > 250) {
        if (!fixed) {
            fixed = true;
            // $('#to-top').css({position:'fixed', display:'block'});
            $('#to-top').show("slow", function() {
                $('#to-top').css({
                    position: 'fixed',
                    display: 'block'
                });
            });
        }
    } else {
        if (fixed) {
            fixed = false;
            $('#to-top').hide("slow", function() {
                $('#to-top').css({
                    display: 'none'
                });
            });
        }
    }
});

//======================================================================================================================
    var json = [{
        title: "Concordia University",
        lat: 29.5186176,
        lng: -98.4532861,
        type:'bar'

    },{
        title: "Northeast Lakeview College",
        lat: 29.5462766,
        lng:-98.3226664,
        type:'park'

    },{
        title: "Northwest Vista College",
        lat: 29.4721536,
        lng:-98.7067569,
        type:'dining'
    }];


    var mapOptions = {
        // Set the zoom level
        zoom: 10,

        // This sets the center of the map at our location
        center: {
            lat:  29.426791,
            lng: -98.489602
        }
    };

    // Render the map
    var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

    //Icon Repositories
    var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
    var pushPin = 'https://maps.google.com/mapfiles/kml/pushpin/';

    var icons = {
        dining: {
            icon: iconBase + 'dining.png'
        },
        park: {
            icon: iconBase + 'parks.png'
        },
        bar: {
            icon: iconBase + 'bars.png'
        }
    };

    // Add markers to map
    for (var i = 0, length = json.length; i < length; i++) {

        var data = json[i],
            latLng = new google.maps.LatLng(data.lat, data.lng);


        // Creating an icon and putting it on the map
        var marker = new google.maps.Marker({
            position: latLng,
            icon: icons[json[i].type].icon,
            map: map
        });

    }


// Disable Google Maps scrolling
// See http://stackoverflow.com/a/25904582/1607849
// Disable scroll zooming and bind back the click event
var onMapMouseleaveHandler = function(event) {
    var that = $(this);
    that.on('click', onMapClickHandler);
    that.off('mouseleave', onMapMouseleaveHandler);
    that.find('map-canvas').css("pointer-events", "none");
}

var onMapClickHandler = function(event) {
    var that = $(this);
    // Disable the click handler until the user leaves the map area
    that.off('click', onMapClickHandler);
    // Enable scrolling zoom
    that.find('map-canvas').css("pointer-events", "auto");
    // Handle the mouse leave event
    that.on('mouseleave', onMapMouseleaveHandler);
}

// Enable map zooming with mouse scroll when the user clicks the map
$('.map').on('click', onMapClickHandler);

//======================================================================================================================


})();