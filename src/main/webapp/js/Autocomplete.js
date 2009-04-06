var com = {};
if (!com.rcc) com.rcc = {};
if (!com.rcc.brew) com.rcc.brew = {};
if (!com.rcc.brew.ac) com.rcc.brew.ac = {};

com.rcc.brew.ac.init = function(e) {

  // GRAIN

  $('input.grain_autocomplete').each(function(i) {
    alert("Grain AC");
    $(this).autocomplete("@base.url@/ac/grain.s",
        {
          formatItem: function(row, idx, count, query) {
            var grain = eval("(" + row[0] + ")");
            var ret = '<div>' + grain.name + '</div>';

            if (grain.mfg) {
              ret += '<div><i>' + grain.mfg.name + '</i></div>';
            }

            return ret;
          },

          formatResult: function(row, idx, count) {
            var grain = eval("(" + row[0] + ")");
            if (grain.mfg) {
              return grain.name + " " + grain.mfg.name + " [id: " + grain.id + "]";
            }
            return grain.name + " [id: " + grain.id + "]";
          }
      }
    );
  });


  // HOPS

  $('input.hops_autocomplete').each(function(i) {
    alert('Hops AC');
    $(this).autocomplete("@base.url@/ac/hops.s",
        {
          formatItem: function(row, idx, count, query) {
            var hops = eval("(" + row[0] + ")");
            var ret = '<div>' + hops.name + '</div>';

            if (hops.mfg) {
              ret += '<div><i>' + hops.mfg.name + '</i></div>';
            }

            return ret;
          },

          formatResult: function(row, idx, count) {
            var hops = eval("(" + row[0] + ")");
            if (hops.mfg) {
              return hops.name + " " + hops.mfg.name + " [id: " + hops.id + "]";
            }
            return hops.name + " [id: " + hops.id + "]";
          }
      }
    );
  });

}

$(document).ready(function() { com.rcc.brew.ac.init(); });
