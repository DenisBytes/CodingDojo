public class Item {
    private String name;
    private double price;
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double number){
        this.price = number;
    }

    public String getName (){
        return name;
    }

    public void setName(String drink){
        this.name = drink;
    }

}
