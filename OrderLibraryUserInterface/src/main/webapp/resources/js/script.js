function addItem() {
	alert("1");
	var ulist = document.getElementById("dynamic-list");
	var candidate = document.getElementById("item");
	var li = document.createElement("li");
	li.setAttribute('id', candidate.value);
	li.appendChild(document.createTextNode(candidate.value));
	ulist.appendChild(li);
}

function removeItem() {
	alert("2");
	var ulist = document.getElementById("dynamic-list");
	var candidate = document.getElementById("item");
	var item = document.getElementById(candidate.value);
	ulist.removeChild(item);
}

function getProducts() {
	alert("not working");
	$.ajax({
		url : 'php/search.php',
		type : 'get',
		data : {
			name : $('input#name').val()
		},
		success : function(response) {
			$('table#resultTable tbody').html(response);
		}
	});
}

$('.btnSearch').click(function() {
	makeAjaxRequest();
});

$('form').submit(function(e) {
	makeAjaxRequest();
});
function makeAjaxRequest() {
	$.ajax({
		url : 'php/search.php',
		type : 'get',
		data : {
			name : $('input#name').val()
		},
		success : function(response) {
			$('table#resultTable tbody').html(response);
		}
	});
}