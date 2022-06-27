/*
This function when called gets all the data needed from the web page
and calls getRequest function with fetched data as the parameters
*/
function search() {
	var selectedGet = $("input:radio[name ='searchType']:checked").val();
	var searchParams = $("form#searchForm").serializeArray();
	var format = $( "#returnFormat" ).val();
	var cType;
	searchText = searchParams[0].value
	
	if(format == "text"){
		cType = "text/plain";
	}
	else{
		cType = "application/" + format;
	}

	$("#results").empty();
	
	getRequests(format, cType, searchText, selectedGet)
}

/*
This function fetches the insert from content to be sent to
the insertFilm function to be inserted into the database
*/
function formatInsertData(){
	var format = $("input:radio[name ='format']:checked").val()
	var formattedData;
	var dataArray = $("form#insertForm").serializeArray();
	
	if(format == 'json'){
		formattedData = formatJson(dataArray);
	}
	
	else if(format == 'xml'){
		formattedData = formatXML(dataArray);
	}
	
	insertFilm(formattedData, format);
}

/*
This function takes an element sends it to the getRowId function,
then sends it to the getUpdateData function 
*/
function getIdForUpdate(element){	
	getUpdateData(getRowId(element));
}

/*
This function takes an element sends it to the getRowId function, then
sends it to the deleteFilm
*/
function getIdForDelete(element){	
	deleteFilm(getRowId(element));
	
	$(element).closest("tr").remove();
}

/*
This function fetches the update form data and other required data,
sends it to the updateFilm function to be updated in the database
*/
function formatUpdateData(){
	var format = $("input:radio[name ='updateFormat']:checked").val()
	var formattedData;
	var dataArray = $("form#updateForm").serializeArray();
	
	if(format == 'json'){
		formattedData = formatJson(dataArray);
	}
	
	else if(format == 'xml'){
		formattedData = formatXML(dataArray);
	}
	
	updateFilm(formattedData, format);
}

/*
This function takes a dataArray and converts it into a 
JSON object
*/
function formatJson(dataArray){
	var dataJson = {};
	$.each(dataArray, function(index, data){
		dataJson[data.name] = data.value;
	});
	
	return JSON.stringify(dataJson);
}

/*
This function takes a dataArray and converts it into an
XML object
*/
function formatXML(dataArray){
	var dataXML = '<film>'; 
	$.each(dataArray, function(index, data){
		dataXML = dataXML + '<'+data.name+'>'+data.value+'</'+data.name+'>';
	});
	
	dataXML = dataXML + '</film>';
	
	return dataXML;
}

/*
This function gets the ID from a row in the table on the web
page
*/
function getRowId(element){
	var $row = $(element).closest("tr");
	var $rowData = $row.find("th");
	
	return $rowData
}

/*
This function creates the table and decides what 
format was used in the response so the program can
parse the data correctly
*/
function createTable(response, div, format) {
	var tableStart = '<table class="table"><thead><tr><th scope="col">ID</th><th scope="col">Title</th><th scope="col">Year</th><th scope="col">Director</th><th scope="col">Stars</th><th scope="col">Review</th><th scope="col">Update/Delete</th></tr></thead><tbody>';
	var $table = $(tableStart).appendTo($(div));
	
	if(format == 'json'){
		var formattedResponse = Object.values(response);
		
		if(formattedResponse[0].length === undefined){
			buildTable(parseJson(formattedResponse), $table);
		}
		else{
			buildTable(parseJson(formattedResponse[0]), $table);
		}		
	}
	else if(format == 'xml'){
		buildTable(parseXML(response), $table);
	}
	else{
		buildTable(parseString(response), $table);
	}
}

/*
This function parses the JSON into an array that can be used to 
build the table
*/
function parseJson(response){
	var dataArray = [];
	
	$.each(response, function(index, film){
		var filmData = [film.id, film.title, film.year, film.director, film.stars, film.review];
		
		dataArray.push(filmData);
	});
	
	return dataArray;
}

/*
This function parses the XML into an array so that it can
be used to build the table
*/
function parseXML(response){
	var dataArray = [];
	
	$(response).find('film').each(function(index, element){
		var film = $(element);
		var filmData = [];
		filmData.push(film.find('id').text());
		filmData.push(film.find('title').text());
		filmData.push(film.find('year').text());
		filmData.push(film.find('director').text());
		filmData.push(film.find('stars').text());
		filmData.push(film.find('review').text());
		
		dataArray.push(filmData);
	});
	
	return dataArray;
}

/*
This function parses the string data into an array so it can
be used to build the table
*/
function parseString(response){
	var dataArray = [];
	
	var splitResponse = response.split('*,*');
	
	while(splitResponse[0]){
			dataArray.push(splitResponse.splice(0,6));
		}
		
	return dataArray;
}

/*
This function takes the parsed array and a table element
and populates the table with the data in the array
*/
function buildTable(array, $table){
	$.each(array, function(index, film){
		$("<tr>").appendTo($table)
			.append($('<th scope="row">').text(film[0]))
			.append($("<td>").text(film[1]))
			.append($("<td>").text(film[2]))
			.append($("<td>").text(film[3]))
			.append($("<td>").text(film[4]))
			.append($("<td>").text(film[5]))
			.append($("<td>").append('<input type="button" value="Update" data-bs-toggle="modal" data-bs-target="#updateModal" onclick="getIdForUpdate(this)">').append('<input class="fa fa-trash" type="button" value="Delete" onclick="getIdForDelete(this)">'));
	});
}