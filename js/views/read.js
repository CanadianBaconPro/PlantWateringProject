var data;

function readData(file)
{
	var client = new XMLHttpRequest();
	
	client.open('GET', file);
	client.onreadystatechange = function() 
	{
		data = client.responseText;
		localStorage("fileDataRead", data.split(" "));
		console.log(localStorage.getItem("fileDataRead"));
	}
	
	client.send()
}

readData("http://127.0.0.1:8000/js/time.txt");

alert(localStorage.getItem("../time.txt"));