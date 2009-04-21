var com;
if (!com) com = {};
if (!com.rcc) com.rcc = {};
if (!com.rcc.tab) com.rcc.tab = {};
if (!com.rcc.tab.menu) com.rcc.tab.menu = {};
  
com.rcc.tab.menu.init = function(e) {
  $('div.tab-menu > ul > li > a').each(function(i) {
    var contentId = this.getAttribute('content-id');
    var isActive = $(this).hasClass('active');

    if (isActive) {
      com.rcc.tab.menu.activeMenu = $(this);
    }

    if (contentId != null) {
      if (isActive) {
        com.rcc.tab.menu.activeContent = $('#'+contentId);
        com.rcc.tab.menu.activeContent.show();
      }

      $(this).click(function() {
        com.rcc.tab.menu.activeContent.hide();
        com.rcc.tab.menu.activeMenu.removeClass('active');
  
        com.rcc.tab.menu.activeContent = $('#'+contentId);
        com.rcc.tab.menu.activeMenu = $(this);
        com.rcc.tab.menu.activeContent.show();
        com.rcc.tab.menu.activeMenu.addClass('active');
      });
    }
  });
}
  
$(document).ready(function() { com.rcc.tab.menu.init(); });
