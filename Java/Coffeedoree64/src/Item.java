public class Item {
    public String name;
    public double price;
    public int index;
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getPrice(){return price;}

    public void setPrice(double number){this.price = number;}

    public String getName (){return name;}

    public void setName(String drink){this.name = drink;}

    public int getIndex() {return index;}

    public void setIndex(int index) {this.index = index;}
}
