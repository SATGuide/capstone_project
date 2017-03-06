/**
 * Created by jefferysmith on 3/6/17.
 */

(function() {
    'use strict';

    var marker;
    var latVar = 29.426791;
    var lngVar = -98.489602;

    function initMap() {
        var map = new google.maps.Map(document.getElementById('map-canvas2'), {
            zoom: 10,
            center: {lat:latVar, lng:lngVar}
        });

        marker = new google.maps.Marker({
            map: map,
            draggable: true,
            animation: google.maps.Animation.DROP,
            position: {lat:latVar, lng:lngVar}
        });
    }


    initMap();
    google.maps.event.addListener(marker, 'dragend', function(event) {
        document.getElementById("latbox").value = this.getPosition().lat();//getPosition is a function in Google API that captures the location of the marker
        document.getElementById("lngbox").value = this.getPosition().lng();
        latVar = latbox.value;
        lngVar = lngbox.value;

    });


})();





