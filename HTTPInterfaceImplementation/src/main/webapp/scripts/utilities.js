//This function creates the table to hold the results
function createTable(responseJson, div) {
	//var tableStart holds the html that creates the table element and headers
	var tableStart = '<table class="table"><thead><tr><th scope="col">ID</th><th scope="col">Title</th><th scope="col">Year</th><th scope="col">Director</th><th scope="col">Stars</th><th scope="col">Review</th><th scope="col">Update/Delete</th></tr></thead><tbody>';
	var $table = $(tableStart).appendTo($(div));
	
	//Loops through response and appends a new table row
	$.each(responseJson, function(index, film) {
		$("<tr>").appendTo($table)
			.append($('<th scope="row">').text(film.id))
			.append($("<td>").text(film.title))
			.append($("<td>").text(film.year))
			.append($("<td>").text(film.director))
			.append($("<td>").text(film.stars))
			.append($("<td>").text(film.review))
			.append($("<td>").append('<input type="button" value="Update" data-bs-toggle="modal" data-bs-target="#updateModal" onclick="getIdForUpdate(this)">').append('<input class="fa fa-trash" type="button" value="Delete" onclick="getIdForDelete(this)">'));
	});
}

//This function collects search parameters and what search type
function search(){
	var selectedGet = $("input:radio[name ='searchType']:checked").val();
	var searchParams = $("form#searchForm").serialize();

	$("#results").empty();
	
	//Calls function that handles get requests
	getRequests(selectedGet, searchParams);
}

//This function formats form data and sends to ajaxScripts
function formatInsertData(){
	insertFilm(formatData("form#insertForm"));
}

//This function gets row ID and sends to ajaxScripts
function getIdForUpdate(element){
	var searchParams = "searchText=" + (getRowId(element)).text();
	
	getUpdateData(searchParams);
}

//This function formats form data and sends to ajaxScripts
function formatUpdateData(){
	updateFilm(formatData("form#updateForm"));
}

//This function gets row ID and sends to ajaxScripts
function getIdForDelete(element){
	var dataJson = {};
	dataJson["id"] = (getRowId(element)).text();
	
	deleteFilm(dataJson);
	
	$(element).closest("tr").remove();
}

//To avoid repeating code, this function formats a form and returns the data
function formatData(form){
	var dataArray = $(form).serializeArray();
	var dataJson = {};
	
	$.each(dataArray, function(index, data) {
		dataJson[data.name] = data.value;
	});
	
	return dataJson
}

//To avoid repeating code, this function gets row ID from table element
function getRowId(element){
	var $row = $(element).closest("tr");
	var $rowData = $row.find("th");
	
	return $rowData
}