public class Bat extends Mammal{

    public Bat(){
        super.energy = 300;
    }
    public void fly(){
        System.out.println("Bat flying");
        super.energy -= 50;
    }
    public void eatHumans (){
        System.out.println("Eating Humans");
        super.energy += 25;
    }
    
    public void attackTown(){
        System.out.println("Town being Attacked");
        super.energy -= 100;
    }
}
