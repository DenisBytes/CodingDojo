import java.util.ArrayList;
public class Order {

    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    // Constructors
    public Order (){
        this.name = "Guest";
        this.items = new ArrayList<>();
    }
    public Order (String name){
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Getters and Setters
    public String getName(){
        return name;
    }
    public void setName(String drink){
        this.name = drink;
    }
    public boolean isReady(){
        return ready;
    }
    public void setReady(boolean bool){
        this.ready = bool;
    }
    public ArrayList getItem(){
        return items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    // _________________________________

    public String getStatusMessage (){
        String statusMessage;
        if (this.ready == true){
            statusMessage = "Your order is ready";
        }
        else{
            statusMessage = "Thank you for waiting. Your order will be ready soon";
        }
        return statusMessage;
    }

    public double getOrderTotal(){
        double total = 0;
        for (Item item: items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        ArrayList<Item> orderItems = getItem();
        double total = getOrderTotal();

        System.out.println("Customer name: "+name);
        for (Item item: orderItems){
            System.out.println(item.getName() +": "+item.getPrice());
        }
        System.out.println("Total: "+getOrderTotal());

    }
}
