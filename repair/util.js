var R = require('ramda');

var message = function(key, item){ return R.propEq("Message", key, item) && R.propEq("Type", "Data", item); };
var islength = R.curry(message)("length");
var isrecord = R.curry(message)("record");
var islap = R.curry(message)("lap");
var issession = R.curry(message)("session");
var lengths_by_type = function(type, data){ return R.filter(n => islength(n) && R.propEq("Value 9", type, n), data); };
var lengths = R.curry(lengths_by_type)("3");
var breaks = R.curry(lengths_by_type)("1");
var records = function(data){ return R.filter(n => isrecord(n), data); };
var laps_by_active = function(active, data){ return R.filter(n => islap(n) && (active ? !R.propEq("Value 15", "0", n) : R.propEq("Value 15", "0", n)), data); };
var laps = R.curry(laps_by_active)(true);
var laps_paused = R.curry(laps_by_active)(false);
var sessions = function(data){ return R.filter(n => issession(n), data); };
var pint = function(integer){ return parseInt(integer, 10); };
var pfloat = function(decimal){ return parseFloat(decimal, 10); };
var intval = function(item, key){ return pint(R.prop(key, item)); };
var floatval = function(item, key){ return pfloat(R.prop(key, item)); };



exports.lengths = lengths;
exports.breaks = breaks;
exports.records = records;
exports.laps = laps;
exports.laps_paused = laps_paused;
exports.sessions = sessions;
exports.intval = intval;
exports.floatval = floatval;
exports.pint = pint;
exports.pfloat = pfloat;
exports.islength = islength;
exports.isrecord = isrecord;
exports.islap = islap;
exports.issession = issession;