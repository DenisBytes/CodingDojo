var profileName = document.querySelector("#profileName");
var user1 = document.querySelector("#user1");
var user2 = document.querySelector("#user2");
var users = [user1,user2];
var conReqNumber = document.querySelector("#conReqNumber");
var conNumber = document.querySelector("#conNumber");
count = 2;
count1 = 500;

function switchName(){
    profileName.innerText="Michael J. Huddleston";
}

function removeUser(x){
    users[x].remove();
    count --;
    conReqNumber.value = count;
}

function addConNumber (){
    count1++;
    conNumber.value = count1;
}