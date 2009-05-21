var com;
if (!com) com = {};
if (!com.rcc) com.rcc = {};
if (!com.rcc.brew) com.rcc.brew = {};
if (!com.rcc.brew.ac) com.rcc.brew.ac = {};

com.rcc.brew.ac.init = function(e) {

  // ADJUNCT

  $('input.adjunct_autocomplete').each(function(i) {
    $(this).autocomplete("@base.url@/ac/adjunct.s",
        {
          formatItem: function(row, idx, count, query) {
            var adjunct = eval("(" + row[0] + ")");
            var ret = '<div>' + adjunct.name + '</div>';

            if (adjunct.mfg) {
              ret += '<div><i>' + adjunct.mfg.name + '</i></div>';
            }

            return ret;
          },

          formatResult: function(row, idx, count) {
            var adjunct = eval("(" + row[0] + ")");
            if (adjunct.mfg) {
              return adjunct.name + " " + adjunct.mfg.name + " [id: " + adjunct.id + "]";
            }
            return adjunct.name + " [id: " + adjunct.id + "]";
          }
      }
    );
  });


  // GRAIN

  $('input.grain_autocomplete').each(function(i) {
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



  // YEAST

  $('input.yeast_autocomplete').each(function(i) {
    $(this).autocomplete("@base.url@/ac/yeast.s",
        {
          formatItem: function(row, idx, count, query) {
            var yeast = eval("(" + row[0] + ")");
            var ret = '<div>' + yeast.name + '</div>';

            if (yeast.mfg) {
              ret += '<div><i>' + yeast.mfg.name + '</i></div>';
            }

            return ret;
          },

          formatResult: function(row, idx, count) {
            var yeast = eval("(" + row[0] + ")");
            if (yeast.mfg) {
              return yeast.name + " " + yeast.mfg.name + " [id: " + yeast.id + "]";
            }
            return yeast.name + " [id: " + yeast.id + "]";
          }
      }
    );
  });

}

$(document).ready(function() { com.rcc.brew.ac.init(); });
