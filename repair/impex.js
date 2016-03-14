var R = require('ramda');
var fs = require('fs');

var header = 'Type,Local Number,Message,Field 1,Value 1,Units 1,Field 2,Value 2,Units 2,Field 3,Value 3,Units 3,Field 4,Value 4,Units 4,Field 5,Value 5,Units 5,Field 6,Value 6,Units 6,Field 7,Value 7,Units 7,Field 8,Value 8,Units 8,Field 9,Value 9,Units 9,Field 10,Value 10,Units 10,Field 11,Value 11,Units 11,Field 12,Value 12,Units 12,Field 13,Value 13,Units 13,Field 14,Value 14,Units 14,Field 15,Value 15,Units 15,Field 16,Value 16,Units 16,Field 17,Value 17,Units 17,Field 18,Value 18,Units 18,Field 19,Value 19,Units 19,Field 20,Value 20,Units 20,Field 21,Value 21,Units 21,Field 22,Value 22,Units 22,Field 23,Value 23,Units 23,Field 24,Value 24,Units 24,Field 25,Value 25,Units 25,Field 26,Value 26,Units 26,Field 27,Value 27,Units 27,Field 28,Value 28,Units 28,Field 29,Value 29,Units 29,Field 30,Value 30,Units 30,';
var fields = header.replace(/"/g, "").split(",");

var objects_from_csv = function(csv){
	var lines = csv.split("\n");
	var result = R.map(function(line){
		return to_object(fields,line.split(","));
	}, R.tail(lines));
	return result;
};

var objects_to_csv = function(objects){
	var lines = R.map(function(item){
		return to_row(fields, item);
	}, objects);
	return header + "\n" + R.filter(n => !R.isEmpty(n.replace(/,/g, "")), lines).join("\n") + "\n";
};

var get_from_file = function(filename, callback){
	fs.readFile(filename, 'utf8', function (err, lines) {
		if (err) throw err;
		callback(objects_from_csv(lines));
	});
};

var to_object = function(keys, values){
	var obj = {};
	for(var i = 0; i < values.length; i++){
		obj[keys[i]] = values[i].replace(/"/g, "").toString();
	}
	return obj;
};

var to_row = function(keys, obj){
	var row = [];
	for(var i = 0; i < keys.length; i++){
		var value = obj[keys[i]];
		if(keys[i] === "Local Number"
			|| (obj["Type"] === "Definition" && value === "1")
			|| value === ""){
		
		}else{
			//value = '"'+value+'"';
		}
		row.push(value);
	}
	return row.join(",");
};

var write_to_file = function(filename, data){
	fs.writeFile(filename+'.new', objects_to_csv(data), function (err) {
      if (err) throw err;
    });
};

exports.get_from_file = get_from_file;
exports.write_to_file = write_to_file;