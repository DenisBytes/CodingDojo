
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










var arr4 = [1,2,3,4,5];

function reverse(array){
    var j = array.length-1;
    for( var i = 0; i<array.length/2; i++){

        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        j--;
    }
}

reverse(arr4);
console.log(arr4);

//not done
function rotateArr(array, shiftBy){
    for (var i = 0; i< array.length; i=i+shiftBy){
        var temp = array[i+shiftBy];
        array[i+shiftBy] = array[i];
        array[i] = temp;
    }
}



function filterRange (array, min, max){
    
    var arr = [];
    var j = 0;
        
    
    for (var i = min; i <= max; i++){
        arr[j] = array[i];
        j++;
    }

    return arr;
}



console.log(filterRange(arr4,1,3));


var list = [1,2,3];
var list1 = [4,5];




function concatinate(array, array1){

    var x = array.length;

    for (var i = 0; i<array1.length; i++){
        array[x] = array1[i];
        x++;
    }

    return array;
}

console.log(concatinate(list,list1));





function removeNegatives(arr){
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < 0){
            for (var j = i+1; j <= arr.length; j++){
                if (j == arr.length){
                    arr.pop();
                }
                else{
                    arr[j-1] = arr[j];
                }
            }
        }
    }
    return arr;
}

console.log(removeNegatives([2,-1,3,-79,4,-57]));





function secondToLast(arr){
    if (arr.length <= 1){
        return null;
    }

    //return arr[arr.length -2];

    let x;

    for (var i = 0; i < arr.length; i++){
        if (i+2 == arr.length){
            x = arr[i];
        }
    }

    return x;
}

console.log(secondToLast([42,true,4,"Kate",7]));





function secondLargest(arr){

    let x;
    let biggest;

    for (var i = 0; i <arr.length; i++){
        if (i == 0 && arr[i] > arr[i+1]){
            x = arr[i+1];
            biggest = arr[i];
            continue;
        }
        else if(i == 0 && arr[i] < arr[i+1]){
            x = arr[i];
            biggest = arr[i+1];
            continue;
        }
        else{
            if (arr[i] > biggest){
                x = biggest;
                biggest = arr[i];
            }
            else if (arr[i] < biggest && arr[i]>x){
                x = arr[i];
            }
        }
        
    }
    return x;
}

console.log(secondLargest([42,1,4,Math.PI,7]));



function nthToLast(arr,num){

    if (arr.length < num){
        return null;
    }

    return arr[arr.length - num];

}


console.log(nthToLast([5,2,3,6,4,9,7],3));




//not done
function nthLargest(arr, num){

}


