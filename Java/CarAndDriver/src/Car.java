public class Car {
    public int gas = 10;

    public void displayGas (){
        if (gas > 0){
            System.out.println("You have "+gas+" left");
        }
        else {
            System.out.println("No gas");
        }
    }

}
