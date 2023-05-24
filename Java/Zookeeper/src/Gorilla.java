public class Gorilla extends Mammal{
    public void gorillaThrow (){
        System.out.println("Gorilla throwing bananas at people");
        energy -= 5;
    }

    public void eatBananas (){
        System.out.println("Gorilla eat banana");
        energy += 10;
    }

    public void climb (){
        System.out.println("Gorilla climbing");
        energy -= 10;
    }
}
