import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;
    int index = 0;
    Scanner scanner = new Scanner(System.in);
     public CoffeeKiosk(){
         this.menu= new ArrayList<Item>();
         this.orders = new ArrayList<Order>();
     }

     public void addMenuItem (String name, double price){
         Item item = new Item(name, price);
         menu.add(item);
         item.setIndex(menu.indexOf(item));
     }
     public void displayMenu(){
         for (Item item: menu){
             System.out.println(item.getIndex()+" "+item.name+" -- "+"$"+item.price);
         }
     }
     public void newOrder(){
         System.out.println("Please enter customer name for new order:");
         String name = scanner.nextLine();

         Order order = new Order(name);
         displayMenu();

         System.out.println("Please enter a menu item index or q to quit:");
         String itemNumber = scanner.next();

         while (!itemNumber.equals("q")){
             try{
                 order.addItem(menu.get(Integer.parseInt(itemNumber)));
             }catch(IndexOutOfBoundsException i){
                 System.out.println("Invalid selection");
             }catch(NumberFormatException n){
                 System.out.println("Invalid selection");
             }
             // Ask them to enter a new item index or q again, and take their input
             System.out.println("Please enter a menu item index or q to quit:");
             itemNumber = scanner.next();
         }
         order.display();
     }
}