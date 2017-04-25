$(document).ready(function(){
    var newMdp = $('#newMdp');
    var mdpConf = $('#mdpConf');

    $('#buttonModif').click( function(e){
        if(newMdp.val() != mdpConf.val()){
             e.preventDefault();
             $('#alert').fadeIn("slow").html("Mot de passe non confirmé");

        }
    });

});

$(document).ready( function () {
		$('#bootstrap-table').bdt({
			showSearchForm: 1,
			showEntriesPerPageField: 1
		});
	});