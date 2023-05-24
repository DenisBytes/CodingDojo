    function pizzaOven (crust, sauce, cheese, toppings){
    var pizza = {};
    pizza.crust = crust;
    pizza.sauce = sauce;
    pizza.cheese = cheese;
    pizza.toppings = toppings;

    return pizza;
}

var p1 = pizzaOven ("deep dish", "traditional", ["mozzarella"], ["pepperoni", "sausage"]);
console.log(p1);

var p2 = pizzaOven ("hand tossed", "marinara", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
console.log(p2);

var p3 = pizzaOven ("white bread", "tomato", ["mozzarella"], ["salami", "olives"]);
console.log(p3);

var p4 = pizzaOven ("integral bread", "garlic sauce", ["mozzarella"], ["tuna", "onions"]);
console.log(p4);

//Bonus Challenge
var arrayCrust = ["white bread", "deep dish", "hand tossed", "Integral bread"];
var arraySauce = ["tomato", "marinara", "Traditional", "garlic sauce"];
var arrayCheese = ["Mozzarella", "Feta", "Ricotta", "Gorgonzola"];
var arrayToppings = ["tuna", "oninons", "salami", "olives", "mushrooms", "pepperoni", "sausage"];

function randomPizza (crust, sauce, cheese, toppings){
    var pizza = {};
    var temp;

    if(crust < 2){
        for (var i = 0; i<crust; i++){
            temp = Math.floor(Math.random() * arrayCrust.length);
            pizza.crust = [arrayCrust[temp]];
        }
    }
    else{
        pizza.crust = "INSERT NOT MORE THAN 1 VALUE";
    }
    
    if (sauce < 2){
        for (var i = 0; i<sauce; i++){
            temp = Math.floor(Math.random() * arraySauce.length);
            pizza.sauce = [arraySauce[temp]];
        }
    }
    else{
        pizza.sauce = "INSERT NOT MORE THAN 1 VALUE";
    }

    if (cheese < 3){
        for (var i = 0; i<cheese; i++){
            var tempCheese = [];
            temp = Math.floor(Math.random() * arrayCheese.length);
            tempCheese.push(arrayCheese[temp]);
        }
        pizza.cheese = tempCheese;
    }
    else{
        pizza.cheese = "INSERT NOT MORE THAN 2 VALUES";
    }

    if (toppings < 5){
        for (var i = 0; i<toppings; i++){
            var tempToppings = [];
            temp = Math.floor(Math.random() * arrayToppings.length);
            tempToppings.push(arrayToppings[temp]);
        }
        pizza.toppings = tempToppings;
    }
    else{
        pizza.toppings = "INSERT NOT MORE THAN 4 VALUES";
    }

    return pizza;
}

var randPizza = randomPizza(1,1,2,4);
console.log(randPizza);