/**
 * Created by jefferysmith on 3/2/17.
 */
// #to-top button appears after scrolling
(function() {
    'use strict';

    // Used to format phone number

        $('.phoneFormat').on('input', function() {
            var number = $(this).val().replace(/[^\d]/g, '');
            if (number.length == 7) {
                number = number.replace(/(\d{3})(\d{4})/, "$1-$2");
            } else if (number.length == 10) {
                number = number.replace(/(\d{3})(\d{3})(\d{4})/, "($1) $2-$3");
            }
            $(this).val(number);
        });

    $(".phoneText").text(function(i, text) {
        text = text.replace(/(\d{3})(\d{3})(\d{4})/, "($1) $2-$3");
        return text;
    });

})();