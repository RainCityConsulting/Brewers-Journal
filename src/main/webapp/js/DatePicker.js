var com;
if (!com) com = {};
if (!com.rcc) com.rcc = {};
if (!com.rcc.datepicker) com.rcc.datepicker = {};

com.rcc.datepicker.init = function() {
  $('input.datepicker').each(function(i) {
    $(this).datepicker(
        {
          dateFormat: 'M d, yy',
          changeMonth: true,
          changeYear: true,
        }
    );
  });
}

$(document).ready(function() { com.rcc.datepicker.init(); });
