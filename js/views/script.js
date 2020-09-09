var time = ["18:50", "19:00", "19:50", "20:00", "20:50", "21:00", "21:50", "22:00", "22:50", "23:00", "23:50", "00:00"]
var sunlight = [18.5, 18.7, 18.9, 20.5, 25.5, 20.3, 18.5, 18.7, 18.9, 20.5, 20.2, 20, 19.3]
var temperature = [18.5, 18.7, 18.9, 20.5, 25.5, 20.3, 18.5, 18.7, 18.9, 19, 19.2, 17]
var humidity = [18.5, 18.7, 18.9, 20.5, 25.5, 20.3, 18.5, 18.7, 18.9, 20.5, 20.2, 20, 19.3]



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