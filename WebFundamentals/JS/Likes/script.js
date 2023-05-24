var likeText = document.querySelector("#likesCount");
var likeText1 = document.querySelector("#likesCount1");
var likeText2 = document.querySelector("#likesCount2");

var counts = [0,0,0];

var likes = [likeText, likeText1, likeText2];

function likeAdd(x){
    counts[x]++;
    likes[x].innerText = counts[x] + " like(s)";
}
