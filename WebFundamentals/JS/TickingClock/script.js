function getSecondsSinceStartOfDay() {
    return new Date().getSeconds() +
        new Date().getMinutes() * 60 +
        new Date().getHours() * 3600;
}

var sec = document.querySelector("#seconds");
var min = document.querySelector("#minutes");
var hour = document.querySelector("#hour");

var tempSec;
var tempMin;
var tempHour;

setInterval(function () {
    var time = getSecondsSinceStartOfDay();
    console.log(time);
    // your code here
    tempSec = new Date().getSeconds() * 6 + 180;
    sec.style.transform = `rotate(${tempSec}deg)`;
    tempMin = new Date().getMinutes() * 6 + 180;
    min.style.transform = `rotate(${tempMin}deg)`;
    tempHour = new Date().getHours() * 30 +180;
    hour.style.transform = `rotate(${tempHour}deg)`;
}, 1000);
