var time = [1850, 1900, 1950, 2000, 2050, 2100, 2150, 2200, 2250, 2300, 2350, 0000]
var sunlight = [18.5, 18.7, 18.9, 20.5, 25.5, 20.3, 18.5, 18.7, 18.9, 20.5, 20.2, 20, 19.3]
var water = [18.5, 18.7, 18.9, 20.5, 25.5, 20.3, 18.5, 18.7, 18.9, 19, 19.2, 17]

var sot = document.getElementById("SunlightOverTime");
var SunlightOverTime = new Chart(sot, {
    type: 'line',
    data: {
        labels: time,
        datasets: [
            {
                data: sunlight,
                label: "Sunlight (in Lux)",
                borderColor: "#0dfc00",
                backgroundColor: "#bdffbe"
            }
        ]
    }

})

var wot = document.getElementById("WaterOverTime");
var WaterOverTime = new Chart(wot, {
    type: 'line',
    data: {
        labels: time,
        datasets: [
            {
                data: water,
                label: "Water (in mL)",
                borderColor: "#287ef7",
                backgroundColor: "#bdffff"
            }
        ] 
    }
})