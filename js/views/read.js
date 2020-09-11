function getData(keyword, path)
{
	var client = new XMLHttpRequest();
	
	client.open('GET', path);
	client.onreadystatechange = function() 
	{
		var text = client.responseText;
		localStorage.setItem(keyword, text);
		console.log(keyword + text);
	}

	client.send()
}

getData("time", "http://127.0.0.1:8000/log/time.txt");
getData("sunlight", "http://127.0.0.1:8000/log/sunlight.txt");
getData("temperature", "http://127.0.0.1:8000/log/temperature.txt");
getData("humidity", "http://127.0.0.1:8000/log/humidity.txt");