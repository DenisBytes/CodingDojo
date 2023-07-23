function removeBlanks(string){
    
    let x = "";

    for (var i = 0 ; i < string.length; i++){
        if (string[i] != " "){
            x += string[i];
        }
    }

    return x;
}


console.log(removeBlanks(" Pl ayTha tF u nkyM usi c "));



function getDigits(string){
    let x = "";

    for (var i = 0; i < string.length; i++){
        if (Number(string[i]) || string[i] == "0"){
            x += string[i];
        }
    }

    return parseInt(x);
}



console.log(getDigits("abc8c0d1ngd0j0!8"));



function acronym(string){

    let x = "";

    
    for (var i = 0; i < string.length; i++){
        if (string[i] == 0 && string[i] != " "){
            x+= string[i];
        }
        if (string[i] == " "){
            if (i != string.length -1){
                x += string[i+1];
            }
        }
    }

    return x.toUpperCase();
}


console.log(acronym(" there's no free lunch - gotta pay yer way. "));
console.log(acronym(" Live from New York, it's Saturday Night!"));



function countNonSpaces(string){

    let count = 0;

    for (var i = 0; i < string.length; i++){
        if (string[i]!= " "){
            count++;
        }
    }

    return count;

}

console.log(countNonSpaces("Honey pie, you are driving me crazy"));
console.log(countNonSpaces("Hello world !"));



function removeShorterStrings(array, num){

    let newArray = [];

    for (var i = 0; i < array.length; i++){
        if (array[i].length >= num){
            newArray.push(array[i]);
        }
    }

    return newArray;
}

console.log(removeShorterStrings(['Good morning', 'sunshine', 'the', 'Earth', 'says', 'hello'], 4));
console.log(removeShorterStrings(['There', 'is', 'a', 'bug', 'in', 'the', 'system'], 3));