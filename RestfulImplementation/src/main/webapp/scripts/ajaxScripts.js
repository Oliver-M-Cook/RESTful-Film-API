/*
This function takes the parameters and sends a GET request 
to the RESTful api in a set format. On success a table is 
created for the results
*/
function getRequests(format, cType, searchText, selectedGet){
	if (selectedGet == "getAll") {
		$.ajax({
			type: 'GET',
			url: 'rest/films',
			dataType: format,
			contentType: cType,
			success: function(response) {
				createTable(response, "#results", format);
			}
		});
	}
	else if (selectedGet == "byID") {
		$.ajax({
			type: 'GET',
			url: 'rest/films/film/' + searchText,
			dataType: format,
			contentType: cType,
			success: function(response) {
				createTable(response, "#results", format);
			}
		});
	}
	else if (selectedGet == "byYear") {
		$.ajax({
			type: 'GET',
			url: 'rest/films/year/' + searchText,
			dataType: format,
			contentType: cType,
			success: function(response) {
				createTable(response, "#results", format);
			}
		});
	}
	else if (selectedGet == "byName") {
		$.ajax({
			type: 'GET',
			url: 'rest/films/' + searchText,
			dataType: format,
			contentType: cType,
			success: function(response) {
				createTable(response, '#results', format);
			}
		});
	}
}

/*
This function takes the parameters sent and sends a POST request 
to the server to insert the film into the database
*/
function insertFilm(formattedData, format) {
	$.ajax({
		type: 'POST',
		url: 'rest/films/film',
		data: formattedData,
		dataType: format,
		contentType: "application/" + format
	});
}

/*
This function takes the ID and sends a DELETE request to the 
server to delete the film with the specified id
*/
function deleteFilm($id) {
	$.ajax({
		type: 'DELETE',
		url: 'rest/films/film',
		data: $id.text(),
		contentType: "application/json"
	});
}

/*
This function takes the ID of the film and sends a GET request 
to the server to fetch the film data. The data is then inserted 
onto the webpage in the update form
*/
function getUpdateData($rowId) {
	$.ajax({
		type: 'GET',
		url: 'rest/films/film/' + $rowId.text(),
		dataType: "json",
		contentType: "application/json",
		success: function(response) {
			var formattedResponse = Object.values(response);
			$("#updateFilmID").val(formattedResponse[0].id);
			$("#updateFilmTitle").val(formattedResponse[0].title);
			$("#updateFilmYear").val(formattedResponse[0].year);
			$("#updateFilmDirector").val(formattedResponse[0].director);
			$("#updateFilmStars").val(formattedResponse[0].stars);
			$("#updateFilmReview").val(formattedResponse[0].review);
		}
	});
}

/*
This function takes the data and format sends a PUT request to 
the server to update the sent film in the database
*/
function updateFilm(formattedData, format) {
	$.ajax({
		type: 'PUT',
		url: 'rest/films/film',
		data: formattedData,
		dataType: format,
		contentType: "application/" + format
	});
}

/*
This function sends a GET request to server to get the next ID
for the film next to be inserted
*/
function getNextID() {
	$.ajax({
		type: 'GET',
		url: 'rest/films/count',
		dataType: 'text',
		contentType: 'text/plain',
		success: function(response) {
			$("#filmID").val(response);
		}
	});
}