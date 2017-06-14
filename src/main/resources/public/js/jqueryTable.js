(function ( $ ) {
 
    var shade = "#556b2f";
    
    var columns = ["code","name","price"];
 
    $.fn.jqueryTable = function() {
    	var table = "";
        table = table.concat("<table class='table table-striped'><thead><tr>");
        $.each(columns,function(index,column){
        	table = table.concat("<td>"+column+"</td>")
        });
        table = table.concat("</tr></thead></table>");
        return this.append(table);
    };
 
}( jQuery ));