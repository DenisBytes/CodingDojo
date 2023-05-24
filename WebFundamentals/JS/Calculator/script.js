var displayDiv = document.querySelector("#display");
displayDiv.innerText = "Some new value";
let temp = "";
var result;

function press (x){
    temp += x;
    displayDiv.innerHTML = temp;
}

function clr(){
    temp = "";
    displayDiv.innerHTML = "Enter...";
}

function calculate (){
    result = eval(displayDiv.innerHTML);
    displayDiv.innerHTML = result;
}