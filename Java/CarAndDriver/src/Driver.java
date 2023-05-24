public class Driver extends Car{
    public void drive(){
        System.out.println("Your driving!!!");
        gas -=1;
        super.displayGas();
    }
    public void useBoosters(){
        if (gas >= 4){
            System.out.println("Booster Used!!!");
            gas -= 3;
            super.displayGas();
        }
        else{
            System.out.println("Cannot boost!!!");
        }
    }
    public void refuel(){
        if (gas <7){
            System.out.println("Refueling!!!");
            gas+=2;
            super.displayGas();
        }
        else {
            System.out.println("Cannot refuel!!!");
        }
    }
}
