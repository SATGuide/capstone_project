/**
 * Created by jefferysmith on 3/6/17.
 */
/**
 * Created by jefferysmith on 3/6/17.
 */

(function() {
    'use strict';

    var marker;
    var latVar = document.getElementById('latbox');
    var lngVar = document.getElementById('lngbox');

    $(document).ready(function(){



        var map = new google.maps.Map(document.getElementById('map-canvas3'), {
            zoom: 10,
            center: {lat:parseFloat(latVar.value), lng:parseFloat(lngVar.value)}
        });

        marker = new google.maps.Marker({
            map: map,
            draggable: true,
            animation: google.maps.Animation.DROP,
            position: {lat:parseFloat(latVar.value), lng:parseFloat(lngVar.value)}
        });

        google.maps.event.addListener(marker, 'dragend', function() {
            document.getElementById("latbox").value = this.getPosition().lat();//getPosition is a function in Google API that captures the location of the marker
            document.getElementById("lngbox").value = this.getPosition().lng();
            latVar = latbox.value;
            lngVar = lngbox.value;

        });
    });




})();





