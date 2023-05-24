var footer = document.querySelector("footer");
var tempSelect = document.querySelector("#tempSelect");

function cityChanger() {
    alert("loading weather report");
}

function removeFooterFunction() {
    footer.remove();
}

function convert() {
    var tempElements = document.querySelectorAll('.degree');

    var tempSelect = document.getElementById('tempSelect').value;
    if (tempSelect === 'cel') {
        tempElements.forEach(function (element) {
            var fahrenheit = parseFloat(element.textContent);
            var celsius = (fahrenheit - 32) * 5 / 9;
            element.textContent = celsius.toFixed(1);
        });
    } else {
        tempElements.forEach(function (element) {
            var celsius = parseFloat(element.textContent);
            var fahrenheit = celsius * 9 / 5 + 32;
            element.textContent = fahrenheit.toFixed(1);
        });
    }
}