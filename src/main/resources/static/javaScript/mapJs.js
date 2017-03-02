/**
 * Created by jefferysmith on 3/2/17.
 */
(function() {
    'use strict';

    //==== Right side menu listeners =====================================================================

    var category;
    var categoryTitle = '';

    $(".local").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 1;
        categoryTitle = "Local Cuisine";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });
    $(".chain").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 2;
        categoryTitle = "Popular Favorites";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".attractions").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 3;
        categoryTitle = "Attractions";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".shopping").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 4;
        categoryTitle = "Shopping";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".golf").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 5;
        categoryTitle = "Golf";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".parks").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 6;
        categoryTitle = "Parks";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".culture-arts").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 7;
        categoryTitle = "Cultural / Arts";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".medical").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 8;
        categoryTitle = "Medical";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".gov-mil").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 9;
        categoryTitle = "Gov / Military";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".colleges").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 10;
        categoryTitle = "Colleges";
        setTimeout(function(){
            openLeftMenu();
        }, 500);
    });

    $(".bars").click(function(e) {
        e.preventDefault();
        closeLeftMenu();
        category = 11;
        categoryTitle = "Bars/Clubs";
        setTimeout(function(){
            openLeftMenu();
        }, 500);

    });

    // Listener to close left menu
    $('#left-menu-close').click(function(e) {
        e.preventDefault();
        $("#left-sidebar-wrapper").toggleClass("active");
        $("#left-menu-toggle").removeClass('hidden');
    });

    $('#left-menu-toggle').click(function (e) {
        e.preventDefault();
        $("#left-sidebar-wrapper").toggleClass("active");
    });



    //=======Google Map API=============================================================================================

    var markers = [];

    var mapOptions = {
        // Set the zoom level
        zoom: 10,

        // This sets the center of the map at our location
        center: {
            lat:  29.426791,
            lng: -98.489602
        },

        scrollwheel:false
    };

    var minZoomLevel = 9;

    // Render the map
    var map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);

    // Bounds for San Antonio Area
    var strictBounds = new google.maps.LatLngBounds(
        // Lytle, Texas
        new google.maps.LatLng(29.2333, -98.7964),
        // Macdoma, Texas
        new google.maps.LatLng(29.3258, -98.6911));


    // Limit the zoom level
    google.maps.event.addListener(map, 'zoom_changed', function () {
        if (map.getZoom() < minZoomLevel) map.setZoom(minZoomLevel);
    });

    function tuckMenu(){
        $("#left-sidebar-wrapper").toggleClass("active");
    }

    function openLeftMenu() {

        $("#sidebar-wrapper").removeClass("active");
        // show left menu
        $("#left-sidebar-wrapper").addClass("active");

        // show selected Category on top of menu
        $('#categoryTitle').html(categoryTitle);

        loadMapDetail();
    }

    // Closes left sidebar menu
    function closeLeftMenu() {

        $("#left-sidebar-wrapper").removeClass("active");

        // show right menu button
        $('#menu-toggle').show();
        deleteMarkers();

    }

    function loadMapDetail() {
        var dynamicList = "";
        var itemNumber = 0;
        var request = $.getJSON('/merchants/'+ category +'/list.json');

        request.done(function (json) {

            $.each(json, function(i,data){

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

                dynamicList += ("<a href='"+ data.web + "' target='_blank'><li style='color:whitesmoke'>" + itemNumber + ")  " + data.busName +  "</li></a> ");

                markers.push(marker);
            });
            $("#dynamicList").html(dynamicList);
        });
        setMapOnAll(markers)
    }

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



})();