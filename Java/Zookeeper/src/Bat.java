public class Bat extends Mammal{

    public Bat(){
        energy = 300;
    }
    public void fly(){
        System.out.println("Bat flying");
        energy -= 50;
    }
    public void eatHumans (){
        System.out.println("Eating Humans");
        energy += 25;
    }
    
    public void attackTown(){
        System.out.println("Town being Attacked");
        energy -= 100;
    }
}
