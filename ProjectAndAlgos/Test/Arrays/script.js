
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
var arr1 = [-2,-2,3.14,5,5,10];
var arr2 = [9,19,19,19,19,29];

function removeDoubles(array){
    for (var i = 0; i < array.length; i++){
        for (var j = i+1; j < array.length; j++){
            if (array[j-1] == array[j]){
                for (var z = j; z <= array.length; z++){
                    array[z-1] = array[z];
                    if (z == array.length){
                        array.pop();
                    }
                }
            }
        }
    }
}


console.log(arr1)
removeDoubles(arr1);
removeDoubles(arr2);
console.log(arr1);
console.log(arr2);



var arr3 = [4,2,1,3,5];

function minToFront(array){

    var x = array[0];
    var z;

    for (var i = 0 ; i <array.length; i++){
        if (x > array[i]){
            x = array[i];
            z = i;
        }
    }

    for (var j = z; j >= 0; j--){
        array[j] = array[j-1];
        if (j == 0){
            array[0] = x;
        }
    }
}


minToFront(arr3);
console.log(arr3);