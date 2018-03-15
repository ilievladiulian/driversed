function uploadFile() {
	jQuery.ajax({
		url: "http://localhost:8080/upload",
		method: "GET"
	}).done(function(data) {
		jQuery("#page-content").empty();
		jQuery("#page-content").append(data);
	});
}

function parseFile() {
	jQuery.ajax({
		url: "http://localhost:8080/select",
		method: "GET"
	}).done(function(data) {
		jQuery("#page").empty();
		jQuery("#page").append(data);
	});
}

function getParsedFile(caller) {
	console.log(caller.innerHTML);
	jQuery.ajax({
		url: "http://localhost:8080/parse?file=" + caller.innerHTML,
		method: "GET"
	}).done(function(data) {
		jQuery("#page").empty();
		jQuery("#page").append(data);
	}).fail(function(data) {
		jQuery("#page-content").empty();
		jQuery("#page-title").empty();
		jQuery("#page-title").append(data.responseJSON.message + "<div class='action-button' onclick='backToHome()'>Back to Home</div>");
	});
}

function backToHome() {
	window.location.href = "http://localhost:8080/home";
}

function getFile(caller) {
	console.log(caller.innerHTML);
	window.location.href = "http://localhost:8080/serve?file=" + caller.innerHTML;
}