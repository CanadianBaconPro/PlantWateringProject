function readData(file)
{
	var client = new XMLHttpRequest();
	
	client.open('GET', file);
	client.onreadystatechange = function() 
	{
	  alert(client.responseText);
	}
	
	client.send();
}

readData("http://127.0.0.1:8000/js/time.txt.0.0.1/js/time.txt");