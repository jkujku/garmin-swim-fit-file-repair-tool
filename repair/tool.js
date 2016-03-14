var R = require('ramda');
var impex = require("./impex");
var viewer = require("./viewer");
var repair = require("./repair");
var util = require("./util");

var filename = "./data/2016-02-21-5000/1058556634.csv";


var main = function(){
	impex.get_from_file(filename, function(result){
		//var lengths = util.lengths(result);
		var repaired = R.clone(result);
				
		//viewer.lengthtimes(lengths);
		//viewer.lengthtimes(repair.guess(lengths));
		
		// merge lap data
		//viewer.lengths(util.lengths(repaired));
		//viewer.lengths(util.breaks(repaired));
		//viewer.records(util.records(repaired));
		repaired = repair.merge("45", "46", repaired);
		//viewer.lengths(util.lengths(repaired));
		//viewer.lengths(util.breaks(repaired));
		//viewer.records(util.records(repaired));
		
		// rewrite overall data
		viewer.laps(util.laps(repaired));
		//viewer.sessions(util.sessions(repaired));
		repaired = repair.recalculate(repaired);
		viewer.laps(util.laps(repaired));
		//viewer.sessions(util.sessions(repaired));
		
		impex.write_to_file(filename, repaired);
		
	});
};

var show = function(){
	impex.get_from_file(filename, function(result){
		console.log("\n\tLAPS ACTIVE");
		viewer.laps(util.laps(result));
		console.log("\n\tLAPS PAUSED");
		viewer.laps(util.laps_paused(result));
		console.log("\n\tLENGTH ACTIVE");
		viewer.lengths(util.lengths(result));
		console.log("\n\tLENGTH PAUSED");
		viewer.lengths(util.breaks(result));
		console.log("\n\t\RECORDS");
		viewer.records(util.records(result));
	});
}

var guess = function(){
	impex.get_from_file(filename, function(result){
		viewer.lengthtimes(repair.guess(util.lengths(result)));
	});
};

//show();
//guess();
main();

