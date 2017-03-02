/**
 * Created by jefferysmith on 2/16/17.
 */
(function() {
    'use strict';

//========= Menus  ============================================================================================

    // Closes right sidebar menu
    $('#menu-close').click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
        // $("#left-menu-toggle").removeClass("hidden");

    });

    // Opens the right sidebar menu
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
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

    $("#phone").inputmask({"mask": "(999) 999-9999"});

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
                    // Delete map markers if present
                    // show right menu button
                    $('#menu-toggle').show();
                    // close left menu if open
                    $("#left-sidebar-wrapper").removeClass("active");
                    // Scroll to top of page and hide top button
                    $('#to-top').css({
                        display: 'none'
                    });


                });
            }
        }
    });
})();
