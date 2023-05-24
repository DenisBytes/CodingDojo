var world = [
    [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2],
    [2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2],
    [2,1,2,1,1,1,1,1,2,2,1,1,2,2,1,1,1,1,1,1,2,1,2],
    [2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2],
    [2,1,2,1,1,1,1,1,2,2,0,0,2,2,1,1,1,1,1,1,2,1,2],
    [2,1,1,1,1,1,1,1,2,0,0,0,0,2,1,1,1,1,1,1,1,1,2],
    [2,1,2,1,1,1,1,1,2,0,0,0,0,2,1,1,1,1,1,1,2,1,2],
    [2,1,2,1,1,1,1,1,2,2,2,2,2,2,1,1,1,1,1,1,2,1,2],
    [2,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,2],
    [2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2],
    [2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2]
];

var pacman = {
    x : 0,
    y : 0
};


function displayPacman (){
    document.getElementById('pacman').style.top = (pacman.y+1)*54+"px";
    document.getElementById('pacman').style.left = (pacman.x+1)*54+"px";
}

function displayWorld (){
    var output = '';

    for (var i = 0; i<world.length; i++){
        output += "\n<div class='row'>";
        for (var j = 0; j<world[i].length; j++){
            if (world[i][j] == 2 ){
                output += "\n\t<div class='brick'></div>";
            }
            else if (world[i][j] == 1){
                output += "\n\t<div class='coin'></div>";
            }
            else if (world[i][j] == 0){
                output += "\n\t<div class='empty'></div>";
            }
        }
        output += "\n</div>";
    }

    
    console.log(output);
    document.getElementById('world').innerHTML = output;
}

displayWorld();
displayPacman();

document.onkeydown = function(e){
    if (e.keyCode == 37){
        pacman.x --;
        document.getElementById('pacman').style.transform = `rotate(180deg)`;
    }
    else if (e.keyCode == 39){
        pacman.x ++;
        document.getElementById('pacman').style.transform = `rotate(0deg)`;
    }
    else if (e.keyCode == 38){
        pacman.y --;
        document.getElementById('pacman').style.transform = `rotate(270deg)`;
    }
    else if (e.keyCode == 40){
        pacman.y ++;
        document.getElementById('pacman').style.transform = `rotate(90deg)`;
    }

    displayPacman ();
}