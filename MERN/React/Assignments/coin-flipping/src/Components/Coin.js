function fiveHeads(){
    return new Promise( (resolve, reject) =>{
        let attempts = 0;

        let heads = 0;

        while (heads < 5){

            attempts++;
            const randomCoin = Math.random() > 0.5 ? "Heads": "Tails";
            console.log(`${attempts}) ${randomCoin} was flipped`);

            if (attempts > 100){
                reject("Failed");
                break;
            }

            if (randomCoin == "Heads"){
                heads++;
                if (heads == 5){
                    resolve(`it took ${attempts} attempts to flip heads 5 times in a row`);
                }
            }
            else{
                heads = 0;
            }
        }
    } );
}

fiveHeads()
    .then( res => console.log(res) )
    .catch( err => console.log(err) );
console.log( "When does this run now?" );