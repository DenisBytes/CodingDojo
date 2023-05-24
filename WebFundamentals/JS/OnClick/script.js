function logOut(element){
    if (element.innerText == "LogIn"){
        element.innerText="LogOut";
    }
    else if (element.innerText == "LogOut"){
        element.innerText = "LogIn";
    }
}
function removeButton(definitionBtn){
    definitionBtn.remove();
}