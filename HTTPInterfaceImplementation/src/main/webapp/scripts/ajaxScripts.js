//This function processes all the get requests for search box
function getRequests(selectedGet, searchParams){
	if (selectedGet == "getAll") {
		$.get("get-all-films", function(responseJson) {
			createTable(responseJson, "#results")
		});
	}
	else if (selectedGet == "byName") {
		$.get("get-film-by-name", searchParams, function(responseJson) {
			createTable(responseJson, "#results")
		});
	}
	else if (selectedGet == "byID") {
		$.get("get-film-by-id", searchParams, function(responseJson) {
			createTable(responseJson, "#results")
		});
	}
	else if (selectedGet == "byYear") {
		$.get("get-film-by-year", searchParams, function(responseJson) {
			createTable(responseJson, "#results")
		});
	}
}

//This function posts the new data to be inserted into the database
function insertFilm(dataJson) {
	$.post("insert-film", JSON.stringify(dataJson), null, "json");
}

//This function gets the data that will be used in the update form
function getUpdateData(searchParams) {
	$.get("get-film-by-id", searchParams, function(responseJson) {
		$("#updateFilmID").val(responseJson[0].id);
		$("#updateFilmTitle").val(responseJson[0].title);
		$("#updateFilmYear").val(responseJson[0].year);
		$("#updateFilmDirector").val(responseJson[0].director);
		$("#updateFilmStars").val(responseJson[0].stars);
		$("#updateFilmReview").val(responseJson[0].review);
	});
}

//This function posts the updated data to the servlet
function updateFilm(dataJson){
	$.post("update-film", JSON.stringify(dataJson), null, "json");
}

//This function posts the ID to be deleted
function deleteFilm(dataJson){
	$.post("delete-film", JSON.stringify(dataJson), null, "json");
}

//This function is used to get the next ID for the insert form
function getNextID() {
	$.get("get-id", function(responseJson) {
		$("#filmID").val(responseJson);
	})
}