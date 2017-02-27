/**
 * Created by jefferysmith on 2/16/17.
 */
(function() {
    'use strict';

    var category;
    var categoryTitle = '';
    var markers = [];

    var mapOptions = {
        // Set the zoom level
        zoom: 10,

        // This sets the center of the map at our location
        center: {
            lat:  29.426791,
            lng: -98.489602
        }
    };

//========= Menus  ============================================================================================

    // Closes right sidebar menu
    $('#menu-close').click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    // Closes left sidebar menu
    $('#left-menu-close').click(function(e) {
        e.preventDefault();
        $("#left-sidebar-wrapper").toggleClass("active");

        // show right menu button
        $('#menu-toggle').show();
        deleteMarkers();
    });

    // Opens the right sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });

    //==== Right side menu listeners =====================================================================

    $("#local").click(function(e) {
        e.preventDefault();
        category = 1;
        categoryTitle = "Local Cuisine"
    });
    $("#chain").click(function(e) {
        e.preventDefault();
        category = 2;
        categoryTitle = "Popular Favorites"
    });
    $("#attractions").click(function(e) {
        e.preventDefault();
        category = 3;
        categoryTitle = "Attractions"
    });
    $("#shopping").click(function(e) {
        e.preventDefault();
        category = 4;
        categoryTitle = "Shopping"
    });
    $("#golf").click(function(e) {
        e.preventDefault();
        category = 5;
        categoryTitle = "Golf"
    });
    $("#parks").click(function(e) {
        e.preventDefault();
        category = 6;
        categoryTitle = "Parks"
    });
    $("#culture-arts").click(function(e) {
        e.preventDefault();
        category = 7;
        categoryTitle = "Cultural / Arts"
    });
    $("#medical").click(function(e) {
        e.preventDefault();
        category = 8;
        categoryTitle = "Medical"
    });
    $("#gov-mil").click(function(e) {
        e.preventDefault();
        category = 9;
        categoryTitle = "Gov / Military"
    });
    $("#colleges").click(function(e) {
        e.preventDefault();
        category = 10;
        categoryTitle = "Colleges"
    });
    $("#bars").click(function(e) {
        e.preventDefault();
        category = 11;
        categoryTitle = "Bars/Clubs"
    });

    //====================================================================================================



    // Render the map
    var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

    // Opens left sidebar menu
    $(".left-menu-toggle").click(function(e) {
        e.preventDefault();
        var dynamicList = "";
        var itemNumber = 0;

        // show left menu
        $("#left-sidebar-wrapper").toggleClass("active");

        // show selected Category on top of menu
        $('#categoryTitle').html(categoryTitle);

        // hide right menu button to prevent overlapping menu
        $('#menu-toggle').hide();

        var request = $.getJSON('/javaScript/test.json');

        request.done(function (json) {

            $.each(json, function(i,data){

                if(category == data.category){

                    itemNumber+= 1;

                    var location = new google.maps.LatLng(data.lat, data.lng);
                    // Adds a marker to the map and push to the array.
                    var marker = new MarkerWithLabel({
                        position: location,
                        map: map,
                        labelContent: itemNumber,
                        labelAnchor: new google.maps.Point(15, 35),
                        labelClass: "labels", // the CSS class for the label
                        labelInBackground: false,
                        icon: pinSymbol('red')
                    });

                    dynamicList += ("<li style='color:whitesmoke'>" + itemNumber + ")  " + data.bus_name +  "</li>");

                    markers.push(marker);
                }
            });
            $("#dynamicList").html(dynamicList);
        });
        setMapOnAll(markers)
    });

    function pinSymbol(color) {
        return {
            path: 'M 0,0 C -2,-20 -10,-22 -10,-30 A 10,10 0 1,1 10,-30 C 10,-22 2,-20 0,0 z',
            fillColor: color,
            fillOpacity: 1,
            strokeColor: '#000',
            strokeWeight: 2
        };
    }

    // Sets the map on all markers in the array.
    function setMapOnAll(map) {
        for (var i = 0; i < markers.length; i++) {
            markers[i].setMap(map);
        }
    }

    // Removes the markers from the map, but keeps them in the array.
    function clearMarkers() {
        setMapOnAll(null);
    }

    // Shows any markers currently in the array.
    function showMarkers() {
        setMapOnAll(map);
    }

    // Deletes all markers in the array by removing references to them.
    function deleteMarkers() {
        clearMarkers();
        markers = [];
    }


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

})();