function getData(keyword, path)
{
	var client = new XMLHttpRequest();
	
	client.open('GET', path);
	client.onreadystatechange = function() 
	{
		var text = client.responseText;
		localStorage.setItem(keyword, text);
		console.log(text);
	}

	client.send()
}

getData("time", "http://127.0.0.1:8000/js/time.txt");
getData("sunlight", "http://127.0.0.1:8000/js/humidity.txt")