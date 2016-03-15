var R = require('ramda');
var u = require('./util');

var guess = function(lengths){
	return R.filter(n => n["Value 4"] < 60 && n["Value 9"] === "3", lengths);
}

var recalculate = function(data){
	var result = R.clone(data);
	var laps = u.laps(result);
	R.forEach(function(lap){
		var start_time = u.pint(lap["Value 3"]);
		var end_time = u.pint(lap["Value 2"]);
		var lengths = R.filter(n => n["Value 3"] >= start_time && n["Value 2"] <= end_time, u.lengths(result));
		var count = lengths.length; 
		// total distance
		lap["Value 6"] = count * 50;
		// avg_speed
		lap["Value 10"] = R.sum(R.map(n => u.pfloat(n["Value 7"]), lengths)) / count; 
		// max_speed
		lap["Value 11"] = R.reduce(R.max, 0, R.map(n => u.pfloat(n["Value 7"]), lengths)); 
		// num_lengths
		lap["Value 12"] = count; 
		// avg_stroke_distance
		lap["Value 14"] = lap["Value 6"] / lap["Value 7"];
		// num_active_lengths
		lap["Value 15"] = lap["Value 12"];
		// max_cadence
		lap["Value 22"] = R.reduce(R.max, 0, R.map(n => u.pint(n["Value 11"]), lengths)); 
		// enhanced_avg_speed
		lap["Value 27"] = lap["Value 10"];
		// enhanced_max_speed
		lap["Value 28"] = lap["Value 11"];

	}, laps);
	
	var lengths = u.lengths(result);
	var count = lengths.length; 
	var session = u.sessions(result)[0];
	
	// total_distance
	session["Value 6"] = R.sum(R.map(n => u.pint(n["Value 6"]), laps));
	// TODO avg_speed
	session["Value 10"] = R.sum(R.map(n => u.pfloat(n["Value 4"]), laps)) / u.pint(session["Value 6"]);
	// max_speed
	session["Value 11"] = R.reduce(R.max, 0, R.map(n => u.pfloat(n["Value 11"]), laps));
	// hi18n33 (number of length)
	session["Value 14"] = R.sum(R.map(n => u.pint(n["Value 12"]), laps));
	// TODO hi18n80 (swolf)
	session["Value 18"] = Math.round((session["Value 4"] + session["Value 7"]) / session["Value 14"]);
	// max_cadence
	session["Value 24"] = R.reduce(R.max, 0, R.map(n => u.pfloat(n["Value 22"]), laps));
	// enhanced_avg_speed
	session["Value 29"] = session["Value 10"]
	// enhanced_max_speed
	session["Value 30"] = session["Value 11"]
	
	return result;
}

var merge = function(first, last, data){
	var meters = function(index, offset){ return (u.pint(index) + (offset || 0) + 1) * 50; }; 
	var find = function(filter, property, equalto){
		return R.findIndex(function(item){
			return filter(item) && u.intval(item, property) === equalto;
		}, data); 
	};
	
	var first_length_index = find(u.islength, "Value 1", u.pint(first));
	var last_length_index = find(u.islength, "Value 1", u.pint(last));
	var first_record_index = find(u.isrecord, "Value 2", meters(first));
	var last_record_index = find(u.isrecord, "Value 2", meters(last));

	var first_length = data[first_length_index];
	var last_length = data[last_length_index];
	var first_record = data[first_record_index];
	var last_record = data[last_record_index];

	var new_length = get_new_length(first_length, last_length);
	var new_record = get_new_record(first_record, last_record, new_length);

	var result = R.clone(data);
	result = replace(first_length_index, last_length_index, new_length, result);
	result = increment_following_rows(first_length, "Value 1", -1, u.islength, result);
	result = replace(first_record_index, last_record_index, new_record, result);
	result = increment_following_rows(first_record, "Value 2", -50, u.isrecord, result);
	return result;
};

var get_new_length = function(first_length, last_length){
	var first_intval = R.curry(u.intval)(first_length);
	var last_intval = R.curry(u.intval)(last_length);
	var first_floatval = R.curry(u.floatval)(first_length);
	var last_floatval = R.curry(u.floatval)(last_length);
	
	// message_index
	var new_length = R.clone(first_length);
	// timestamp
	new_length["Value 2"] = last_length["Value 2"];
	// start_time
	new_length["Value 3"] = first_length["Value 3"];
	// total_elapsed_time
	new_length["Value 4"] = first_floatval("Value 4") + last_floatval("Value 4");
	// total_timer_time
	new_length["Value 5"] = first_floatval("Value 5") + last_floatval("Value 5");
	// total_strokes
	new_length["Value 6"] = first_intval("Value 6") + last_intval("Value 6");
	// avg_speed
	new_length["Value 7"] = 50.00 / new_length["Value 4"];
	// avg_swimming_cadence
	new_length["Value 11"] = Math.round(60 * new_length["Value 6"] / new_length["Value 5"]);
	
	return new_length;
};

var get_new_record = function(first_record, last_record, new_length){
	// timestamp
	var new_record = R.clone(last_record);
	// distance
	new_record["Value 2"] = first_record["Value 2"];
	// speed
	new_record["Value 3"] = new_length["Value 7"];
	// enhanced_speed
	new_record["Value 4"] = new_length["Value 7"];
	
	return new_record;
};

var increment_following_rows = function(first, property, increment, filter, data){
	var min = u.intval(first, property);
	var result = R.clone(data);
	var tobechanged = R.filter(n => u.intval(n, property) > min && filter(n), result);
	R.forEach(function(item){
		item[property] = (u.intval(item, property) + increment);
	}, tobechanged);
	return result;
};

var replace = function(first_index, last_index, new_row, data){
	var result = R.clone(data);
	result[first_index] = new_row;
	result[last_index] = {};
	return result;
};

exports.merge = merge;
exports.guess = guess;
exports.recalculate = recalculate;