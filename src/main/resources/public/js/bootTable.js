(function($) {
	
	'use strict';
	
	 
	 var BootTable = function(el,options){
        this.$el = $(el);
        this.options = $.extend(BootTable.PARAMS, typeof options == 'object' && options);
        this.init();
    };
    
    
    BootTable.PARAMS = {
    	columns:["code","name","price"]
    }
    
    BootTable.prototype = {

        constructor: BootTable,
            
        init:function()
        {
        	console.log("init boot table");
        	var that = this;
        	this.$el = this.$el.each(function() {
        		var table = "";
                table = table.concat("<table class='table table-striped'><thead><tr>");
                $.each(that.options.columns,function(index,column){
                	table = table.concat("<td>"+column+"</td>")
                });
                table = table.concat("</tr></thead>");
        	    //this.innerHTML = table;
        	    that.loadData(this,table);
           });
           return this;
        },
        
        loadData:function(table,content){
        	var body = "";
        	$.ajax({
        		 type: "POST",
				  url: "/stock",
				  success: function(stock){
//					  $.each(stocks,function(index,stock){
						  body = body.concat("<tr><td>"+stock.code+"</td><td>"+stock.name+"</td><td>"+stock.bvps+"</td></tr>").concat("</table>")
//					  });	  
				  },
				  dataType: 'json'
        	}).done(function(){
        		table.innerHTML = content.concat(body);
        	});
        }
    
    }   
            

    $.fn.bootTable = function (options) {
        return new BootTable(this,options);
    };
	
}(jQuery));