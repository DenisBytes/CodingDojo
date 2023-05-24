public class Mammal {
    public int energy;

    public Mammal (){
        this.energy = 100;
    }

    public void setNewEnergy (int num){
        this.energy = num;
    }

    public void displayEnergy(){
        System.out.println("energy level: "+this.energy);
    }
}
