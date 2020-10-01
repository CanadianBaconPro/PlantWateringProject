


var time = (localStorage.getItem("time")).split(" ")
var sunlight = (localStorage.getItem("sunlight")).split(" ")
var temperature = (localStorage.getItem("temperature")).split(" ")
var humidity = (localStorage.getItem("humidity")).split(" ")



var sot = document.getElementById("SunlightOverTime");
var SunlightOverTime = new Chart(sot, {
    type: 'line',
    data: {
        labels: time,
        datasets: [
            {
                data: sunlight,
                label: "Sunlight (Lux)",
                borderColor: "#0dfc00",
                backgroundColor: "#bdffbe"
            }
        ]
    }

});

var tot = document.getElementById("TemperatureOverTime");
var WaterOverTime = new Chart(tot, {
    type: 'bar',
    data: {
        labels: time,
        datasets: [
            {
                data: temperature,
                label: "Temperature (ºC)",
                borderColor: "#287ef7",
                backgroundColor: "#287ef7"
            }
        ] 
    }
});

var hot = document.getElementById("HumidityOverTime");
var HumidityOverTime = new Chart(hot, {
    type: 'line',
    data: {
        labels: time,
        datasets: [
            {
                data: humidity,
                label: "Humidity (%)",
                borderColor: "#ff1100",
                backgroundColor: "#ff8f87"
            }
        ]
    }
});

//https://css-tricks.com/snippets/css/a-guide-to-flexbox/