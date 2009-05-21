var com;
if (!com) com = {};
if (!com.rcc) com.rcc = {};
if (!com.rcc.brew) com.rcc.brew = {};
if (!com.rcc.brew.note) com.rcc.brew.note = {};

com.rcc.brew.note.init = function(e) {

  $('div.notes').each(function(i) {
    $(this).click(function() {
      $(this).toggleClass('notes-closed');
      $(this).toggleClass('notes-open');
    });
  });

}

$(document).ready(function() { com.rcc.brew.note.init(); });
