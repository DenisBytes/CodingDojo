import java.sql.Array;
import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.name = "Chinduri";
        order2.name = "Jimmy";
        order3.name = "Noah";
        order4.name = "Sam";

        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        item1.name = "mocha";
        item2.name = "latte";
        item3.name = "drip coffee";
        item4.name = "cappuccino";

        item1.price = 1;
        item2.price = 2;
        item3.price = 3;
        item4.price = 4;

        order2.items = new ArrayList<>();
        order2.items.add(item2);
        order2.total += item2.price;

        order3.items = new ArrayList<>();
        order3.items.add(item4);
        order3.total += item4.price;

        order4.items = new ArrayList<>();
        order4.items.add(item2);
        order4.total += item2.price;

        order1.items = new ArrayList<>();
        order1.items.add(item1);
        order1.total += item1.price;
        order1.ready = true;

        order4.items.add(item2);
        order4.total += item2.price;
        order4.items.add(item2);
        order4.total += item2.price;

        order2.ready = true;

        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
        for (Item i:order1.items){
            System.out.printf("Item: %s, Price: %.2f\n", i.name, i.price);
        }
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        for (Item i:order2.items){
            System.out.printf("Item: %s, Price: %.2f\n", i.name, i.price);
        }
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
        for (Item i:order3.items){
            System.out.printf("Item: %s, Price: %.3f\n", i.name, i.price);
        }
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        for (Item i:order4.items){
            System.out.printf("Item: %s, Price: %.2f\n", i.name, i.price);
        }
    }
}
