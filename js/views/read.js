// This is the IP for the server hosting the log files 
var ip = "192.168.99.1:8000";

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

getData("time", "http://" + ip + "/log/time.txt");
getData("sunlight", "http://" + ip + "/log/sunlight.txt");
getData("temperature", "http://" + ip + "/log/temperature.txt");
getData("humidity", "http://" + ip + "/log/humidity.txt");