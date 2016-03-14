var R = require('ramda');

var lengthtimes = function(lengths){
	print_props(['Value 1', 'Value 4'], lengths);
};
var lengths = function(lengths){
	print_props(['Value 1', 'Value 2', 'Value 3', 'Value 4', 'Value 5', 'Value 6', 'Value 7', 'Value 11'], lengths);
};
var records = function(records){
	print_props(['Value 1', 'Value 2', 'Value 3', 'Value 4'], records);
};
var laps = function(laps){
	print_props(['Value 1', 'Value 2','Value 3', 'Value 6', 'Value 7', 'Value 10', 'Value 11', 'Value 12', 'Value 14', 'Value 15', 'Value 22', 'Value 27', 'Value 28'], laps);
};
var sessions = function(sessions){
	print_props(['Value 1', 'Value 6', 'Value 10', 'Value 11', 'Value 14', 'Value 24', 'Value 29', 'Value 30'], sessions);
};
var print_props = function(props, lines){
	console.log("----");
	console.log(props.join(","));
	console.log((R.map(R.props(props), lines)).join("\n"));
};

exports.lengthtimes = lengthtimes;
exports.lengths = lengths;
exports.records = records;
exports.laps = laps;
exports.sessions = sessions;