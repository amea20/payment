function sortPayments() {
	var sortType = $('#sortPayments');
	$.ajax({
	    url : '/sortpayments?'
		,
		
	    data : {
		'sortType' : sortType.val()
	   },

	    dataType : 'json',

	    success: function(email) {
	    	//sort table by type selected
	
	    },
	    error: function(e){
	        alert("There is a technical issue! Please try again later.");
	    }

	 });
}

function viewDatePicker() {
	  var date_input=$('input[id="datepicker"]');
	  var container= $('body');
	  var options={
		format: 'dd/mm/yyyy',
		container: container,
		todayHighlight: true,
		autoclose: true,
	  };
	  date_input.datepicker(options);
}

$(document).ready(function() {

	viewDatePicker();
	
});