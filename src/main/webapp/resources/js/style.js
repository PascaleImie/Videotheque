$(document).ready(function(){
    var newMdp = $('#newMdp');
    var mdpConf = $('#mdpConf');

    $('#buttonModif').click( function(e){
        if(newMdp.val() != mdpConf.val()){
             e.preventDefault();
             $('#alert').fadeIn("slow").html("Mot de passe non confirmé");
             $('#alert').fadeOut("slow");
        }
    });
});

$(document).ready( function () {
		$('#bootstrap-table').bdt({
			showSearchForm: 1,
			showEntriesPerPageField: 1
		});

});

$(document).ready(function() {

        	var targetUrl = $(".confirmLink").attr("href");
        	$("#corbeille").click(function(){



            $( "#dialogue" ).dialog({
            	height:180,
		        width:400,



                buttons: {
                    "OK": function() {

                       document.location.href = targetUrl;

                    },
                    "Annuler": function() {
                        $( this ).dialog( "close" );
                    }
                }
            });

        });
});
   