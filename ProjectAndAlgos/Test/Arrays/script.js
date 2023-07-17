
var arr = [1,2,3,4,5];


function pushFront(array,x){
    
    for (var i = array.length; i>=0 ; i--){
        array[i] = array[i-1];
        if(i == 0 ){
            array[i] = x;
        }
    }
}

pushFront(arr,9);
console.log(arr);




function popFront(array){
    var x = array[0];
    for (var i = 1; i <= array.length; i++){
        array[i-1] =array[i];
        if (i == array.length){
            array.pop();
        }
    }
    return x;
}

var hey = popFront(arr);
console.log(hey);
console.log(arr);




function insertAt(array, position, value){
    for (var i = array.length; i>=position; i--){
        array[i] = array[i-1];
        if (array[i] == position){
            array[position] = value;
        }
    }
}

insertAt(arr, 2,3);
console.log(arr);


function removeAt(array, position){
    for (var i = position; i < array.length -1; i++){
        array[i] = array[i+1];
        if (array[i] == array[array.length-1]){
            array.pop();
        }
    }
}

removeAt(arr, 2);
console.log(arr);


function swapPairs (array){
    for (var i = 0; i<array.length; i+=2){
        if (i+=1 == array.length){
            break;
        }
        var temp = array[i];
        array[i] = array[i+1];
        array[i+1] =  temp;
    }
}

swapPairs(arr);
console.log(arr);


//not finished
var arr1 = [1,2,2,2,2,2,2,2,4]
function removeDoubles (array){
    for (var i = 0; i< array.length; i++){
        var temp = array[i];
        for (var j = 1; j< array.length; j++){
            if (temp == array[j]){
                for (var k = 2; k < array.length+1; k++){
                    array[k-1] = array[k];
                }
            }
        }
    }
}

removeDoubles(arr1);
console.log(arr1);